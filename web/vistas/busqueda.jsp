<%-- 
    Document   : busqueda
    Created on : 23-ago-2020, 23:50:42
    Author     : luisy
--%>

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

        <link href="${pageContext.request.contextPath}/CSS/busqueda.css" rel="stylesheet" type="text/css"/>
        <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@700&display=swap" rel="stylesheet">
    </head>
    <body style="background-color: #1f1f1f">

        <div id="nav-placeholder">
        </div>

        <br><br>
        <div class="container" style="margin-left: 20px; margin-right: 20px;" >
            <h2 id="label">Resultados para ${busquedaKey}</h2>
            <br>
            <br>

            <ul class="nav justify-content-center">
                <li class="nav-item">
                    <a class="nav-link active" href="#albumes">Albumes</a>
                </li>

                <li class="nav-item">
                    <a class="nav-link" href="#artistas">Artistas</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#productos">Productos</a>
                </li>
            </ul>




            <div id="artistas">

                <h2 id="label">ARTISTAS</h2>
                <c:forEach var = "a" items = "${artistas}">
                    <a href="ControladorArtista?accion=ArtistaPage&k_artista=${a.getK_artista()}"> <label> ${a.getN_artista()}</label></a>
                    <br>
                </c:forEach>

            </div>
            <br style="size: 3px; color: #fefe23">
            <br>
            <div id="albumes">
                <h2 id="label">ALBUMES</h2>
                <div class="row">
                    <c:forEach var = "l" items = "${lanzamientos}">
                        <div class="col-lg-3" style="margin: 1px; ">
                            <div class="row">
                                <div class="col-lg-6"><center> <img src="${l.getI_lanzamiento()}" width="80" height="80"> </center></div>
                                <div class="col-lg-6"> <strong><h6 id="label"> ${l.getN_lanzamiento()} - ${adao.setArtista(l.getK_artista()).getN_artista()} </h6></strong></div>
                            </div>

                        </div>


                    </c:forEach></div>
            </div>

            <br>
            <br>
            <div id="productos">
                <h2 id="label">PRODUCTOS</h2>
                </div>
            </div>
                <div class="row">
                    <c:forEach var = "p" items = "${productos}" >

                        <div class="col-lg-2" >
                            <div class="card" style="background-color: #cccccc" >

                                <div class="card-body" style="background-color: #cccccc">

                                    <h5 class="card-title"><img src="${(ldao.getLanzamiento(p.getK_artista(),p.getK_lanzamiento())).getI_lanzamiento()}" width="70" height="70"> ${(ldao.getLanzamiento(p.getK_artista(),p.getK_lanzamiento())).getN_lanzamiento()}  </h5>
                                    <h6 class="card-subtitle mb-2 text-muted"> ${(adao.setArtista(p.getK_artista())).getN_artista()}  </h6>
                                    <div class="card-text">
                                        <br>
                                        <p><strong>${(pdao.getProducto(p.getK_producto())).getK_formato()}  - ${(pdao.getProducto(p.getK_producto())).getK_estado()}</strong></p>
                                        <p>${(pdao.getProducto(p.getK_producto())).getD_descripcion()}</p>
                                    </div>
                                    <h7>Proveedor:</h7>
                                    <div class="row" >

                                        <div class="col-md-6">
                                            <span class="info">${udao.getUsuarioPorProducto(p.getK_producto()).getN_usuario()} <a href="ControladorUsuario?accion=usuarioPage&k_usuario=${udao.getUsuarioPorProducto(p.getK_producto()).getK_usuario()}">  <i class="fas fa-info fa-2x" style="color: #fefe23"  ></i></a></span>
                                            <center><img src="${udao.getUsuarioPorProducto(p.getK_producto()).getI_usuario()}" width="40" height="40"></center> </div>
                                        <div class="col-md-6"> <i class="fas fa-shopping-cart fa-2x" style="color: black;"></i> </div>
                                    </div>
                                </div>
                            </div>
                        </div>



                    </c:forEach>
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
