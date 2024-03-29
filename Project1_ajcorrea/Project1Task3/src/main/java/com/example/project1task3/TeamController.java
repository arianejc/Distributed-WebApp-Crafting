// Ariane Correa
// ajcorrea

package com.example.project1task3;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;
import java.util.Map;



@WebServlet(name = "fetch-team-details", value = "/fetch-team-details")
public class TeamController extends HttpServlet {

    String teamNameScrapperUrl = "https://www.espn.com/mlb/teams";
    String teamInfoUrl = "https://statsapi.mlb.com/api/v1/teams";
    String logoUrl = "https://www.sportslogos.net/teams/list_by_year/42023/2023_MLB_Logos/";
    String playerStatsUrl = "https://statsapi.mlb.com/api/v1/stats?stats=season&group=hitting";
    String stadiumUrl = "https://geojango.com/pages/list-of-mlb-teams";

    TeamView teamDetailsView = new TeamView();
    TeamModel teamDetailsModel = new TeamModel();

    public void init() {
        try {

            // writing into text file

            teamDetailsModel.ScrapeTeamName();
            List<String> fileData = teamDetailsModel.readTxtFile("teams.txt");

            String teamInfoJsonData = teamDetailsModel.fetchJsonData(teamInfoUrl);
            // Parse and extract the specific fields
            List<TeamInfo> teamInfoList = teamDetailsModel.extractTeamInfo(teamInfoJsonData, fileData);
            // Map used to store Team Logos
            Map<String, String> fetchLogoMap = teamDetailsModel.fetchLogoMap();

            Map<String,String> stadiumInfo  = teamDetailsModel.extractStadiumInfo();

            //setting Data
            teamDetailsView.setTeamInfoList(teamInfoList);
            teamDetailsView.setTeamLogoMap(fetchLogoMap);
            teamDetailsView.setStadiumMap(stadiumInfo);




        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        request.setAttribute("teamNameScrapperUrl",teamNameScrapperUrl);
        // select path for file which will store the scraped mlb team names


        // Fetch JSON data from the API
        response.setContentType("text/html");
        String teamName = request.getParameter("team").replace("%20"," ");


        List<TeamPlayerStats> playerDetails = teamDetailsModel.fetchPlayersFromStadium(teamName);
        System.out.println(playerDetails.size());
        TeamInfo teamInfo = teamDetailsModel.fetchTeamInfo(teamName);

        String stadiumInfo = teamDetailsModel.fetchStadiumInfo(teamName);
        System.out.println("qwerthjkhgfds" + stadiumInfo);

        request.setAttribute("teamName", teamName);
        request.setAttribute("teamlogoUrl",teamDetailsView.getTeamLogoMap().get(teamName));
        request.setAttribute("playerDetails",playerDetails);


        request.setAttribute("locationName", teamInfo.getLocationName());
        request.setAttribute("season", teamInfo.getSeason());
        request.setAttribute("abbreviation", teamInfo.getAbbreviation());
        request.setAttribute("firstYearOfPlay", teamInfo.getFirstYearOfPlay());

        request.setAttribute("arenaName",stadiumInfo);


        // Transfer control over the the correct "view"
    RequestDispatcher view = request.getRequestDispatcher("teamDetails.jsp");
    view.forward(request, response);

    }


    public void destroy() {
    }
}
