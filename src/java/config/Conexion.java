/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author luisy
 */
public class Conexion {
    Connection conn;
    Connection connhosting;
    
    Connection connSQL;
    static String nombreBD="melomaniacs";
    String user ="postgres";
    String pass = "postgres";
    String userMYSQL = "root";
    String passMYSQL ="root123";
    
    String userhosting = "root";
    String passhosting ="g9vUjjeusz";
    
    
 
 
    public Connection getConnection() throws SQLException{
        try {
                Class.forName("com.mysql.jdbc.Driver");
                
                connSQL = DriverManager.getConnection("jdbc:mysql://localhost:3306/melomaniacsdb", userMYSQL, passMYSQL);
                //conn= DriverManager.getConnection("jdbc:postgresql://localhost:5432/melomaniacs", user, pass);
                //connhosting = DriverManager.getConnection("jdbc:mysql://node52360-env-7628496.jelastic.saveincloud.net:3306/melomaniacs", userhosting, passhosting);
                System.out.println("Conexión realizada. .  .   . ");
            } catch (ClassNotFoundException | SQLException ex) {
                System.out.print("Error en conexion con la Base De datos: "+ex );
            }
        
        return connSQL;
        //return connhosting;
    }
}
