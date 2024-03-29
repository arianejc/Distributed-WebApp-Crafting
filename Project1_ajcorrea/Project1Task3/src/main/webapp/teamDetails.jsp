<%-- Ariane Correa --%>
<%-- ajcorrea --%>

<%@ page import="com.example.project1task3.TeamPlayerStats" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Team Details</title>
    <style>
        /* Center-align the header and logo */
        .header-container {
            text-align: center;
        }
        /* Style the MLB Logo */
        .mlb-logo {
            width: 200px;
            height: 125px;
        }
        /* Align the Previous and Next buttons */
        .button-container {
            margin-top: 20px; /* Add spacing between buttons and content */
        }
        /* Style the Previous and Next buttons */
        .button{
            padding: 10px 20px;
            background-color: #007bff;
            color: #fff;
            text-decoration: none;
            margin: 0 10px;
            border-radius: 5px;
        }

    </style>
</head>
<body>
<div class="header-container">
    <h1>MAJOR LEAGUE BASEBALL 2023</h1>
    <img class="mlb-logo" src="https://wordsabovereplacement.com/wp-content/uploads/2020/06/mlb.png" alt="MLB Logo">
    <h5>MLB Logo From the website Link:<br><p>https://wordsabovereplacement.com/wp-content/uploads/2020/06/mlb.png</p><br></h5>

</div>

<h1>${teamName}</h1>

<h2><br><img src =${teamlogoUrl} width="200" height="125"/><br></h2>
<h5>Team Logo Scraped From the website Link:<br><p>https://www.sportslogos.net/teams/list_by_year/42023/2023_MLB_Logos/</p><br></h5>


<h2>About the Team</h2>
<h5>Team Information Scraped From the API Link:<br><p>https://statsapi.mlb.com/api/v1/teams</p><br></h5>

<h3>HeadQuarters:  ${locationName}</h3>
<h3>Season:  ${season}</h3>
<h3>Abbreviation:  ${abbreviation}</h3>
<h3>First Appeared In:  ${firstYearOfPlay}</h3>

<br><br>

<h2>The Team's Home Stadium</h2>
<h5>Home Stadium Information Scraped From the website Link:<br><p>https://geojango.com/pages/list-of-mlb-teams</p><br></h5>

<h3>${arenaName}</h3>

<br><br>

<h2>Featured Players</h2>
<h5>Player Information Scraped From the API Link:<br><p>https://statsapi.mlb.com/api/v1/stats?stats=season&group=hitting</p><br></h5>

    <c:forEach items="${playerDetails}" var="player">

            <h2>Player Name: <c:out value="${player.playerName}"/></h2>
            <h3>Rank: <c:out value="${player.rank}"/></h3>
            <h3>Games Played: <c:out value="${player.gamesPlayed}"/></h3>
            <h3>Ground Outs: <c:out value="${player.groundOuts}"/></h3>
            <h3>Air Outs: <c:out value="${player.airOuts}"/></h3>
            <h3>Runs: <c:out value="${player.runs}"/></h3>
            <h3>Doubles: <c:out value="${player.doubles}"/></h3>
            <h3>Triples: <c:out value="${player.triples}"/></h3>
            <h3>Home Runs:  <c:out value="${player.homeRuns}"/></h3>
            <h3>Strike Outs: <c:out value="${player.strikeOuts}"/></h3>
            <br><br>
    </c:forEach>


<br><br>
<div class="button-container">
    <a href="index.jsp" class="button">&laquo; Back</a>
</div>

</body>
</html>
