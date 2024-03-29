<%@ page import="java.util.List" %>
<%@ page import="com.example.project1task3.TeamModel" %><%-- Ariane Correa --%>
<%-- ajcorrea --%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Project 1: Task 3</title>
    <style>
        body {
            text-align: center;
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
        }

        h1 {
            color: #333;
        }

        h2 {
            color: #333;
        }

        img {
            width: 200px; /* Adjust the size as needed */
        }

        form {
            margin-top: 20px;
        }

        select {
            padding: 5px;
            font-size: 16px;
        }

        input[type="submit"] {
            padding: 10px 20px;
            background-color: #007bff;
            color: #fff;
            border: none;
            cursor: pointer;
        }

        input[type="submit"]:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>

<h1>MAJOR LEAGUE BASEBALL 2023</h1>

<img src="https://wordsabovereplacement.com/wp-content/uploads/2020/06/mlb.png" alt="MLB Logo">
<h5>MLB Logo From the website Link:<br><p>https://wordsabovereplacement.com/wp-content/uploads/2020/06/mlb.png</p><br></h5>

<h2>PARTICIPATING TEAMS</h2>

<h5>Team Names Scraped From the website Link:<br><p>https://www.espn.com/mlb/teams</p><br></h5>

<form method="get" action="fetch-team-details" enctype="text/plain">
    <label for="team">Choose a Team:</label><br><br>
    <select name="team" id="team">

        <%

            TeamModel teamDetailsModel = new TeamModel();
            List<String> fileDataList = teamDetailsModel.readTxtFile("teams.txt");

            for(int i =0; i< fileDataList.size() ; i++){
                String team = fileDataList.get(i);
                String teamNoSpace = team.replace(" ","%20");
        %>
        <option value=<%=teamNoSpace%>><%=team%></option>
        <%
            }
        %>
    </select>
    <br><br><input type="submit" value="Submit"/>
</form>
<br/>
</body>
</html>
