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
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
        <title>melomaniacs</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="${pageContext.request.contextPath}/CSS/estilos.css" rel="stylesheet" type="text/css"/> 
    </head>
    <body>
        <div id="nav-placeholder">

        </div>




        <div class="grid-container">
            <div class="NUEVOS-DISPONIBLES" style="background-color: #000000">
                <h2 style="color: #fefe22"> últimos agregados</h2>
                <br>



                <c:forEach var = "l" items = "${lista}" >
                    <img src="${l.getI_lanzamiento()}" height="200" height="200">

                </c:forEach>





            </div>
            <div class="INICIO"></div>
            <div class="PRINCIPAL">
                <div class="INFO" id="jumbo"><div class="jumbotron" id="jumbotron" style="background-color: #000000;">
                        <h1 class="display-4" style="color: #ffffff">Bienvenido a <h2 style="color: #fefe22"> Melomaniacs!</h2></h1>
                        <p class="lead" style="color: #ffffff">El lugar donde podrás intercambiar y obtener tu música favorita.</p>
                        <hr class="my-4">
                        <p style="color: #ffffff">Inicia Sesión </p>
                        <p class="lead">
                            <a class="btn btn-primary btn-lg" href="#" role="button" style="background-color: #fefe22; color: #000000">Entrar</a>
                        </p>
                    </div></div>
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
        </div>
    </div>







    <div class ="container col-lg-5" margin-top="50px" top="50px">
        <form action="ControladorUsuario"> 
            <p font-size="50 px" id="tituloNav">melomaniacs</p>
            <p>Control</p>




            <input class="btn btn-danger btn-block" type="submit" name="accion" value="ingresar" >

        </form>
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