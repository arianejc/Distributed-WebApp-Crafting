<!-- Ariane Correa -->
<!-- ajcorrea -->

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Distributed Systems Class Clicker</title>
    <style>
        body {
            font-family: Arial, sans-serif;
        }
        h1 {
            color: #333;
        }
        form {
            margin: 20px;
        }
        label {
            font-weight: bold;
        }
    </style>
</head>
<body>
<h1>Distributed Systems Class Clicker</h1>
<br/>
<h4>Submit your answer to the current question:</h4>
<p>${message}</p>
<form method="get" action="submit" enctype="text/plain">
    <input type="radio" id="choiceA" name="choice" value="A">
    <label for="choiceA">A</label><br>
    <input type="radio" id="choiceB" name="choice" value="B">
    <label for="choiceB">B</label><br>
    <input type="radio" id="choiceC" name="choice" value="C">
    <label for="choiceC">C</label><br>
    <input type="radio" id="choiceD" name="choice" value="D">
    <label for="choiceD">D</label><br>
    <input type="submit" value="Submit" />
</form>
</body>
</html>
