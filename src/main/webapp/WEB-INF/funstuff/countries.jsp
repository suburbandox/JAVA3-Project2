<%@ page import="fun_stuff.Country" %>
<%@ page import="java.util.List" %>
<%@ page import="java.text.DecimalFormat" %>
<%@ page import="java.util.Scanner" %>
<%@ page import="java.io.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    List<Country> countries = (List<Country>)request.getAttribute("countries");
    String show = "?show=" + (String)request.getAttribute("show");
    String sort = "&sort=" + (String)request.getAttribute("sort");
    String search = (String)request.getAttribute("search");
%>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Countries of the World</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">


    <style>
        img{
            height:175px
        }
        #map { height: 180px; }
    </style>
</head>
<body>
<header class="bg-primary">
    <nav class="navbar navbar-expand-lg navbar-light">
        <div class="container-fluid">
            <a class="navbar-brand text-light" href="#">Where in the World?</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">

                <form class="d-flex" action="countries" method="get">
                    <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search" name="search" value="<%= search %>">
                    <button class="btn btn-light" type="submit">Search</button>
                </form>
                <div class="dropdown ms-3">
                    <button class="btn btn-secondary dropdown-toggle" type="button" id="filterDropdown" data-bs-toggle="dropdown" aria-expanded="false">
                        Show
                    </button>
                    <ul class="dropdown-menu" aria-labelledby="filterDropdown">
                        <li><a class="dropdown-item" href="countries?show=all<%= sort %>">All</a></li>
                        <li><a class="dropdown-item" href="countries?show=Africa<%= sort %>">Africa</a></li>
                        <li><a class="dropdown-item" href="countries?show=Asia<%= sort %>">Asia</a></li>
                        <li><a class="dropdown-item" href="countries?show=Europe<%= sort %>">Europe</a></li>
                        <li><a class="dropdown-item" href="countries?show=Oceania<%= sort %>">Oceania</a></li>
                        <li><a class="dropdown-item" href="countries?show=North+America<%= sort %>">North America</a></li>
                        <li><a class="dropdown-item" href="countries?show=South+America<%= sort %>">South America</a></li>
                    </ul>
                </div>
                <div class="dropdown ms-3">
                    <button class="btn btn-secondary dropdown-toggle" type="button" id="sortDropdown" data-bs-toggle="dropdown" aria-expanded="false">
                        Sort
                    </button>
                    <ul class="dropdown-menu" aria-labelledby="sortDropdown">
                        <li><a class="dropdown-item" href="countries<%= show %>&sort=alphaAZ">Alphabetical (A to Z)</a></li>
                        <li><a class="dropdown-item" href="countries<%= show %>&sort=alphaZA">Alphabetical (Z to A)</a></li>
                        <li><a class="dropdown-item" href="countries<%= show %>&sort=populationAsc">Population (Low to High)</a></li>
                        <li><a class="dropdown-item" href="countries<%= show %>&sort=populationDesc">Population (High to Low)</a></li>
                    </ul>
                </div>
            </div>
        </div>
    </nav>

</header>

<img src="image/download.jpg"alt="kirby">
<img src="image/kirby.png"alt="kirby">
<div class="container my-4">
    <p class="lead">Showing <%= countries.size() %> countr<%= countries.size() == 1 ? "y" : "ies" %></p>
    <div class="row">
        <% for(Country country: countries) { %>
        <div class="col-sm-12 col-md-6 col-lg-4 col-xl-3">
            <div class="card mb-4" style="width: 18rem;">
                <img src="https://flagcdn.com/<%= country.getPic()%>.svg" class="card-img-top" alt="Flag of <%= country.getName() %>">
                <div class="card-body">
                    <h5 class="card-title"><%= country.getName() %></h5>
                    <p class="card-text">Region: <%= country.getContinent() %>
                        <% DecimalFormat df = new DecimalFormat("###,###,###");
                            Double i = Double.valueOf(country.getPopulation());
                            String n = df.format(i);
                        %>
                        <br>Population: <%= n %>
                        <br>Capital: <%= country.getCap() %>


                    </p>
                    <button type="button" class="btn btn-primary btn-open" data-bs-toggle="modal" data-bs-target="#countryModal"
                            data-title="<%= country.getName() %>"
                            data-population="<%= country.getPopulation() %>"
                            data-region="<%= country.getContinent() %>"
                            data-lat="<%= country.getLat() %>"
                            data-lon="<%= country.getLon() %>"
                            data-cap="<%= country.getCap() %>"
                            data-sub="<%= country.getSub() %>"
                            data-area="<%= country.getArea() %>"


                    >
                        Show more
                    </button>
                </div>
            </div>
        </div>

        <% } %>
    </div>
</div>

<div class="modal fade" id="countryModal" tabindex="-1" aria-labelledby="countryModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered modal-dialog-scrollable">
        <div class="modal-content">
            <div class="modal-header">
                <h1 class="modal-title fs-5" id="countryModalLabel">Modal title</h1>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <p>Region: <span class="modal-region"></span>
                    <br>Population: <span class="modal-population"></span>
                    <br>Capital: <span class="modal-cap"></span>
                    <br>Sub-Region: <span class="modal-sub"></span>
                    <span class="modal-map"></span>
                </p>
<%--                <iframe--%>
<%--                        <% String red = "-15.79" ;%>--%>
<%--                <span class="modal-lat"></span>--%>
<%--                        <% %>--%>
<%--                        <% String lon = "-15.79" ;%>--%>


<%--                        width="100%"--%>
<%--                        height="480"--%>
<%--                        frameborder="0"--%>
<%--                        scrolling="no"--%>
<%--                        marginheight="0"--%>
<%--                        marginwidth="0"--%>
<%--                        src="https://maps.google.com/maps?q=-15.79,-47.88&amp;z=4&amp;output=embed"--%>
<%--                ></iframe>--%>
<%--                <br>--%>
<%--                <a--%>
<%--                        href="https://www.google.com/maps/@-15.79,-47.88,4z"--%>
<%--                        target="_blank">--%>
<%--                    See full page map--%>
<%--                </a>--%>
<%--                <% String n = red;--%>
<%--                    String s = String.format("https://maps.google.com/maps?q= %s,%s&amp;z=4&amp;output=embed","red","blue" );--%>


<%--                %>--%>
<%--                <h5><%= s%></h5>--%>
<%--                <h5>`this is a {0},"good"`</h5>--%>


            </div>
        </div>
    </div>
</div>

<script src="https://code.jquery.com/jquery-3.6.4.slim.min.js"
        integrity="sha256-a2yjHM4jnF9f54xUQakjZGaqYs/V1CYvWpoqZzC2/Bw="
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
        crossorigin="anonymous"></script>
<script src="scripts/countries.js"></script>
</body>
</html>