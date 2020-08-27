<%-- 
    Document   : artista
    Created on : 04-ago-2020, 6:28:09
    Author     : luisy
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>${artista.getN_artista()}</title>

        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
        <script src="https://kit.fontawesome.com/151fccfd32.js" crossorigin="anonymous"></script>

        <link href="${pageContext.request.contextPath}/CSS/artista.css" rel="stylesheet" type="text/css"/>
        <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@700&display=swap" rel="stylesheet">
    </head>
    <body id="bodybackground">
        <div id="nav-placeholder">

        </div>
        <br><br>
        <div class="container">
            <div >
                <div class="row">
                    <div class="col-md-4">
                        <center><label id="tituloPaginas"> ${artista.getN_artista()}</label></center>

                    </div>
                    <div class="col-md-4">
                        <h2 id="descArtista"> ${artista.getD_artista()} </h2>
                    </div>

                    <div class="col-md-4">

                    </div>
                </div>

            </div>
            <div>
                <h2 id="tituloArtistaPage">Albumes</h2>
                <br>
                <div class="row">
                    <c:forEach var = "l" items = "${misLanzamientos}">
                        <div class="col-lg-3" style="margin: 1px; ">
                            
                           <div><center> <img src="${l.getI_lanzamiento()}" width="200" height="200"> </center></div>
                           <div><center> <h5> ${l.getN_lanzamiento()}</h5> </center></div>
                            

                        </div>


                    </c:forEach></div>
            <div >
                <H2 id="tituloArtistaPage"> Relacionado </H2>
            </div>

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
