/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Artista;
import modelo.Lanzamiento;
import modelo.Producto;
import modeloDAO.ArtistaDAO;
import modeloDAO.LanzamientoDAO;
import modeloDAO.ProductoDAO;
import modeloDAO.UsuarioDAO;

/**
 *
 * @author luisy
 */
public class ControladorBuscar extends HttpServlet {

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
        
        switch(accion){
            case "generos":
                
            break;
            
            
            case "decada":
                
            break;
            case "vinilo":
                System.out.println("ENTRANDO A CONTTROLADOR VINILO");
                
                ArtistaDAO adao= new ArtistaDAO();
                LanzamientoDAO ldao = new LanzamientoDAO();
                ProductoDAO pdao = new ProductoDAO();
                List<Artista> artistas = adao.getArtistasFormato("VINILO");
                List<Lanzamiento> lanzamientos = ldao.getLanzamientosFormato("VINILO");
                List<Producto> productos = pdao.getProductosFormato("VINILO");
                
                System.out.println("SE ENVIAN ARTISTAS "+ artistas.size());
                System.out.println("SE ENVIAn lanza "+ lanzamientos.size());
                System.out.println("SE ENVIAn productos "+ productos.size());
                request.setAttribute("artistas", artistas);
                request.setAttribute("lanzamientos", lanzamientos);
                request.setAttribute("productos", productos);
                request.setAttribute("ldao", ldao);
                request.setAttribute("adao", adao);
                request.setAttribute("pdao", pdao);
                request.setAttribute("udao", new UsuarioDAO());
                request.setAttribute("busquedaKey", "VINILO");
                request.getRequestDispatcher("vistas/busqueda.jsp").forward(request, response);
            break;
            case "intercambio":
                
            break;
            case "vendidos":
                
            break;
            case "casette":
                System.out.println("ENTRANDO A CONTTROLADOR VINILO");
                
                adao= new ArtistaDAO();
                ldao = new LanzamientoDAO();
                pdao = new ProductoDAO();
                artistas = adao.getArtistasFormato("CASETTE");
                lanzamientos = ldao.getLanzamientosFormato("CASETTE");
                productos = pdao.getProductosFormato("CASETTE");
                
                System.out.println("SE ENVIAN ARTISTAS "+ artistas.size());
                System.out.println("SE ENVIAn lanza "+ lanzamientos.size());
                System.out.println("SE ENVIAn productos "+ productos.size());
                request.setAttribute("artistas", artistas);
                request.setAttribute("lanzamientos", lanzamientos);
                request.setAttribute("productos", productos);
                request.setAttribute("ldao", ldao);
                request.setAttribute("adao", adao);
                request.setAttribute("pdao", pdao);
                request.setAttribute("udao", new UsuarioDAO());
                request.setAttribute("busquedaKey", "CASETTE");
                request.getRequestDispatcher("vistas/busqueda.jsp").forward(request, response);
            break;
            
        
    }
        
        
        
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ControladorBuscar</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControladorBuscar at " + request.getContextPath() + "</h1>");
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
