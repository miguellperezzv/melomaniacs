<%-- 
    Document   : index
    Created on : 31-jul-2020, 17:31:36
    Author     : luisy
--%>
<%@page import="modelo.Lanzamiento"%>
<%@page import="java.util.List"%>
<%@page import="modeloDAO.LanzamientoDAO"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>

        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
        <script src="https://kit.fontawesome.com/151fccfd32.js" crossorigin="anonymous"></script>
        <link href="${pageContext.request.contextPath}/CSS/estilos.css" rel="stylesheet" type="text/css"/>
        <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@700&display=swap" rel="stylesheet">

        <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
        <link rel="stylesheet" href="/resources/demos/style.css">

        <title>melomaniacs</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

    </head>
    <body>


        <div id="nav-placeholder">

        </div>


        <div class="grid-container">
            <div class="PRINCIPAL">
                <div class="INFO" id="jumbo">
                    <div class="jumbotron" id="jumbotron" style="background-color: #000000;">
                        <h1 class="display-4" style="color: #ffffff">Bienvenido a <h2 style="color: #fefe22"> Melomaniacs!</h2></h1>
                        <p class="lead" style="color: #ffffff">El lugar donde podrás intercambiar y obtener tu música favorita.</p>
                        <hr class="my-4">
                        <p style="color: #ffffff">Inicia Sesión </p>
                        <p class="lead">
                            <a class="btn btn-primary btn-lg" href="#" role="button" style="background-color: #fefe22; color: #000000">Entrar</a>
                        </p>
                    </div>

                </div>
                <div class="SESION" style="background-color: #000000">
                    <h2 style="color: #fefe22"><center><strong>búsqueda</strong></center></h2>
                    <div class="row">
                        <div class="col-md-4" id="padrebusq"><a href="ControladorBuscar?accion=generos">
                                <div  id="busq"><br><center> <i class="fas fa-guitar fa-5x" style="color: black;"></i> <br><br><h2 style="color: #000000; font-size: 16px;"> generos </h2></center></div>

                            </a></div>
                        <div class="col-md-4" id="padrebusq"><a href="ControladorBuscar?accion=decada">
                                <div  id="busq"><br><center> <i class="fas fa-birthday-cake fa-5x" style="color: black;" ></i> <br><br><h2 style="color: #000000; font-size: 16px;"> décadas</h2></center></div>

                            </a> </div>
                        <div class="col-md-4" id="padrebusq"><a href="ControladorBuscar?accion=vinilo">
                                <div  id="busq"><br><center> <i class="fas fa-record-vinyl fa-5x" style="color: black;"></i> <br><br><h2 style="color: #000000; font-size: 16px;"> vinilos</h2></center></div>

                            </a> </div>
                    </div>

                    <BR>
                    <div class="row">
                        <div class="col-md-4" id="padrebusq" ><a href="ControladorBuscar?accion=intercambio">
                                <div  id="busq"><br><center> <i class="fas fa-exchange-alt fa-5x" style="color:black;"></i> <br><br><h2 style="color: #000000; font-size: 16px;"> intercambio </h2></center></div>

                            </a>   </div>
                        <div class="col-md-4" id="padrebusq"><a href="ControladorBuscar?accion=vendidos">
                                <div  id="busq"><br><center> <i class="fas fa-fire fa-5x" style="color: black;"></i> <br><br><h2 style="color: #000000; font-size: 16px;">más vendidos </h2></center></div>

                            </a> </div>
                        <div class="col-md-4" id="padrebusq"><a href="ControladorBuscar?accion=casette">
                                <div  id="busq"><br><center> <i class="fas fa-volume-up fa-5x" style="color: black;"></i> <br><br><h2 style="color: #000000; font-size: 16px;"> casettes </h2></center></div>

                            </a>    </div>
                    </div>

                </div>
            </div>
            <div class="CARRUSEL" style="background-color: #1f1f1f;">


                <div class="NUEVOSLANZAMIENTOS" style="background-color: #1f1f1f;">
                    <center><h2 id="subtituloInfo" style="font-size: 30px"> Nuevos Lanzamientos</h2></center>
                    <center><div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel" width="300" height="300">

                            <div class="carousel-inner"  >

                                <c:forEach var='l' items="${nuevos}" varStatus="i">
                                    <c:choose>
                                        <c:when test="${i.index==0}">
                                            <div class="carousel-item active" >
                                                <img class="d-block w-100" src="${l.getI_lanzamiento()}" alt="First slide" >
                                                <div class="carousel-caption d-none d-md-block" id="textCarrusel">
                                                    <a href="ControladorLanzamiento?accion=LanzamientoPage&k_lanzamiento=${l.getK_lanzamiento()}&k_artista=${l.getK_artista()}"><h5 >${l.getN_lanzamiento()}</h5></a>
                                                    <a href="ControladorArtista?accion=ArtistaPage&k_artista=${l.getK_artista()}" style="color:white"><p>${adao.setArtista(l.getK_artista()).getN_artista()}</p></a>
                                                </div>
                                            </div>
                                        </c:when>    
                                        <c:otherwise>
                                            <div class="carousel-item" >
                                                <img class="d-block w-100" src="${l.getI_lanzamiento()}" alt="First slide" >
                                                <div class="carousel-caption d-none d-md-block" id="textCarrusel">
                                                    <div>
                                                        <a href="ControladorLanzamiento?accion=LanzamientoPage&k_lanzamiento=${l.getK_lanzamiento()}&k_artista=${l.getK_artista()}"><h5 >${l.getN_lanzamiento()}</h5></a>
                                                        <a href="ControladorArtista?accion=ArtistaPage&k_artista=${l.getK_artista()}" style="color:white"><p>${adao.setArtista(l.getK_artista()).getN_artista()}</p></a>
                                                    </div>  

                                                </div>
                                            </div>
                                        </c:otherwise>
                                    </c:choose>



                                </c:forEach>


                            </div>
                            <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
                                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                                <span class="sr-only">Previous</span>
                            </a>
                            <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
                                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                                <span class="sr-only">Next</span>
                            </a>
                        </div></center>

                    <center></center>


                </div>
                <div class="LISTAMASVENDIDOS">

                    <center><h2 id="subtituloInfo" style="font-size: 30px"> Más Vendidos</h2></center>
                </div>
                <div class="NUEVOSPRODUCTOS">
                    <center><h2 id="subtituloInfo" style="font-size: 30px"> Nuevos Productos</h2></center>
                    <center><div id="carouselExampleIndicators2" class="carousel slide" data-ride="carousel" width="300" height="300">

                            <div class="carousel-inner"  >

                                <c:forEach var='p' items="${lista}" varStatus="i">
                                    <c:choose>
                                        <c:when test="${i.index==0}">
                                            <div class="carousel-item active" >
                                                <img class="d-block w-100" src="${ldao.getLanzamientoProducto(p.getK_producto()).getI_lanzamiento()}" alt="First slide" >
                                                <div class="carousel-caption d-none d-md-block" id="textCarrusel">

                                                    <a href="ControladorLanzamiento?accion=LanzamientoPage&k_lanzamiento=${ldao.getLanzamientoProducto(p.getK_producto()).getK_lanzamiento()}&k_artista=${ldao.getLanzamientoProducto(p.getK_producto()).getK_artista()}"><h5 >${ldao.getLanzamientoProducto(p.getK_producto()).getN_lanzamiento()}</h5></a>
                                                    <a href="ControladorArtista?accion=ArtistaPage&k_artista=${ldao.getLanzamientoProducto(p.getK_producto()).getK_artista()}" style="color:white"><p>${ldao.getLanzamientoProducto(p.getK_producto()).getK_artista_nombre()}</p></a>


                                                    <a href="ControladorProducto?accion=ProductoPage&k_producto=${p.getK_producto()}" style="color:white"><strong><p>${p.getK_estado()} - ${p.getK_formato()}</p> </strong></a>
                                                    <strong><p>${p.getPrecio()}</p> </strong>

                                                </div>
                                            </div>
                                        </c:when>    
                                        <c:otherwise>
                                            <div class="carousel-item" >
                                                <img class="d-block w-100" src="${ldao.getLanzamientoProducto(p.getK_producto()).getI_lanzamiento()}" alt="First slide" >
                                                <div class="carousel-caption d-none d-md-block" id="textCarrusel">
                                                    <div>
                                                        <a href="ControladorLanzamiento?accion=LanzamientoPage&k_lanzamiento=${ldao.getLanzamientoProducto(p.getK_producto()).getK_lanzamiento()}&k_artista=${ldao.getLanzamientoProducto(p.getK_producto()).getK_artista()}"><h5 >${ldao.getLanzamientoProducto(p.getK_producto()).getN_lanzamiento()}</h5></a>
                                                        <a href="ControladorArtista?accion=ArtistaPage&k_artista=${ldao.getLanzamientoProducto(p.getK_producto()).getK_artista()}" style="color:white"><p>${ldao.getLanzamientoProducto(p.getK_producto()).getK_artista_nombre()}</p></a>
                                                        <a href="ControladorProducto?accion=ProductoPage&k_producto=${p.getK_producto()}" style="color:white"><strong><p>${p.getK_estado()} - ${p.getK_formato()}</p> </strong> </a>
                                                        <strong><p>${p.getPrecio()}</p> </strong>
                                                        
                                                    </div>
                                                    <div>

                                                    </div>
                                                </div>
                                            </div>
                                        </c:otherwise>
                                    </c:choose>



                                </c:forEach>


                            </div>
                            <a class="carousel-control-prev" href="#carouselExampleIndicators2" role="button" data-slide="prev">
                                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                                <span class="sr-only">Previous</span>
                            </a>
                            <a class="carousel-control-next" href="#carouselExampleIndicators2" role="button" data-slide="next">
                                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                                <span class="sr-only">Next</span>
                            </a>
                        </div></center>











                </div>
            </div>
            <div class="ACERCA">
                <div class="NUEVOS-DISPONIBLES" style="background-color: #000000">
                    <h2 style="color: #fefe22"> últimos agregados</h2>
                    <br>







                </div>
            </div>
        </div>












        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>



    </body>

    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
    <script src="//code.jquery.com/jquery.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script>
        $(function () {
            $("#nav-placeholder").load("vistas/nav.jsp");
        });
    </script>


</html>