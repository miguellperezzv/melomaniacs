<%-- 
    Document   : nuevoItem
    Created on : 03-ago-2020, 20:52:59
    Author     : luisy
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">


        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
        <script src="https://kit.fontawesome.com/151fccfd32.js" crossorigin="anonymous"></script>
        
        <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@700&display=swap" rel="stylesheet">

        <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
        <link rel="stylesheet" href="/resources/demos/style.css">

        <title>Nuevo Item</title>
    </head>
    <body id="bodybackground">
        <div id="nav-placeholder">

        </div>
    <center>
        <div>
            <h3 id="tituloPaginas">Agregar Nuevo Lanzamiento</h3>
            
            <hr>
            <br>
            <div class ="container col-lg-5">
                <form action="ControladorArtista?accion=NuevoItemForm" method="POST"> 
                    <div> 
                        <label id="formtext">Artista</label>
                        <input id="txtnartista" value="${n_artista}" type = "text" name="txtnartista">
                        <br>
                        <input class="btn btn-outline-success" type="submit" name="accion" value="Buscar Artista">
                    </div>
                    <hr>
                    <div id="formAlbumes">
                        <select class="form-control" type="text" name="txtLanzamientos"   onChange="mostrar(this.value);">

                            <c:forEach var= "l" items = "${lista}">
                                <option value="${l.getK_lanzamiento()}">  
                                    ${l.getN_lanzamiento()}
                                </option>
                            </c:forEach>


                            <option value="nuevogenero" > ---No encuentras el Lanzamiento?</option>
                        </select>
                        
                        <select class="form-control" type="text" name="selectEstado"   onChange="mostrar(this.value);">

                            <c:forEach var= "e" items = "${listaEstado}">
                                <option value="${e.getK_estado()}">  
                                    ${e.getK_estado()}
                                </option>
                            </c:forEach>


                            <option value="nuevogenero" > ---Otro Tipo de Estado</option>
                        </select>

                        <input type="text" id="txtdescripcion" placeholder="Ingrese descripcion opcional del producto">

                    </div>
                    <input class="btn btn-outline-success" href="ControladorArtista" type="submit" name="accion" value="Agregar Nuevo Producto">
                    
                </form>
                </center>



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
