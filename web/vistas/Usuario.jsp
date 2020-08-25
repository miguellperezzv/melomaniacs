<%-- 
    Document   : Usuario
    Created on : 24-ago-2020, 21:43:21
    Author     : luisy
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>${u.getN_usuario()}</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
        <script src="https://kit.fontawesome.com/151fccfd32.js" crossorigin="anonymous"></script>
        <link href="${pageContext.request.contextPath}/CSS/busqueda.css" rel="stylesheet" type="text/css"/>
        <link href="${pageContext.request.contextPath}/CSS/usuario.css" rel="stylesheet" type="text/css"/>
        <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@700&display=swap" rel="stylesheet">
    </head>
     <div id="nav-placeholder">
     </div>
    
    <body style="background-color: #1f1f1f">

        <div class="container" style="margin-left: 10px; margin-left: 10px;">
            <br>
            <br>
            <h2>${u.getN_usuario()} </h2>
            <div class="row" style="margin-left: 50px; margin-right: 50px;">
                
                <div class="col-lg-6" >
                    <img src="${u.getI_usuario()}" width="300" height="300">
                    
                </div>
                    <DIV class="col-lg-6">
                        
                    
                    <h2>acerca</h2>
                    <div id="acerca" width="200px" width="80px"> ${u.getD_usuario()} </div>
                    <h2>contacto</h2>
                    <div class="row">
                        
                        <c:forEach var = "c" items = "${contactos}">
                            
                        </c:forEach>
                        
                        <div class="col-lg-2"> HOLA</div>
                        <div class="col-lg-2"> HOLA</div>
                        <div class="col-lg-2"> HOLA</div>
                        <div class="col-lg-2"> HOLA</div>
                        <div class="col-lg-2"> HOLA</div>
                        <div class="col-lg-2"> HOLA</div>
                    </div>
                    </DIV>
                
                
            </div>
            
            
            
            <div>
                <div> <h3>catalogo</h3></div>
                <div> <h3>albumes</h3></div>
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
