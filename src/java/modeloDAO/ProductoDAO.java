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
import modelo.Artista;
import modelo.Lanzamiento;
import modelo.Producto;

/**
 *
 * @author luisy
 */
public class ProductoDAO {

    Connection conn;
    Conexion cn = new Conexion();
    PreparedStatement st;
    ResultSet rs;

    public int cantLanzamientoSegun(int k_lanzamiento, int k_artista, String tipo) {
        int cant = 0;
        String sql = "SELECT COUNT(*) from producto WHERE K_ARTISTA=" + k_artista + " AND K_LANZAMIENTO=" + k_lanzamiento + " AND K_FORMATO = '" + tipo + "'";

        try {
            conn = cn.getConnection();
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            //System.out.println("SENTENCIA SQL ES "+ sql);
            while (rs.next()) {
                cant = rs.getInt("count(*)");
            }
        } catch (SQLException e) {
            System.out.println("Error en get CANT SEGUN /producto dao" + e);
        }

        return cant;
    }

    public int cantLanzamientoEstado(int k_lanzamiento, int k_artista, String tipo) {
        int cant = 0;
        String sql = "SELECT COUNT(*) from producto WHERE K_ARTISTA=" + k_artista + " AND K_LANZAMIENTO=" + k_lanzamiento + " AND K_ESTADO LIKE  '%" + tipo + "'";

        try {
            conn = cn.getConnection();
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            // System.out.println("SENTENCIA SQL ES "+ sql);
            while (rs.next()) {
                cant = rs.getInt("count(*)");
            }
        } catch (SQLException e) {
            System.out.println("Error en get CANT SEGUN /producto dao" + e);
        }

        return cant;
    }

    public List<Producto> getProductos(int k_artista, int k_lanzamiento) {

        List<Producto> lista = new ArrayList<>();
        String sql = "SELECT * FROM producto WHERE k_artista=" + k_artista + " AND k_lanzamiento=" + k_lanzamiento;

        try {
            conn = cn.getConnection();
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            System.out.println("SENTENCIA SQL ES " + sql);
            while (rs.next()) {
                Producto p = new Producto();
                p.setK_producto(rs.getInt("k_producto"));
                p.setK_lanzamiento(rs.getInt("k_artista"));
                p.setK_artista(rs.getInt("k_artista"));
                p.setK_formato(rs.getString("k_formato"));
                p.setK_estado(rs.getString("k_estado"));
                p.setD_descripcion(rs.getString("d_descripcion"));
                lista.add(p);

            }
        } catch (SQLException e) {
            System.out.println("ERROR EN LISTAR PRODCUTOS daoProducto " + e);
        }
        System.out.println("se envian productoss: " + lista.size());
        return lista;
    }

    public String getN_Proveedor(int K_producto) {
        String nombre = null;
        String sql = "SELECT u.n_usuario FROM producto p, catalogo c, usuario u WHERE u.K_USUARIO=c.K_USUARIO AND c.K_PRODUCTO=p.K_PRODUCTO AND P.K_PRODUCTO=" + K_producto;

        try {
            conn = cn.getConnection();
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()) {
                nombre = rs.getString("n_usuario");
            }
        } catch (SQLException e) {
            System.out.println("error en get proveedor " + e);
        }

        return nombre;
    }

    public List<Producto> getProductosFormato(String key) {
        List<Producto> lista = new ArrayList<>();
        String sql = "SELECT p.K_PRODUCTO,p.K_ARTISTA, p.K_LANZAMIENTO, p.P_PRECIO FROM producto p, formato f, catalogo c WHERE \n"
                + "p.K_FORMATO = f.K_FORMATO\n"
                + "AND c.K_PRODUCTO = p.K_PRODUCTO\n"
                + "AND f.K_FORMATO='"+key+"'";

        try {
            conn = cn.getConnection();
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()) {
                Producto p = new Producto();
                p.setK_producto(rs.getInt("k_producto"));
                p.setK_artista(rs.getInt("k_artista"));
                p.setK_lanzamiento(rs.getInt("k_lanzamiento"));
                p.setPrecio(rs.getInt("p_precio"));
                lista.add(p);
            }
        } catch (SQLException e) {
            System.out.println("ERROR EN LISTAR VINILOS" + e);
        }
        return lista;
    }
    
    
    public Producto getProducto(int k_producto){
        Producto p = new Producto();
       
        String sql = "SELECT * FROM producto WHERE K_PRODUCTO = "+k_producto;

        try {
            conn = cn.getConnection();
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()) {
                
                p.setK_producto(rs.getInt("k_producto"));
                p.setK_estado(rs.getString("k_estado"));
                p.setK_formato(rs.getString("k_formato"));
                p.setK_artista(rs.getInt("k_artista"));
                p.setK_lanzamiento(rs.getInt("k_lanzamiento"));
                p.setD_descripcion(rs.getString("d_descripcion"));
                p.setPrecio(rs.getInt("p_precio"));
                
            }
        } catch (SQLException e) {
            System.out.println("ERROR EN get producto" + e);
        }
        return p;
    }
    
    
    
     public List<Producto> ListarNuevosProductos() {
        List<Producto> lista = new ArrayList<>();
        String sql = "SELECT DISTINCT p.k_producto FROM lanzamiento l,catalogo c, producto p WHERE l.K_LANZAMIENTO = p.K_LANZAMIENTO AND c.k_producto = p.K_PRODUCTO ORDER BY c.f_catalogo DESC LIMIT 10";
        try {
            conn = cn.getConnection();
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();

            while (rs.next()) {
                Producto p = new Producto();
                p.setK_producto(rs.getInt("p.k_producto"));
                lista.add(p);
                //System.out.println("n y url" +l.getN_lanzamiento()+", "+ l.getI_lanzamiento() );
            }
            conn.close();
            System.out.println("se envian productos" + lista.size());
            return lista;
        } catch (SQLException e) {
            System.out.println("Error en listar productos" + e);
            return lista;
        }

    }
    
    
}
