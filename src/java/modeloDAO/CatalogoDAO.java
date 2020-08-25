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
public class CatalogoDAO {

    Connection conn;
    Conexion cn = new Conexion();
    PreparedStatement st;
    ResultSet rs;

    public List<Producto> productosUsuario(String k_usuario) {
        List<Producto> lista = new ArrayList<>();
        String sql = "select p.K_PRODUCTO, p.K_ESTADO, p.K_FORMATO, p.K_ARTISTA, p.K_LANZAMIENTO, p.D_DESCRIPCION,p.P_PRECIO \n"
                + "from catalogo c, producto p\n"
                + "where c.K_PRODUCTO = p.K_PRODUCTO\n"
                + "AND c.K_USUARIO = '"+k_usuario+"' \n"
                + "order by f_catalogo  DESC";

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
                //p.setP_precio(rs.getInt("p_precio"));
                lista.add(p);

            }
        } catch (SQLException e) {
            System.out.println("ERROR EN LISTAR PRODCUTOS daoProducto " + e);
        }
        return lista;
    }
}
