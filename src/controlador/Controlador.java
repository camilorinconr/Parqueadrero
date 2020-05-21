/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.VO.FuncionesVO;
import modelo.VO.IngresoVO;
import servicios.DAO.Conexion;
import servicios.DAO.Consultas;
import vista.vista;

/**
 *
 * @author CAMILO
 */
public class Controlador implements ActionListener {

    private vista vista;
    private FuncionesVO funciones;

    public Controlador() {
    }

    public Controlador(vista vista) {
        this.vista = vista;
        actionListener(this);
    }

    private void actionListener(ActionListener controlador) {
        vista.btnagregar.addActionListener(controlador);
        vista.btnlimpiar.addActionListener(controlador);

        //botones segundo panel
        vista.btnreiniciar.addActionListener(controlador);
        vista.btntotalizar.addActionListener(controlador);

    }

    @Override
    public void actionPerformed(ActionEvent evento) {

        try {
            if (evento.getActionCommand().equals("Agregar")) {

                String placa = vista.txtplaca.getText();
                String modelo = vista.txtmodelo.getText();
                String fecha = vista.txtfecha.getDateFormatString();
                String tipo = vista.boxTipo.getSelectedItem().toString();
                String valor = vista.jTextArea1.getText();

                IngresoVO inf = new IngresoVO(placa, Integer.parseInt(modelo), Integer.parseInt(tipo), Integer.parseInt(valor),fecha);
                Controlador n = new Controlador();
                Connection conexion = null;
                n.guardar(inf);

            }

            if (evento.getActionCommand().equals("Totalizar")) {

            }
        } catch (NumberFormatException | SQLException e) {
        }
    }

    public static Boolean ExistePlaca(Connection conexion, String placa) throws ClassNotFoundException {
        try {

            PreparedStatement consulta;
            consulta = conexion.prepareStatement("SELECT * FROM registro WHERE placa = ?");
            consulta.setString(1, placa);

            ResultSet rs = consulta.executeQuery();
            return rs.next();
        } catch (SQLException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;

    }

    private void guardar(IngresoVO ingreso) throws SQLException {
        try {
            Consultas consultas = new Consultas();
            Conexion con = new Conexion();

            consultas.guardarIngresos(con.obtener(), ingreso);

            System.out.println("Se realizo la consulta control");

        } catch (Exception e) {
            
            System.out.println("Error en consulta control");

        }

    }

    public static void Eliminar(Connection conexion, IngresoVO ingreso) {
        try {

            PreparedStatement consulta;
            consulta = conexion.prepareStatement("DELET FROM registro");
            consulta.executeUpdate();

        } catch (Exception e) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, e);
        }
    }

}
