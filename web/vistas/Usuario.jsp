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
        <link rel="icon" type="image" href="${u.getI_usuario()}" width="40px" heigth="40px" />
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
        <script src="https://kit.fontawesome.com/151fccfd32.js" crossorigin="anonymous"></script>

        <link href="${pageContext.request.contextPath}/CSS/usuario.css" rel="stylesheet" type="text/css"/>
        <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@700&display=swap" rel="stylesheet">
    </head>
    <div id="nav-placeholder">
    </div>

    <body style="background-color: #1f1f1f">

        <div class="container" style="margin-left: 10px; margin-right: 10px;">
            <br>
            <br>
            <h2>${u.getN_usuario()} </h2>
            <div class="row" style="margin-left: 50px; margin-right: 50px;">

                <div class="col-lg-6" >
                    <img src="${u.getI_usuario()}" width="300" height="300">

                </div>
                <DIV class="col-lg-6">


                    <h2>acerca</h2>
                    <div id="acerca" width="200px" width="150px"> ${u.getD_usuario()} </div>
                    <br>
                    <br>
                    <h2>contacto</h2>
                    <div class="row">

                        <c:forEach var = "c" items = "${contactos}">
                            <c:if test="${c.getK_tipocontacto() == 'INSTAGRAM'}">
                                <div class="col-lg-2"> <a href="https://www.instagram.com/${c.getV_contacto()}" target="_blank"><i class="fab fa-instagram fa-3x" id="icon" ></i> </a></div>
                            </c:if>
                            <c:if test="${c.getK_tipocontacto() == 'FACEBOOK'}">
                                <div class="col-lg-2"> <a href="https://www.fb.com/${c.getV_contacto()}" target="_blank"><i class="fab fa-facebook-square fa-3x" id="icon"></i></a></div>
                                    </c:if>
                                    <c:if test="${c.getK_tipocontacto() == 'TWITTER'}">
                                <div class="col-lg-2"> <a href="https://www.twitter.com/${c.getV_contacto()}" target="_blank"><i class="fab fa-twitter-square fa-3x" id="icon"></i></a></div>
                                    </c:if>
                                    <c:if test="${c.getK_tipocontacto() == 'E-MAIL'}">
                                <div class="col-lg-2"> <a><i class="fas fa-envelope fa-3x" ID="icon"></i></a></div>
                                    </c:if>
                                    <c:if test="${c.getK_tipocontacto() == 'TELEFONO'}">
                                <div class="col-lg-2"> <a><i class="fas fa-phone-square-alt fa-3x" ID="icon"></i></a></div>
                                    </c:if>

                        </c:forEach>


                    </div>
                </DIV>


            </div>


            <br>
            <br>
            <div>
                <div> <h2>catalogo</h2>
                    <br><br>
                    <div> 
                        <form>
                            <center>  <h2 style="font-size: 15px;">Buscar en el catálogo <input>   <input class="btn btn-outline-success" value="Buscar"></h2> </center>
                        </form>
                    </div>
                </div>
                <div> 
                    <div class="row">
                        <c:forEach var= "p" items ="${productos}">

                            <div class="col-lg-3" >
                                <center> <div id="padre">
                                    <div id="img">
                                        <center>   <img src="${ldao.getLanzamientoProducto(p.getK_producto()).getI_lanzamiento()}" class="image" width="150" height="150"></center>
                                        <audio src="${ldao.getLanzamientoProducto(p.getK_producto()).getS_lanzamiento()}"  id="audio"></audio>


                                        <div class="middle" width="150" height="150">
                                            <div class="textoAlbum"> <i class="far fa-play-circle" id="play" onclick="preview()"></i><i class="fa fa-cart-plus" style="color: #fefe23;"></i> </div>
                                        </div>
                                    </div>
                                </div></center> 
                                <div>
                                    <center>
                                        <strong><h5 style="background-color: transparent;">${ldao.getLanzamientoProducto(p.getK_producto()).getN_lanzamiento()} </h5></strong>
                                        <h4 style="color: #fefe23; font-size: 10px;">${ldao.getLanzamientoProducto(p.getK_producto()).getK_artista_nombre()} </h4>
                                    </center>
                                    <div class="row">
                                        <center>
                                        <div  id="margen">
                                            <strong><center><h7 style="background-color: #fefe23; font-size: 10px;">${p.getK_formato()} / ${p.getK_estado()}</h7> </center></strong>
                                        </div>
                                        </center>
                                        
                                        
                                    </div>
                                </div>
                            </div>

                        </c:forEach>
                        <br>
                        <br>
                    </div>


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

        <script>
            function preview() {
                var audio = document.getElementById('audio');
                if (audio.paused) {
                    audio.play();


// In browsers that don’t yet support this functionality,
// playPromise won’t be defined.

                    $('#play').removeClass('fa-play-circle');
                    $('#play').addClass('fa-pause-circle');
                } else {
                    audio.pause();
                    audio.currentTime = 0;
                    $('#play').addClass('fa-play-circle');
                    $('#play').removeClass('fa-pause-circle');
                }
            }
        </script>
    </body>
</html>
