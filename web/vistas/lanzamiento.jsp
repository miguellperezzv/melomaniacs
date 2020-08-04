<%-- 
    Document   : lanzamiento
    Created on : 03-ago-2020, 23:54:51
    Author     : luisy
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>${lanzamiento.getN_lanzamiento()} </title>
        <link rel="icon" type="image" href="${lanzamiento.getI_lanzamiento()}" width="40px" heigth="40px" />
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
        <script src="https://kit.fontawesome.com/151fccfd32.js" crossorigin="anonymous"></script>
        <link href="${pageContext.request.contextPath}/CSS/estilos.css" rel="stylesheet" type="text/css"/>
        <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@700&display=swap" rel="stylesheet">
    </head>
    <body id="bodybackground">
        <div id="nav-placeholder">

        </div>

        <br>

        <div class="container mt-2">

            <div class="row">
                <div class="col-md-6">
                    <center><img src="${lanzamiento.getI_lanzamiento()}" width="400px" height="400px"  alt=""/></center>
                </div>
                <div class="col-md-6">
                    <div> 
                        <center>
                            <h2 id="tituloAlbum" > <a id="link" href="#"> ${lanzamiento.getK_artista_nombre().toUpperCase()}</a> - ${lanzamiento.getN_lanzamiento().toUpperCase()}</h2>
                            <h3 ID="subtituloAlbum">genero: ${lanzamiento.getK_genero()} </h3>
                            <h3 id="subtituloAlbum">lanzamiento: ${ldao.anioLanzamiento(lanzamiento.getK_lanzamiento(), lanzamiento.getK_artista()) } </h3>

                            <h3 ID="subtituloAlbum">disponibles: ${ldao.cantLanzamiento(lanzamiento.getK_lanzamiento(), lanzamiento.getK_artista())} </h3>
                        </center>
                    </div>
                    <CENTER>
                        <div  class="row" id="info">

                            <div class="col-md-6">
                                <h3 id="subtituloInfo">CD: ${pdao.cantLanzamientoSegun(lanzamiento.getK_lanzamiento(), lanzamiento.getK_artista(), "CD") } </h3>
                                <h3 id="subtituloInfo">VINILO: ${pdao.cantLanzamientoSegun(lanzamiento.getK_lanzamiento(), lanzamiento.getK_artista(),"VINILO")  } </h3>
                                <h3 id="subtituloInfo">CASETTE: ${pdao.cantLanzamientoSegun(lanzamiento.getK_lanzamiento(), lanzamiento.getK_artista(), "CASETTE")  } </h3>
                            </div>
                            <vr>

                            </vr>
                            <div class="col-md-6">
                                <i class="fas fa-shopping-cart fa-lg"></i> <h3 id="subtituloInfo">  ${pdao.cantLanzamientoEstado(lanzamiento.getK_lanzamiento(), lanzamiento.getK_artista(), "VENTA")  }</h3>


                                <i class="fas fa-exchange-alt fa-lg"></i><h3 id="subtituloInfo">${pdao.cantLanzamientoEstado(lanzamiento.getK_lanzamiento(), lanzamiento.getK_artista(), "INTERCAMBIO")  }</h3>
                            </div>

                        </div>
                    </CENTER>
                </div>


            </div>
        </div>        

        <HR>
    <center><label id="tituloPaginas">Productos</label></center>
    <div class="container mt-2">



        <h3 id="subtituloAlbum">--> ${productos.size()}<----</h3>

        <hr>

        <table class="table table-striped table-dark">
            <thead>
                <tr>
                    <th scope="col">Nombre</th>
                    <th scope="col">Formato</th>
                    <th scope="col">Estado</th>
                    <th scope="col">Descripcion</th>
                    <th scope="col">Proveedor</th>
                    <th scope="col">Detalles</th>
                </tr>
            </thead>
            <tbody>
                
            <c:forEach var = "p" items = "${productos}">
                <tr>
                    <td scope="row">${lanzamiento.getN_lanzamiento()} - ${lanzamiento.getK_artista_nombre()}</td>
                    <td>${p.getK_formato()}</td>
                    <td>${p.getK_estado()}</td>
                    <td>${p.getD_descripcion()}</td>
                    <td>${pdao.getN_Proveedor(p.getK_producto())}</td>
                    <td> <a class="fas fa-compact-disc"></a></td>
                </tr>
                
            </c:forEach>
                
                
            </tbody>
        </table>
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
