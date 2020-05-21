/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

import controlador.Controlador;
import vista.vista;

/**
 *
 * @author CAMILO
 */
public class Principal {

    public static void main(String[] args) {

        vista vista = new vista();

        new Controlador(vista);
        vista.setLocationRelativeTo(vista);
        vista.setVisible(true);
    }
}
