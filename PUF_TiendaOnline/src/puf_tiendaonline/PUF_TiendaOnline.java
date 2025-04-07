/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package puf_tiendaonline;

import gestor.Gestor;
import excepciones.MyException;

/**
 *
 * @author paolaschicote
 */
public class PUF_TiendaOnline {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        try {
            Gestor miConexion = new Gestor("paola", "PUF", "jdbc:mysql://localhost:3306/", "contrasenia");
            miConexion.initDataBase();

            /* //Estas tres líneas sirven para inicializar una interfaz (se utiliza siempre)
            IniciarSesion pp = new IniciarSesion(miConexion);
            pp.setVisible(true);
            pp.setLocationRelativeTo(null); //Para poner la ventana en el centro
             */
            
        } catch (MyException ex) {

        }

    }
}
