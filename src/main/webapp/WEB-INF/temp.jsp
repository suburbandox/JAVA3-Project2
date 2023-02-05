<%--
  Created by IntelliJ IDEA.
  User: clwoo
  Date: 2/1/2023
  Time: 2:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Map<String,String> results = (Map<String,String>)request.getAttribute("results");
    if(results == null) {
        results = new HashMap<>();
    }
    String temp = results.containsKey("temp") ? results.get("temp") : "help";
    String num = results.containsKey("num") ? results.get("num") : "";
    String redrum = results.containsKey("r") ? results.get("r") : "";
    String equals = results.containsKey("temp") ? results.get("temp") : "";
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>CHANGE THE TITLE</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
</head>
<body>
<header>
    <h1>Temperature Conversion Calculator</h1>
    <p>Please enter the temperature in degrees F or C that you want to convert, then click one of the blue conversion buttons and you can calculate the temperature in the other scale)</p>
</header>

<form action="temp" method="post" class="cool-form">
    <div class="btn-group" role="group" aria-label="Basic radio toggle button group">
        <input type="radio" class="btn-check" name="btnradio" id="btnradio1" value="Celsius"  >
        <label class="btn btn-outline-primary" for="btnradio1">Celsius To Fahrenheit</label>

        <input type="radio" class="btn-check" name="btnradio" id="btnradio2" value="Fahrenheit">
        <label class="btn btn-outline-primary" for="btnradio2" >Fahrenheit to Celsius</label>

    </div>

    <div class="input-container">
        <input type="text" name="degrees" id="height" value />
    </div>

    <input type="submit" value="Calculate Temp" />
</form>
<p>The conversion formula and result:  <%=   equals%></p>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
        crossorigin="anonymous"></script>
</body>
</html>