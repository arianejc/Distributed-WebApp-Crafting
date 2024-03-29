<!-- Ariane Correa -->
<!-- ajcorrea -->

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Compute Hash</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f0f0;
        }
        h1 {
            color: #333;
        }
        form {
            background-color: #fff;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            max-width: 400px;
            margin: 0 auto;
        }
        input[type="text"] {
            width: 100%;
            padding: 10px;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }
        label {
            display: block;
            font-weight: bold;
        }
        input[type="radio"] {
            margin-right: 5px;
        }
        input[type="submit"] {
            background-color: #007bff;
            color: #fff;
            border: none;
            padding: 10px 20px;
            border-radius: 4px;
            cursor: pointer;
        }
        input[type="submit"]:hover {
            background-color: #0056b3;
        }
        h4 {
            margin-top: 20px;
            font-size: 16px;
        }
    </style>
</head>
<body>
<h1>Compute Hash Value</h1>
<form method="get" action="compute-hashes" enctype="text/plain">
    <label for="inputValue">Type String value:</label>
    <input type="text" id="inputValue" name="inputValue" placeholder="Enter a string value" /><br>
    <label>Hash Type:</label>
    <input type="radio" name="hashType" value="MD5" checked="true" />MD5
    <input type="radio" name="hashType" value="SHA-256" />SHA-256<br>
    <input type="submit" value="Submit" />
</form>

<h4>Input Value: ${inputValue}</h4>
<h4>Base64 Encoded Value: ${base64EncodedValue}</h4>
<h4>Hexadecimal Encoded Value: ${hexEncodedValue}</h4>
</body>
</html>
