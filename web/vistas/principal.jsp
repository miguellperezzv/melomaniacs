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
        <script src="https://kit.fontawesome.com/151fccfd32.js" crossorigin="anonymous"></script>
        <link href="${pageContext.request.contextPath}/CSS/estilos.css" rel="stylesheet" type="text/css"/>
        <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@700&display=swap" rel="stylesheet">
    </head>
    <body style="background-color: rgba(0,0,0,0.8);">

        <div id="nav-placeholder">

        </div>

        <div class="container mt-2" >

            <br>
            <br>
            <label id="tituloPaginas">  Nuevos en melomaniacs</label>
            <hr>
            <div class="row">


                <c:forEach var = "l" items = "${lanzamientos}" >
                    <div class="col-lg-3">

                        <div class="card-body">
                            <center>
                                <img src="${l.getI_lanzamiento()}" width="230  " height="230" alt=""/>
                            </center>

                        </div>
                        <div class="card-footer ">
                            <center>
                                <div>
                                    <label  > <i class="fas fa-compact-disc"></i> <a href="ControladorLanzamiento?accion=ArtistaPage&k_lanzamiento=${l.getK_lanzamiento()}&k_artista=${l.getK_artista()}" id="lblLanzamiento"> ${l.getN_lanzamiento()}</a></label> <br>
                                </div>
                                <div>
                                    <label > <i class="fas fa-microphone"></i><a href="#" id="lblArtista"> ${l.getK_artista_nombre()}</a></label>
                                </div>
                            </center>

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
