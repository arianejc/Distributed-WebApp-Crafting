<!-- Ariane Correa -->
<!-- ajcorrea -->

<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Results for Distributed Systems Class Clicker</title>
    <style>
        body {
            font-family: Arial, sans-serif;
        }
        h1 {
            color: #333;
        }
        h3 {
            margin: 10px;
            padding: 5px;
            background-color: #f5f5f5;
            border: 1px solid #ddd;
        }
    </style>
</head>
<body>
<h1>Distributed Systems Class Clicker</h1>
<%
    Map<String, Integer> choiceMap = (HashMap<String, Integer>) request.getAttribute("choiceMap");
    if (choiceMap.isEmpty()) {
        out.print("<br/>");
        out.print("<h3> There are currently no results </h3>");
    } else {
        out.print("<br/>");
        out.print("<h3> The results from the server are as follows: </h3>");
        for (Map.Entry<String, Integer> entry : choiceMap.entrySet()) {
            out.print("<h3>" + entry.getKey() + " : " + entry.getValue() + "</h3>");
        }
    }
%>
</body>
</html>
