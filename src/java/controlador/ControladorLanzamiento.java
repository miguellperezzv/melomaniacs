/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
import modeloDAO.LanzamientoDAO;

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
    List<Lanzamiento> lanzamientos = new ArrayList<>();
    Lanzamiento l = new Lanzamiento();

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
                Part part = request.getPart("txtArchivo");
                InputStream inputStream = part.getInputStream();
                java.sql.Date fecha;
        try {
            fecha = (java.sql.Date) new SimpleDateFormat("yyyy-dd-mm").parse(request.getParameter("fechalanzamiento"));
        } catch (ParseException ex) {
            Logger.getLogger(ControladorLanzamiento.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //java.sql.Date fechasql=new SimpleDateFormat("yyyy-dd-mm").parse(fecha.)
                
                l.setN_lanzamiento(n_lanzamiento);
                l.setK_genero(k_genero);
                //l.setF_lanzamiento(fecha );
                l.setI_lanzamiento(inputStream);
                l.setK_artista(102);  //LANA DEL REY!!!!!!!!!!!!!!!!!!!!!!!!!!!
                //l.setF_lanzamiento(fecha);
                ldao.agregar(l);
                
                request.getRequestDispatcher("vistas/principal.jsp").forward(request, response);
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
