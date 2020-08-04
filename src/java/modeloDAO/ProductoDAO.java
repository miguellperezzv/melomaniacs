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
    
    public int cantLanzamientoSegun(int k_lanzamiento, int k_artista, String tipo){
        int cant=0;
        String sql = "SELECT COUNT(*) from producto WHERE K_ARTISTA="+k_artista+" AND K_LANZAMIENTO="+k_lanzamiento+" AND K_FORMATO = '"+tipo+"'";
        
        try{
            conn = cn.getConnection();
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            //System.out.println("SENTENCIA SQL ES "+ sql);
            while(rs.next()){
                cant = rs.getInt("count(*)");
            }
        }
        catch(SQLException e ){
            System.out.println("Error en get CANT SEGUN /producto dao" +e );
        }
        
        return cant;
    }
    
    public int cantLanzamientoEstado(int k_lanzamiento, int k_artista, String tipo){
        int cant=0;
        String sql = "SELECT COUNT(*) from producto WHERE K_ARTISTA="+k_artista+" AND K_LANZAMIENTO="+k_lanzamiento+" AND K_ESTADO LIKE  '%"+tipo+"'";
        
        try{
            conn = cn.getConnection();
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
           // System.out.println("SENTENCIA SQL ES "+ sql);
            while(rs.next()){
                cant = rs.getInt("count(*)");
            }
        }
        catch(SQLException e ){
            System.out.println("Error en get CANT SEGUN /producto dao" +e );
        }
        
        return cant;
    }

    public List<Producto> getProductos(int k_artista, int k_lanzamiento) {
        
        List<Producto> lista = new ArrayList<>();
        String sql = "SELECT * FROM PRODUCTO WHERE k_artista="+k_artista+" AND k_lanzamiento="+k_lanzamiento;
        
        try{
            conn = cn.getConnection();
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            System.out.println("SENTENCIA SQL ES "+ sql);
            while(rs.next()){
                Producto p = new Producto();
                p.setK_producto(rs.getInt("k_producto"));
                p.setK_lanzamiento(rs.getInt("k_artista"));
                p.setK_artista(rs.getInt("k_artista"));
                p.setK_formato(rs.getString("k_formato"));
                p.setK_estado(rs.getString("k_estado"));
                p.setD_descripcion(rs.getString("d_descripcion"));
                lista.add(p);
                
                
            }
        }
        catch(SQLException e){
            System.out.println("ERROR EN LISTAR PRODCUTOS daoProducto "+ e);
        }
        System.out.println("se envian productoss: "+ lista.size());
        return lista;
    }
    
    
    
    public String getN_Proveedor(int K_producto){
        String nombre = null;
        String sql = "SELECT u.n_usuario FROM producto p, catalogo c, usuario u WHERE u.K_USUARIO=c.K_USUARIO AND c.K_PRODUCTO=p.K_PRODUCTO AND P.K_PRODUCTO="+ K_producto;
    
    try{
        conn = cn.getConnection();
        st = conn.prepareStatement(sql);
        rs = st.executeQuery();
        while(rs.next()){
            nombre = rs.getString("n_usuario");
        }
    }
    catch(SQLException e ){
        System.out.println("error en get proveedor "+e);
    }
    
    return nombre;
    }
}
