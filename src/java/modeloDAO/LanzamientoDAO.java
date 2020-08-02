/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloDAO;

import config.Conexion;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletResponse;

import modelo.Lanzamiento;

/**
 *
 * @author luisy
 */
public class LanzamientoDAO {

    Connection conn;
    Conexion cn = new Conexion();
    PreparedStatement st;
    ResultSet rs;

    
    
    
    public void agregar (Lanzamiento l){
        String sql = "INSERT INTO PERSONA VALUES ("+l.getK_artista()+"," +this.getNumeroLanzamientos(l.getK_artista())+1 + ", '"+l.getK_genero()+"' , "+l.getF_lanzamiento()+" ,'"+l.getN_lanzamiento()+"' ,"+l.getI_lanzamiento()+"  )";
        
        try{
            conn = cn.getConnection();
            System.out.println("SENTENCIA INGRESAR LANZ. ES  "+ sql);
            st=conn.prepareStatement(sql);
            st.executeUpdate();
        }
        catch(SQLException e){
            System.out.println("ERROR EN agregar lanzamiento "+ e);
        }
    
    }
    
    
    
    
    
    public List<Lanzamiento> listarLanzamientos() {

        List<Lanzamiento> lista = new ArrayList<>();
        String sql = "SELECT * FROM LANZAMIENTO l, ARTISTA a WHERE a.k_artista = l.k_artista ";
        try {
            conn = cn.getConnection();
            st = conn.prepareCall(sql);
            System.out.println("LA SENTENCIA SQL ES :" + sql);
            rs = st.executeQuery();
            while (rs.next()) {
                Lanzamiento l = new Lanzamiento();
                l.setK_artista(rs.getInt("k_artista"));
                l.setK_lanzamiento(rs.getInt("k_lanzamiento"));
                l.setK_genero(rs.getString("k_genero"));
                l.setF_lanzamiento(rs.getDate("f_lanzamiento"));
                l.setN_lanzamiento(rs.getString("n_lanzamiento"));
                l.setI_lanzamiento(rs.getBinaryStream("i_lanzamiento"));
                lista.add(l);
            }
            return lista;

        } catch (SQLException e) {
            System.out.println("ERROR EN LISTAR EN LANZAMIENTO DAO " + e);
            return lista;
        }
    }

    public void listarIMG(int k_lanzamiento, HttpServletResponse response) {
        String sql = "SELECT * FROM lanzamiento WHERE k_lanzamiento="+k_lanzamiento;
        InputStream inputstream = null;
        OutputStream outputstream = null;
        BufferedInputStream bufferedinputstream = null;
        BufferedOutputStream bufferedoutputstream = null;
        
        
        try{
            outputstream = response.getOutputStream();
            conn = cn.getConnection();
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            while(rs.next()){
                inputstream = rs.getBinaryStream("i_lanzamiento");
            }
            bufferedinputstream = new BufferedInputStream(inputstream);
            bufferedoutputstream = new BufferedOutputStream(outputstream);
            int i=0;
            while((i=bufferedinputstream.read()) !=-1){
                bufferedoutputstream.write(i);
            }
        }
        catch (SQLException e){
            System.out.println("Error Listando imagenes (listarIMG)");
        } catch (IOException ex) {
            Logger.getLogger(LanzamientoDAO.class.getName()).log(Level.SEVERE, "Error ioexception ", ex);
        }
    }

    private int getNumeroLanzamientos(int k_artista) {
        String sql = "SELECT COUNT(*) FROM lanzamiento WHERE k_artista = "+k_artista+";";
        int cantidad =0;
        try{
            conn = cn.getConnection();
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            while(rs.next()){
                cantidad = rs.getInt("count");
                
            }
        }
        catch(SQLException e){
            System.out.println("Error en getNumero Lanzamientos" + e);
            
        }
        return cantidad;
    }
}
