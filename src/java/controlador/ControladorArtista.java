/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Artista;
import modelo.Estado;
import modelo.Lanzamiento;
import modeloDAO.ArtistaDAO;
import modeloDAO.EstadoDAO;
import modeloDAO.LanzamientoDAO;

/**
 *
 * @author luisy
 */
public class ControladorArtista extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        String accion = request.getParameter("accion");

        ArtistaDAO adao = new ArtistaDAO();
        LanzamientoDAO ldao = new LanzamientoDAO();
        String menu = request.getParameter("menu");
        EstadoDAO edao = new EstadoDAO();

        switch (accion) {
            case "ArtistaPage":

                int k_artista = Integer.parseInt(request.getParameter("k_artista"));
                Artista a = new Artista();
                a = adao.setArtista(k_artista);
                request.setAttribute("artista", a);
                request.getRequestDispatcher("vistas/artista.jsp").forward(request, response);
                break;

            case "NuevoItemForm":

                String n_artista = request.getParameter("txtnartista");
                List<Lanzamiento> lista = ldao.listarNombres(n_artista);

                request.setAttribute("n_artista", n_artista);
                List<Estado> listaEstado = edao.getEstados();
                request.setAttribute("lista", lista);
                request.setAttribute("listaEstado", listaEstado);
                request.getRequestDispatcher("vistas/nuevoItem.jsp").forward(request, response);
                break;

            case "Agregar Nuevo Producto":
                System.out.print("entrando controlador nuevo item");
                String txtartista = request.getParameter("txtnartista");
                int k_lanzamiento = Integer.parseInt(request.getParameter("txtLanzamientos"));
                String txtk_estado = request.getParameter("selectEstado");
                String txtdescripcion = request.getParameter("txtdescripcion");

                System.out.println("MIS VARIABLES DE ITEM SON " + txtartista + ", " + k_lanzamiento + " " + txtk_estado + " , " + txtdescripcion);
                break; 
        }

        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ControladorArtista</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControladorArtista at " + request.getContextPath() + "</h1>");
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
