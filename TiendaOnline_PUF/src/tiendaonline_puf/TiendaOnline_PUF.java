/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tiendaonline_puf;

import excepciones.MyException;
import gestor.Gestor;
import interfaces.MenuPrincipal;

/**
 *
 * @author paolaschicote
 */
public class TiendaOnline_PUF {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        try {
            Gestor miConexion = new Gestor("puf", "puf", "jdbc:mysql://localhost:3306/", "puf");

            miConexion.initDataBase();
            

            MenuPrincipal mp = new MenuPrincipal(miConexion);
            mp.setVisible(true);
            mp.setLocationRelativeTo(null);

        } catch (MyException ex) {

        }

    }

}
