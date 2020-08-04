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
import modelo.Estado;

/**
 *
 * @author luisy
 */
public class EstadoDAO {

    Connection conn;
    Conexion cn = new Conexion();
    PreparedStatement st;
    ResultSet rs;

    public List<Estado> getEstados() {
        ArrayList<Estado> estados = new ArrayList<>();
        String sql = "SELECT * FROM estado";
        
        try {
            conn = cn.getConnection();
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()) {
                Estado e = new Estado();
                e.setK_estado(rs.getString("k_estado"));
                estados.add(e);
                System.out.println("Estado agregado !!" + e.getK_estado());
            }
        } catch (SQLException e) {
                System.out.println("No se pudo listar estados !!" + e);
        }
        return estados;
    }
}
