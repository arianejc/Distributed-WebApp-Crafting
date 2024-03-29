// Ariane Correa
// ajcorrea

package com.example.project1task3;

import com.google.gson.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;


public class TeamModel {

    //urls

    //website 1: for list of mlb teams
    String teamNameScrapperUrl = "https://www.espn.com/mlb/teams";
    //api 1: for mlb team information
    String teamInfoUrl = "https://statsapi.mlb.com/api/v1/teams";
    //website 2: for mlb team logos
    String logoUrl = "https://www.sportslogos.net/teams/list_by_year/42023/2023_MLB_Logos/";
    //api 2: for mlb team top hitter stats
    String playerStatsUrl = "https://statsapi.mlb.com/api/v1/stats?stats=season&group=hitting";
    //website 3: for mlb team home stadium info
    String stadiumUrl = "https://geojango.com/pages/list-of-mlb-teams";


    /**
     * Scrapes MLB team names from "https://www.espn.com/mlb/teams" and stores them in "teams.txt".
     *
     * @throws IOException If an IO error occurs during web scraping or file writing.
     */
    void ScrapeTeamName() throws IOException {
        // Use Jsoup to fetch HTML data into a document
        Document doc = Jsoup.connect(teamNameScrapperUrl).get();

        // Select the HTML elements that contain team names
        Elements elem = doc.select(".TeamsWrapper");
        Elements table = elem.select(".ContentList__Item");

        // Define the path for the output text file
        String outputPath = "teams.txt";
        Path path = Paths.get(outputPath);

        try (FileWriter writer = new FileWriter(path.toFile())) {
            // Loop through the HTML elements and extract team names
            for (Element e : table) {
                Element h2 = e.select("h2").first();
                if (h2 != null) {
                    String teamName = h2.text();
                    // Write the team name to the output text file
                    writer.write(teamName + "\n");
                }
            }
            // Notify the user when team names have been successfully scraped and saved to teams.txt
            System.out.println("Scraped data has been saved to teams.txt");
        } catch (IOException e) {
            // Handle any IOException that may occur during file writing
            System.err.println("Error writing to the file: " + e.getMessage());
        }
    }



