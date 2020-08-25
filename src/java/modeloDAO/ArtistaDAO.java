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

/**
 *
 * @author luisy
 */
public class ArtistaDAO {

    Connection conn;
    Conexion cn = new Conexion();
    PreparedStatement st;
    ResultSet rs;

    public ArrayList<String> getArtistaNombre(String find) {

        ArrayList<String> nombres = new ArrayList<>();

        String sql = "SELECT * FROM artista WHERE LOWER (n_artista) LIKE '%" + find + "%'";

        try {
            conn = cn.getConnection();
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            System.out.println("SENTENCIA ES  " + sql);
            while (rs.next()) {
                nombres.add(rs.getString("n_artista"));
                System.out.println("ARTISTA " + rs.getString("n_artista"));
            }
            conn.close();
        } catch (SQLException e) {
            System.out.println("error en listado de artistas en dao " + e);
        }

        return nombres;

    }

    public int getCodigoporArtista(String n_artista) {

        String sql = "SELECT k_artista FROM artista WHERE LOWER (n_artista) = '" + n_artista.toLowerCase() + "'";
        int codigo = 0;
        try {
            conn = cn.getConnection();
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()) {
                codigo = rs.getInt("k_artista");
            }
            conn.close();
        } catch (SQLException e) {
            System.out.print("ERROR EN getCodigo" + e);
        }
        return codigo;

    }

    public Artista setArtista(int k_artista) {
        Artista a = new Artista();
        String sql = "SELECT * FROM artista WHERE k_artista = " + k_artista;

        try {
            conn = cn.getConnection();
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()) {
                a.setK_artista(rs.getInt("k_artista"));
                a.setN_artista(rs.getString("n_artista"));
                a.setD_artista(rs.getString("d_artista"));
            }
            conn.close();
        } catch (SQLException e) {
            System.out.println("ERROR EN SET ARTISTA DAO" + e);
        }
        return a;
    }

    public List<Artista> getArtistasFormato(String key) {

        List<Artista> lista = new ArrayList<>();
        String sql = "SELECT a.K_ARTISTA, a.N_ARTISTA, count(*) FROM producto p, formato f, artista a, lanzamiento l WHERE \n"
                + "                p.K_FORMATO = f.K_FORMATO\n"
                + "                AND p.K_ARTISTA = a.K_ARTISTA\n"
                + "                AND p.K_LANZAMIENTO = l.K_LANZAMIENTO\n"
                + "                AND a.K_ARTISTA = l.K_ARTISTA\n"
                + "                AND f.K_FORMATO='"+key+"'\n"
                + "                GROUP BY a.K_ARTISTA, a.N_ARTISTA";

        try {
            conn = cn.getConnection();
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()) {
                Artista a = new Artista();
                a.setK_artista(rs.getInt("k_artista"));
                a.setN_artista(rs.getString("n_artista"));
                a.setCount(rs.getInt("count(*)"));
                lista.add(a);
            }
            conn.close();
        } catch (SQLException e) {
            System.out.println("ERROR EN LISTAR VINILOS" + e);
        }
        return lista;

    }

}
