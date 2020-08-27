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
import modelo.Artista;

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
        String sql = "SELECT * FROM lanzamiento l, artista a WHERE a.k_artista = l.k_artista AND a.n_artista = '" + n_artista + "';";

        try {
            conn = cn.getConnection();
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()) {
                Lanzamiento l = new Lanzamiento();
                l.setK_lanzamiento(rs.getInt("K_lanzamiento"));
                l.setN_lanzamiento(rs.getString("n_lanzamiento"));
                lista.add(l);
            }

        } catch (SQLException e) {
            System.out.println("ERROR EN LISTAR IMAGEN Y NOMBRE DE LANZAMIENTO EN dao" + e);
        }
        return lista;
    }

    public void agregar(Lanzamiento l) {
        String sql = "INSERT INTO lanzamiento (K_ARTISTA, K_LANZAMIENTO, K_GENERO, F_LANZAMIENTO, N_LANZAMIENTO, i_lanzamiento, s_lanzamiento) "
                + "VALUES ( " + l.getK_artista() + "," + (this.getNumeroLanzamientos(l.getK_artista()) + 1) + ",'" + l.getK_genero() + "','" + l.getF_lanzamiento() + "', '" + l.getN_lanzamiento() + "','" + l.getI_lanzamiento() + "', '" + l.getS_lanzamiento() + "'  )";

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
        String sql = "SELECT * FROM lanzamiento l, artista a WHERE a.k_artista = l.k_artista ";
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
            conn.close();
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
            conn.close();
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
            conn.close();
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
                l.setS_lanzamiento(rs.getString("S_LANZAMIENTO"));
                l.setN_lanzamiento(rs.getString("n_lanzamiento"));
                l.setK_artista(rs.getInt("k_artista"));
                l.setK_lanzamiento(rs.getInt("k_lanzamiento"));
                l.setF_lanzamiento(rs.getDate("f_lanzamiento"));
                l.setI_lanzamiento(rs.getString("i_lanzamiento"));
                l.setK_genero(rs.getString("k_genero"));
                //l.setK_artista_nombre(this.getN_artista(l.getK_artista()));

            }
            return l;
            //conn.close();
        } catch (SQLException e) {
            System.out.print("ERROR EN GET LANZAMIENTO INDIV " + e);
            return l;
        }

        
    }

    public String getN_artista(int k_artista) {
        String n_artista = null;
        String sql = "SELECT n_artista FROM ARTISTA WHERE k_artista = " + k_artista;

        try {
            conn = cn.getConnection();
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();

            while (rs.next()) {
                n_artista = rs.getString("n_artista");
            }
            //conn.close();
        } catch (SQLException e) {
            System.out.println("Error en getnartista/daolanzamiento" + e);
        }

        return n_artista;
    }

    public int anioLanzamiento(int k_lanzamiento, int k_artista) {

        int anio = 0;
        String sql = "SELECT YEAR(F_LANZAMIENTO) FROM lanzamiento WHERE K_ARTISTA=" + k_artista + " AND K_LANZAMIENTO=" + k_lanzamiento + " ;";

        try {
            conn = cn.getConnection();
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();

            while (rs.next()) {
                anio = rs.getInt("YEAR(F_LANZAMIENTO)");
            }
            conn.close();
        } catch (SQLException e) {
            System.out.println("Error en getnanio/daolanzamiento" + e);
        }

        return anio;
    }

    public int cantLanzamiento(int k_lanzamiento, int k_artista) {
        int cant = 0;
        String sql = "SELECT COUNT(*) from producto WHERE K_ARTISTA=" + k_artista + " AND K_LANZAMIENTO=" + k_lanzamiento + " ;";

        try {
            conn = cn.getConnection();
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();

            while (rs.next()) {
                cant = rs.getInt("count(*)");
            }
            conn.close();
        } catch (SQLException e) {
            System.out.println("Error en getnanio/daolanzamiento" + e);
        }

        return cant;
    }

   

    public List<Lanzamiento> getLanzamientosFormato(String key) {
        List<Lanzamiento> lista = new ArrayList<>();
        String sql = "SELECT l.K_ARTISTA, l.K_LANZAMIENTO, l.N_LANZAMIENTO, l.I_LANZAMIENTO, count(*) FROM producto p, formato f, artista a, lanzamiento l WHERE \n"
                + "p.K_FORMATO = f.K_FORMATO\n"
                + "AND p.K_ARTISTA = a.K_ARTISTA\n"
                + "AND p.K_LANZAMIENTO = l.K_LANZAMIENTO\n"
                + "AND a.K_ARTISTA = l.K_ARTISTA\n"
                + "AND f.K_FORMATO='"+key+"'\n"
                + "GROUP BY l.K_ARTISTA, l.K_LANZAMIENTO, l.N_LANZAMIENTO, l.I_LANZAMIENTO";

        try {
            conn = cn.getConnection();
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()) {
                Lanzamiento l = new Lanzamiento();
                l.setI_lanzamiento(rs.getString("i_lanzamiento"));
                l.setK_artista(rs.getInt("k_artista"));
                l.setK_lanzamiento(rs.getInt("k_lanzamiento"));
                l.setN_lanzamiento(rs.getString("n_lanzamiento"));
                l.setCount(rs.getInt("count(*)"));
                lista.add(l);
            }
            conn.close();
        } catch (SQLException e) {
            System.out.println("ERROR EN LISTAR VINILOS" + e);
        }
        return lista;

    }
    
    public Lanzamiento getLanzamientoProducto(int producto) {
        Lanzamiento l = new Lanzamiento();
        String sql = "SELECT * FROM lanzamiento l, producto p WHERE p.k_lanzamiento = l.k_lanzamiento AND p.k_artista = l.k_artista \n"
                + "AND p.k_producto = "+ producto;

        try {
            conn = cn.getConnection();
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();

            while (rs.next()) {
                l.setS_lanzamiento(rs.getString("S_LANZAMIENTO"));
                l.setN_lanzamiento(rs.getString("n_lanzamiento"));
                l.setK_artista(rs.getInt("k_artista"));
                l.setK_lanzamiento(rs.getInt("k_lanzamiento"));
                l.setF_lanzamiento(rs.getDate("f_lanzamiento"));
                l.setI_lanzamiento(rs.getString("i_lanzamiento"));
                l.setK_genero(rs.getString("k_genero"));
                l.setK_artista_nombre(this.getN_artista(l.getK_artista()));
                conn.close();
            }
            return l;
            
        } catch (SQLException e) {
            System.out.print("ERROR EN GET LANZAMIENTO INDIV por producto " + e);
            return l;
        }

        
    }
    
    
    public List<Lanzamiento> ListarNuevosLanzamientos() {
        List<Lanzamiento> lista = new ArrayList<>();
        String sql = "SELECT * FROM lanzamiento ORDER BY F_LANZAMIENTO DESC LIMIT 10";
        try {
            conn = cn.getConnection();
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();

            while (rs.next()) {
                Lanzamiento l = new Lanzamiento();
                l.setI_lanzamiento(rs.getString("i_lanzamiento"));
                l.setK_artista_nombre(this.getN_artista(rs.getInt("k_artista")) );
                l.setN_lanzamiento(rs.getString("n_lanzamiento"));
                lista.add(l);
                
            }
            
            conn.close();
            System.out.println("se envian LAZNAMIENTOS NUEVOS" + lista.size());
            return lista;
        } catch (SQLException e) {
            System.out.println("Error en LISTAR NUEVOS lanzamientos" + e);
            return lista;
        }

    }
    
}
