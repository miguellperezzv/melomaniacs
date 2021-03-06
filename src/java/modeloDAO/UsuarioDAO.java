/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloDAO;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Contacto;
import modelo.Usuario;

/**
 *
 * @author luisy
 */
public class UsuarioDAO {

    Connection conn;
    Conexion cn = new Conexion();
    PreparedStatement st;
    ResultSet rs;

    public Usuario getUsuarioPorProducto(int k_producto) {
        Usuario u = new Usuario();
        String sql = "SELECT * from usuario u, catalogo c, producto p\n"
                + "WHERE u.K_USUARIO = c.K_USUARIO\n"
                + "AND p.K_PRODUCTO = c.K_PRODUCTO\n"
                + "AND p.K_PRODUCTO= " + k_producto;

        try {
            conn = cn.getConnection();
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            //System.out.println("SENTENCIA SQL ES "+ sql);
            while (rs.next()) {
                u.setK_usuario(rs.getString("k_usuario"));
                u.setC_usuario(rs.getString("c_usuario"));
                u.setK_tipo(rs.getString("k_tipo"));
                u.setN_usuario(rs.getString("n_usuario"));
                u.setD_usuario(rs.getString("d_usuario"));
                u.setI_usuario(rs.getString("I_usuario"));
            }
        } catch (SQLException e) {
            System.out.println("Error en get CANT SEGUN /producto dao" + e);
        }

        return u;
    }

    public Usuario getUsuarioPorCodigo(String k_usuario) {
        Usuario u = new Usuario ();
        String sql = "SELECT * from usuario u \n"
                + "WHERE u.K_USUARIO ='" + k_usuario+"'";
        
        try {
            conn = cn.getConnection();
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            //System.out.println("SENTENCIA SQL ES "+ sql);
            while (rs.next()) {
                u.setK_usuario(rs.getString("k_usuario"));
                u.setC_usuario(rs.getString("c_usuario"));
                u.setK_tipo(rs.getString("k_tipo"));
                u.setN_usuario(rs.getString("n_usuario"));
                u.setD_usuario(rs.getString("d_usuario"));
                u.setI_usuario(rs.getString("I_usuario"));
            }
        } catch (SQLException e) {
            System.out.println("Error en obtener usuario" + e);
        }

        return u;
        }

    public List<Contacto> getContactos(String k_usuario) {
        List<Contacto> lista = new ArrayList<>();
        String sql = "SELECT * from contacto c  \n"
                + "WHERE c.K_USUARIO = '" + k_usuario+"'";
        
        try {
            conn = cn.getConnection();
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            //System.out.println("SENTENCIA SQL ES "+ sql);
            while (rs.next()) {
                Contacto c = new Contacto();
                c.setK_tipocontacto(rs.getString("k_tipocontacto"));
                c.setK_usuario(rs.getString("k_usuario"));
                c.setK_contacto(rs.getInt("k_contacto"));
                c.setV_contacto(rs.getString("v_contacto"));
                lista.add(c);
            }
        } catch (SQLException e) {
            System.out.println("Error en obtener contactos del usuario" + e);
        }

        return lista;
        
    }

}
