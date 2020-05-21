/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author CAMILO
 */
public class Conexion {

    public static Connection cnx = null;
    static Statement sentencia;

    public Conexion() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            cnx = DriverManager.getConnection("jdbc:mysql://localhost/parqueadero", "root", "");
            sentencia = cnx.createStatement();
            if (cnx != null) {
                System.out.println("Conexion Establecida...");
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error al Conectarse... " + e);
        }
    }

    public Connection obtener() {
        return cnx;
    }

}
    
