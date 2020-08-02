<%-- 
    Document   : nuevoLanzamiento
    Created on : 01-ago-2020, 20:15:49
    Author     : luisy
--%>

<%@page import="modelo.Genero"%>
<%@page import="modeloDAO.GeneroDAO"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">


        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">

        <title>Nuevo Lanzamiento</title>
    </head>
    <body>
        <div id="nav-placeholder">

        </div>
        <%GeneroDAO g = new GeneroDAO();%>
        <% List<Genero> generos = g.listarGeneros();%>
    <center>
        <div>
            <h3>Agregar Nuevo Lanzamiento</h3>
            <hr>
            <br>
            <div class ="container col-lg-5">
                <form action="ControladorLanzamiento" method="POST" enctype="multipart/form-data">
                    <div>
                        <label>Nombre: </label>
                        <input type = "text" name="txtn_lanzamiento">
                        <label id="container">Genero:
                            <select class="form-control" type="text" name="txtGenero"   onChange="mostrar(this.value);">

                                <%  for (int i = 0; i < generos.size(); i++) {%>
                                <option value="<%= generos.get(i).getK_genero()%>"> <%= generos.get(i).getK_genero()%> </option>
                                <% }%>
                                <option value="nuevogenero" > ---Nuevo Genero</option>
                            </select>
                        </label>

                    </div>
                    <label>Foto:</label>
                    <input type = "file" name="txtArchivo">
                    <input type="submit" name="accion" value="guardar">
                    <input type="submit" name="accion" value="regresar">
                </form>
            </div>
        </div>

    </center>

    <!-- Modal2 -->
    <div class="modal fade" id="myModal2" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Nueva Proveedor</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>

                <div id="modal2">

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
        $(function () {
            $("#modal2").load("vistas/NuevoGenero.jsp");
        });
    </script>
    <script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
    <script type="text/javascript" src="js/bootstrap.js"></script>
    <script>
        function mostrar(id) {
            if (id === "nuevogenero") {
                //alert("NUEVA CATEGORIA");
                $('#myModal2').modal('show');

            
        }
    </script>
</body>
</html>
