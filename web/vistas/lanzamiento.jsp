<%-- 
    Document   : lanzamiento
    Created on : 03-ago-2020, 23:54:51
    Author     : luisy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>${lanzamiento.getN_lanzamiento()} - ${lanzmiento.getN_artista(lanzamiento.getK_artista())}</title>
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
                        <h2 id="tituloAlbum" > <a id="link" href="#"> ${lanzamiento.getK_artista_nombre().toUpperCase()}</a> - ${lanzamiento.getN_lanzamiento().toUpperCase()}</h2>
                    </div>
                    
                    <div id="info">
                        
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
