/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLDataException;
import java.sql.SQLException;
import modelo.VO.IngresoVO;

/**
 *
 * @author CAMILO
 */
public class Consultas {

    /**
     *
     * @param conexion
     * @param i
     * @throws SQLException
     */
    public  void guardarIngresos(Connection conexion, IngresoVO i) throws SQLException {
        try {

            PreparedStatement consulta;
            consulta = conexion.prepareStatement("INSERT INTO registro(placa,fecha,modelo,tipo,valor)" + "VALUES(?,?,?,?,?)");
            consulta.setString(1, i.getPlaca());
            consulta.setString(2, i.getFecha());
            consulta.setInt(3, i.getModelo());
            consulta.setInt(4, i.getTipo());
            consulta.setInt(5, i.getValor());

            consulta.executeUpdate();

            System.out.println("La consulta se realizo correctamente");
            
        } catch (SQLException | NumberFormatException e) {
            
            System.out.println("Error en la consulta");
             throw new SQLDataException(e);
        }
    }

    public static String Totalizar(Connection conexion, IngresoVO ingreso) {
        try {

            PreparedStatement consult;
            consult = conexion.prepareStatement("select" + "sum(valor)as total, count(placa) as cantidad,tipo"
                    + "from registro group by tipo");

            ResultSet rs = consult.executeQuery();
            String total = "";
            if (rs.next()) {
                total = total + "El total de carros es:" + rs.getInt("cantidad") + "con un valor de:" + rs.getInt("valor") + "";

            }
            if (rs.next()) {

                total = total + "El total de motos es:" + rs.getInt("cantidad") + "con un valor de:" + rs.getInt("valor") + "";
            }
            return total;

        } catch (Exception e) {

        }
        return "Error al totalizar";
    }

    
}