    /**
     * Reads the contents of a text file line by line and returns them as a list of strings.
     *
     * @param filePath The path to the text file to be read.
     * @return A list of strings where each string represents a line from the text file.
     */
     public List<String> readTxtFile(String filePath) {
        List<String> lines = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line); // Add each line to the list
            }
        } catch (IOException e) {
            e.printStackTrace(); // Handle any IO exception that may occur
        }

        return lines; // Return the list of lines read from the file
    }

    /**
     * Fetches JSON data from a given API URL.
     *
     * @param apiUrl The URL of the API to fetch JSON data from.
     * @return A String containing the fetched JSON data.
     * @throws IOException If an IO error occurs during the HTTP request or response reading.
     */
    public String fetchJsonData(String apiUrl) throws IOException {
        // Create a URL object using the provided API URL
        URL url = new URL(apiUrl);

        // Open a connection to the URL using HttpURLConnection
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        // Create a BufferedReader to read the response from the connection
        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

        // Create a StringBuilder to accumulate the JSON data
        StringBuilder jsonData = new StringBuilder();
        String line;

        // Read each line of the response and append it to the JSON data StringBuilder
        while ((line = reader.readLine()) != null) {
            jsonData.append(line);
        }

        // Close the BufferedReader and disconnect the connection
        reader.close();
        connection.disconnect();

        // Return the fetched JSON data as a String
        return jsonData.toString();
    }


    /**
     * Parses and extracts specific fields from JSON data to create a list of TeamInfo objects.
     *API Link: "https://statsapi.mlb.com/api/v1/teams"
     * @param jsonData   The JSON data to parse and extract information from.
     * @param fileData   A list of team names to filter the extracted data.
     * @return A list of TeamInfo objects containing the extracted information.
     */
    public List<TeamInfo> extractTeamInfo(String jsonData, List<String> fileData) {
        List<TeamInfo> teamInfoList = new ArrayList<>();

        // Create a JSON parser to parse the JSON data
        JsonParser jsonParser = new JsonParser();
        JsonObject rootObject = jsonParser.parse(jsonData).getAsJsonObject();

        // Extract team data
        for (JsonElement teamElement : rootObject.get("teams").getAsJsonArray()) {
            TeamInfo teamInfo = new TeamInfo();
            JsonObject teamObject = teamElement.getAsJsonObject();

            // Check if the team's name is present in the provided list
            if (fileData.contains(teamObject.get("name").getAsString())) {
                // Extract and set team information
                teamInfo.setName(teamObject.get("name").getAsString());
                teamInfo.setLocationName(teamObject.get("locationName").getAsString());
                teamInfo.setSeason(teamObject.get("season").getAsInt());
                teamInfo.setAbbreviation(teamObject.get("abbreviation").getAsString());
                teamInfo.setFirstYearOfPlay(teamObject.get("firstYearOfPlay").getAsString());

                // Add the TeamInfo object to the list
                teamInfoList.add(teamInfo);

                // Print the extracted TeamInfo object
                System.out.println(teamInfo);
            }
        }



        return teamInfoList;
    }

    /**
     * Extracts stadium information from a web page using Jsoup.
     *
     * @return A map where keys are team names and values are combined stadium information.
     * @throws IOException If an error occurs while fetching or parsing the HTML data.
     */
    public Map<String,String>  extractStadiumInfo() throws IOException {
        Map<String, String> combinedMap = new HashMap<>();
        // Jsoup to fetch HTML data into a document
        Document doc = null;
        try {
            doc = Jsoup.connect(stadiumUrl).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (doc == null) {
            System.out.println("Failed to fetch the HTML document.");
            return Collections.emptyMap();
        }
        Element table = doc.select("table").first();
        if (table == null) {
            System.out.println("Table element not found in the HTML document.");
            return Collections.emptyMap();
        }
        Elements rows = table.select("tr");
        // Create a new map to combine the values
        Map<String, String> stadiumMap = new HashMap<>();

        for (int i = 1; i < rows.size(); i++) {
            Element row = rows.get(i);
            Elements columns = row.select("td");

            // Extract data from the columns
            String teamName = columns.get(0).text();
            String value1 = columns.get(1).text();
            String value2 = columns.get(2).text();
            String value3 = columns.get(3).text();
            String value4 = columns.get(4).text();

            // Combine the values into a single string and put it into the combined map
            String combinedValue = value1 + " | " + value2 + " | " + value3 + " | " + value4;
            stadiumMap.put(teamName, combinedValue);
        }
        return stadiumMap;
    }

    public String fetchStadiumInfo(String teamName) throws IOException {

        Map<String, String> stadiumInfo = extractStadiumInfo();
        String stadiumData = null;

        for (Map.Entry<String,String> entry : stadiumInfo.entrySet()){
            if(entry.getKey().equals(teamName)){
                System.out.println(entry.getKey() +"~~~" + entry.getValue());
                stadiumData = entry.getValue();
                break;
            }
    }
        return  stadiumData;
    }



    /**
     * Scrapes MLB team logos from the specified URL: "https://www.sportslogos.net/teams/list_by_year/42023/2023_MLB_Logos/"
     *
     * @return A map containing team names as keys and their corresponding image source URLs as values.
     *         An empty map is returned if no logos are found or if there was an issue during scraping.
     * @throws IOException If an I/O exception occurs while fetching or parsing the HTML data.
     */
    public Map<String, String> fetchLogoMap() throws IOException {
        // Jsoup to fetch HTML data into a document
        Document doc = Jsoup.connect(logoUrl).get();

        // Select the HTML element containing the logos
        Element logoWall = doc.select("ul[class=logoWall]").first();

        if (logoWall == null) {
            System.out.println("Table element not found in the HTML document.");
            return Collections.emptyMap();
        }

        // Create a map to store team name as the key and img src as the value
        Map<String, String> teamLogoMap = new HashMap<>();

        // Select all <a> elements within the logoWall
        Elements anchorElements = logoWall.select("a");

        for (Element anchorElement : anchorElements) {
            // Extract team name and img src
            String teamName = anchorElement.text();
            String imgSrc = anchorElement.select("img").attr("src");

            // Put the data into the map
            teamLogoMap.put(teamName, imgSrc);
        }

        return teamLogoMap;
    }


    /**
     * Extracts and parses team player statistics from the given JSON data.
     * API Link: "https://statsapi.mlb.com/api/v1/stats?stats=season&group=hitting"
     * @param jsonData JSON data containing team player statistics.
     * @return A list of TeamPlayerStats objects representing individual player statistics.
     */
    public List<TeamPlayerStats> extractTeamPlayerStats(String jsonData) {
        List<TeamPlayerStats> teamPlayerStatsList = new ArrayList<>();
        JsonParser jsonParser = new JsonParser();
        JsonArray jsonArray = jsonParser.parse(jsonData).getAsJsonObject()
                .get("stats").getAsJsonArray().get(0)
                .getAsJsonObject().get("splits").getAsJsonArray();
        for (JsonElement jsonElement : jsonArray) {
            JsonObject jsonObject = jsonElement.getAsJsonObject();
            TeamPlayerStats teamPlayerStats = new TeamPlayerStats();

            // Extract rank
            teamPlayerStats.setRank(!jsonObject.get("rank").isJsonNull() ? jsonObject.get("rank").getAsInt() : 0);

            // Extract team[name]
            JsonObject teamObject = jsonObject.getAsJsonObject("team");
            teamPlayerStats.setTeamName(teamObject.get("name").getAsString());

            // Extract player[fullName]
            JsonObject playerObject = jsonObject.getAsJsonObject("player");
            teamPlayerStats.setPlayerName(playerObject.get("fullName").getAsString());

            // Extract player statistics
            JsonObject statObject = jsonObject.getAsJsonObject("stat");
            teamPlayerStats.setGamesPlayed(statObject.get("gamesPlayed").getAsInt());
            teamPlayerStats.setGroundOuts(statObject.get("groundOuts").getAsInt());
            teamPlayerStats.setAirOuts(statObject.get("airOuts").getAsInt());
            teamPlayerStats.setRuns(statObject.get("runs").getAsInt());
            teamPlayerStats.setDoubles(statObject.get("doubles").getAsInt());
            teamPlayerStats.setTriples(statObject.get("triples").getAsInt());
            teamPlayerStats.setHomeRuns(statObject.get("homeRuns").getAsInt());
            teamPlayerStats.setStrikeOuts(statObject.get("strikeOuts").getAsInt());
            teamPlayerStats.setAverage(statObject.get("avg").getAsString());

            teamPlayerStatsList.add(teamPlayerStats);
        }
        return teamPlayerStatsList;
    }


    public List<TeamPlayerStats> fetchPlayersFromStadium(String teamName) throws IOException {
        List<TeamPlayerStats> teamPlayerStats = new ArrayList<>();

        // Fetch JSON data from the API
        String statsJsonData = fetchJsonData(playerStatsUrl);

        // Parse and extract the specific fields
        List<TeamPlayerStats> teamPlayerStatsList = extractTeamPlayerStats(statsJsonData);

        for(TeamPlayerStats playerStats :  teamPlayerStatsList){
            System.out.println(playerStats.getTeamName());
            if(playerStats.getTeamName().contains(teamName))
                teamPlayerStats.add(playerStats);
        }

        return teamPlayerStats;


    }

    public TeamInfo fetchTeamInfo(String teamName) throws IOException {

        TeamInfo info = new TeamInfo();

        String teamInfoJsonData = fetchJsonData(teamInfoUrl);
        List<String> fileData = readTxtFile("teams.txt");
        List<TeamInfo> teamInfoList = extractTeamInfo(teamInfoJsonData, fileData);

        for(TeamInfo teamInfo : teamInfoList){
            if(teamInfo.getName().equals(teamName)){
                info = teamInfo;
                break;
            }
        }




        return info;
    }

}
