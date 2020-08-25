/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloDAO;

/**
 *
 * @author luisy
 */


import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Genero;

public class GeneroDAO {
    Connection conn;
    Conexion cn = new Conexion();
    PreparedStatement st;
    ResultSet rs;
    
    public List<Genero> listarGeneros(){
        
        ArrayList<Genero> generos = new ArrayList<>();
        String sql = "SELECT * FROM genero";
        
        try{
            conn = cn.getConnection();
            st = conn.prepareStatement(sql);
            rs= st.executeQuery();
            while(rs.next()){
                Genero g = new Genero();
                g.setK_genero(rs.getString("k_genero"));
                generos.add(g);
            }
            conn.close();
            return generos;
        }
        catch(SQLException e){
            e.printStackTrace();
            return generos;
        }
    }
}
