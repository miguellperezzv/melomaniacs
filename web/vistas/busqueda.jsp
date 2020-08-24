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
    <body style="background-color: #ffffff">

        <div id="nav-placeholder">
        </div>

        <ul class="nav justify-content-center">
            <li class="nav-item">
                <a class="nav-link active" href="#">Albumes</a>
            </li>

            <li class="nav-item">
                <a class="nav-link" href="#">Artistas</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">Productos</a>
            </li>
        </ul>

        <h2>Resultados para ${busquedaKey}</h2>
        <div id="artistas">

            <h2>ARTISTAS</h2>
            <c:forEach var = "a" items = "${artistas}">
                <label>${a.getN_artista()}</label>
                <br>
            </c:forEach>

        </div>
        <div id="albumes">
            <h2>ALBUMES</h2>
            <c:forEach var = "l" items = "${lanzamientos}">
                <label>${l.getN_lanzamiento()}</label>

            </c:forEach>
        </div>

        <div id="productos">
            <h2>PRODUCTOS</h2>
            <div class="row">
            <c:forEach var = "p" items = "${productos}">
                
                    <div class="col-lg-2">
                        <div class="card" >
                            
                            <div class="card-body">
                                
                                <h5 class="card-title"><img src="${(ldao.getLanzamiento(p.getK_artista(),p.getK_lanzamiento())).getI_lanzamiento()}" width="70" height="70"> ${(ldao.getLanzamiento(p.getK_artista(),p.getK_lanzamiento())).getN_lanzamiento()}  </h5>
                                <h6 class="card-subtitle mb-2 text-muted"> ${(adao.setArtista(p.getK_artista())).getN_artista()}  </h6>
                                <div class="card-text">
                                    <br>
                                    <p><strong>${(pdao.getProducto(p.getK_producto())).getK_formato()}  - ${(pdao.getProducto(p.getK_producto())).getK_estado()}</strong></p>
                                    <p>${(pdao.getProducto(p.getK_producto())).getD_descripcion()}</p>
                                </div>
                                <h7>Proveedor:</h7>
                                <div class="row" >
                                    
                                    <div class="col-md-6"><center><img src="${udao.getUsuarioPorProducto(p.getK_producto()).getI_usuario()}" width="40" height="40"></center> </div>
                                    <div class="col-md-6"> <i class="fas fa-shopping-cart fa-2x" style="color: black;"></i> </div>
                                </div>
                            </div>
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
