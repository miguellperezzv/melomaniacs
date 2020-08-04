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
            System.out.println("SENTENCIA SQL ES "+ sql);
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
            System.out.println("SENTENCIA SQL ES "+ sql);
            while(rs.next()){
                cant = rs.getInt("count(*)");
            }
        }
        catch(SQLException e ){
            System.out.println("Error en get CANT SEGUN /producto dao" +e );
        }
        
        return cant;
    }
    
}
