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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
    
    public ArrayList<Lanzamiento> listarNombres(String n_artista) {
        
        ArrayList<Lanzamiento> lista = new ArrayList<>();
        String sql = "SELECT * FROM LANZAMIENTO l, artista a WHERE a.k_artista = l.k_artista AND a.n_artista = '" + n_artista + "';";
        
        try {
            conn = cn.getConnection();
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()) {
                Lanzamiento l = new Lanzamiento();
                l.setI_lanzamiento(rs.getString("i_lanzamiento"));
                l.setN_lanzamiento("n_lanzamiento");
                lista.add(l);
            }
            
        } catch (SQLException e) {
            System.out.println("ERROR EN LISTAR IMAGEN Y NOMBRE DE LANZAMIENTO EN dao" + e);
        }
        return lista;
    }
    
    public void agregar(Lanzamiento l) {
        String sql = "INSERT INTO LANZAMIENTO (K_ARTISTA, K_LANZAMIENTO, K_GENERO, F_LANZAMIENTO, N_LANZAMIENTO, i_lanzamiento) "
                + "VALUES ( " + l.getK_artista() + "," + (this.getNumeroLanzamientos(l.getK_artista()) + 1) + ",'" + l.getK_genero() + "','" + l.getF_lanzamiento() + "', '" + l.getN_lanzamiento() + "','" + l.getI_lanzamiento() + "'  )";
        
        try {
            
            conn = cn.getConnection();
            
            st = conn.prepareStatement(sql);
            //st.setInt(1, l.getK_artista());
            //st.setInt(2, this.getNumeroLanzamientos(l.getK_artista())+1 );
            //st.setString(3, l.getK_genero());
            //st.setDate(4, (java.sql.Date) fechasql);
            //st.setString(5, l.getN_lanzamiento());
            //st.setBinaryStream(6, l.getI_lanzamiento());

            System.out.println("SENTENCIA INGRESAR LANZ. ES  " + sql);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println("ERROR EN agregar lanzamiento " + e);
        }
        
    }
    
    public List<Lanzamiento> listarLanzamientos() {
        
        List<Lanzamiento> lista = new ArrayList<>();
        String sql = "SELECT * FROM LANZAMIENTO l, ARTISTA a WHERE a.k_artista = l.k_artista ";
        try {
            conn = cn.getConnection();
            st = conn.prepareStatement(sql);
            System.out.println("LA SENTENCIA SQL ES :" + sql);
            rs = st.executeQuery();
            while (rs.next()) {
                Lanzamiento l = new Lanzamiento();
                l.setK_artista(rs.getInt("k_artista"));
                l.setK_lanzamiento(rs.getInt("k_lanzamiento"));
                l.setK_genero(rs.getString("k_genero"));
                l.setF_lanzamiento(rs.getDate("f_lanzamiento"));
                l.setN_lanzamiento((rs.getString("n_lanzamiento")).toUpperCase());
                l.setI_lanzamiento(rs.getString("i_lanzamiento"));
                l.setK_artista_nombre((rs.getString("n_artista")));
                lista.add(l);
            }
            return lista;
            
        } catch (SQLException e) {
            System.out.println("ERROR EN LISTAR EN LANZAMIENTO DAO " + e);
            return lista;
        }
    }
    
    public void listarIMG(int k_lanzamiento, HttpServletResponse response) {
        String sql = "SELECT * FROM lanzamiento WHERE k_lanzamiento=" + k_lanzamiento;
        InputStream inputstream = null;
        OutputStream outputstream = null;
        BufferedInputStream bufferedinputstream = null;
        BufferedOutputStream bufferedoutputstream = null;
        
        try {
            outputstream = response.getOutputStream();
            conn = cn.getConnection();
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()) {
                inputstream = rs.getBinaryStream("i_lanzamiento");
            }
            bufferedinputstream = new BufferedInputStream(inputstream);
            bufferedoutputstream = new BufferedOutputStream(outputstream);
            int i = 0;
            while ((i = bufferedinputstream.read()) != -1) {
                bufferedoutputstream.write(i);
            }
        } catch (SQLException e) {
            System.out.println("Error Listando imagenes (listarIMG)");
        } catch (IOException ex) {
            Logger.getLogger(LanzamientoDAO.class.getName()).log(Level.SEVERE, "Error ioexception ", ex);
        }
    }
    
    private int getNumeroLanzamientos(int k_artista) {
        String sql = "SELECT COUNT(*) FROM lanzamiento WHERE k_artista = " + k_artista + ";";
        int cantidad = 0;
        try {
            conn = cn.getConnection();
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()) {
                cantidad = rs.getInt("count(*)");
                
            }
        } catch (SQLException e) {
            System.out.println("Error en getNumero Lanzamientos" + e);
            
        }
        return cantidad;
    }
    
    public Lanzamiento getLanzamiento(int k_artista, int k_lanzamiento) {
        Lanzamiento l = new Lanzamiento();
        String sql = "SELECT * FROM lanzamiento WHERE K_ARTISTA=" + k_artista + " AND K_LANZAMIENTO= " + k_lanzamiento + ";";
        
        try {
            conn = cn.getConnection();
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            
            while (rs.next()) {
                l.setN_lanzamiento(rs.getString("n_lanzamiento"));
                l.setK_artista(rs.getInt("k_artista"));
                l.setK_lanzamiento(rs.getInt("k_lanzamiento"));
                l.setF_lanzamiento(rs.getDate("f_lanzamiento"));
                l.setI_lanzamiento(rs.getString("i_lanzamiento"));
                l.setK_genero(rs.getString("k_genero"));
                
            }
        } catch (SQLException e) {
            System.out.print("ERROR EN GET LANZAMIENTO INDIV "+ e);
        }
        
        return l;
    }
 
    
    public String getN_artista(int k_artista){
        String n_artista=null;
        String sql = "SELECT n_artista FROM ARTISTA WHERE k_artista = "+k_artista;
        
        try{
            conn = cn.getConnection();
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            
            while(rs.next()){
                n_artista = rs.getString("n_artista");
            }
        }
        catch(SQLException e ){
            
        }
        
        return n_artista;
    }
}
