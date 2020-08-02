<%-- 
    Document   : principal
    Created on : 31-jul-2020, 17:40:03
    Author     : luisy
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="modelo.Lanzamiento"%>
<%@page import="java.util.List"%>
<%@page import="modeloDAO.LanzamientoDAO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inicio</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">

    </head>
    <body>

        <div id="nav-placeholder">

        </div>


        <div class="container mt-2">
            <div class="row">


                <c:forEach var = "l" items = "${lanzamientos}" >
                    <div class="col-sm-4">
                        <div class="card-header">
                            ${l.getK_artista() }
                            -
                            ${l.getN_lanzamiento()}

                        </div>
                        <div class="card-body">
                            <i> $80000 </i>

                            <img src="/img/CHROMATICA.jpg" width="200" height="200">

                        </div>
                        <div class="card-footer">
                            <label>ALBUM DEL AÑO . PERIOD</label>
                            <DIV>
                                <a class="btn btn-outline-success">Comprar</a>
                                <a class="btn btn-outline-info">Info</a>
                            </DIV>
                        </div>
                    </div>
                </c:forEach>



            </div>

        </div>


        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
        <script src="//code.jquery.com/jquery.min.js"></script>
        <script>
            $(function () {
                $("#nav-placeholder").load("vistas/nav.jsp");
            });


        </script>


    </body>
</html>
