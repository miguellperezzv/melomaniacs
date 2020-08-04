/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Date;

import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import modelo.Lanzamiento;
import modelo.Producto;
import modeloDAO.ArtistaDAO;
import modeloDAO.LanzamientoDAO;
import modeloDAO.ProductoDAO;

/**
 *
 * @author luisy
 */
@MultipartConfig
public class ControladorLanzamiento extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    LanzamientoDAO ldao = new LanzamientoDAO();
    ArtistaDAO adao = new ArtistaDAO();
    List<Lanzamiento> lanzamientos = new ArrayList<>();
    Lanzamiento l = new Lanzamiento();
    ProductoDAO pdao = new ProductoDAO();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String accion = request.getParameter("accion");
        List<Lanzamiento> lanzamientos = ldao.listarLanzamientos();
        switch (accion) {
            case "navNuevo":
                request.getRequestDispatcher("vistas/nuevoLanzamiento.jsp").forward(request, response);
                break;

            case "Agregar Nuevo Lanzamiento":
                String n_lanzamiento = request.getParameter("txtn_lanzamiento");
                String k_genero = request.getParameter("txtGenero");
                
                String imgLanzamiento = request.getParameter("txtArchivo");
                String n_artista = request.getParameter("txtnartista");
        
        
                String fecha = request.getParameter("fechalanzamiento");
                System.out.println("FECHA ELEGIDA ES " + fecha);
                Date date =Date.valueOf(fecha);
                System.out.println("FECHA sql ES " + date);
                
                l.setN_lanzamiento(n_lanzamiento);
                l.setK_genero(k_genero);
                
                l.setI_lanzamiento(imgLanzamiento);
                l.setK_artista(adao.getCodigoporArtista(n_artista) );  
                l.setF_lanzamiento(date);
                ldao.agregar(l);
                
                request.getRequestDispatcher("vistas/principal.jsp").forward(request, response);
                break;
                
             case "LanzamientoPage":
                int k_lanzamiento =Integer.parseInt( request.getParameter("k_lanzamiento"));
                int k_artista = Integer.parseInt(request.getParameter("k_artista"));
                Lanzamiento l  = ldao.getLanzamiento(k_artista, k_lanzamiento);
                
                List <Producto> productos = pdao.getProductos(k_artista, k_lanzamiento);
                System.out.println("TAMAÑO DEL ARRAY DESDE CONTROLAADOR "+ productos.size());
                
                request.setAttribute("ldao", ldao);
                request.setAttribute("pdao", pdao);
                request.setAttribute("productos", productos);
                request.setAttribute("lanzamiento",l );
                request.getRequestDispatcher("vistas/lanzamiento.jsp").forward(request, response);
                break;
                
            default:
                System.out.println("ENTRANDO A DEFAULT DEL CONTROLADOR");
                request.setAttribute("lanzamientos", lanzamientos);
                request.setAttribute("ldao", ldao);
                request.getRequestDispatcher("vistas/principal.jsp").forward(request, response);
        }
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ControladorLanzamiento</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControladorLanzamiento at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
