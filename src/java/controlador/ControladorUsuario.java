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
import modelo.Contacto;
import modelo.Lanzamiento;
import modelo.Producto;
import modelo.Usuario;
import modeloDAO.CatalogoDAO;
import modeloDAO.LanzamientoDAO;
import modeloDAO.ProductoDAO;
import modeloDAO.UsuarioDAO;

/**
 *
 * @author luisy
 */
public class ControladorUsuario extends HttpServlet {

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
        LanzamientoDAO ldao = new LanzamientoDAO();
        UsuarioDAO udao = new UsuarioDAO();
        ProductoDAO pdao = new ProductoDAO();
        CatalogoDAO cdao = new CatalogoDAO();
        if(accion.equalsIgnoreCase("Ingresar")){
            
            
            List<Lanzamiento> lanzamientos = ldao.listarLanzamientos();
            request.setAttribute("lanzamientos", lanzamientos);
                request.setAttribute("ldao", ldao);
                
            System.out.println("ENTRANDO Al CONTROLADOR");
            request.getRequestDispatcher("vistas/principal.jsp").forward(request, response);
        }
        
        
        if(accion.equals("usuarioPage")){
            String k_usuario = (request.getParameter("k_usuario"));
            Usuario u = udao.getUsuarioPorCodigo(k_usuario);
            List <Contacto> contactos = udao.getContactos(k_usuario);
            List<Producto> productos = cdao.productosUsuario(k_usuario);
            
            request.setAttribute("contactos", contactos);
            request.setAttribute("u", u);
            request.setAttribute("productos", productos);
            request.setAttribute("pdao", pdao);
            request.getRequestDispatcher("vistas/Usuario.jsp").forward(request, response);
            
        }
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ControladorUsuario</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControladorUsuario at " + request.getContextPath() + "</h1>");
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
