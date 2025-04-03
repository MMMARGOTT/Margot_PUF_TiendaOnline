/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Gestor;

import com.sun.jdi.connect.spi.Connection;
import excepciones.MyException;
import java.io.IOException;
import java.util.ArrayList;
import modelo.Pedido;

/**
 *
 * @author paolaschicote
 */
public class Gestor {
    
    private static final String driver = "com.mysql.jdbc.Driver";

    private String user;
    private String db;
    private String conexion;
    private String password;
    private Connection conn;
    private ArrayList<Pedido> listaPedidos = new ArrayList<Pedido>();

    public Gestor(String user, String db, String conexion, String password) {
    this.user = user;
    this.db = db;
    this.conexion = conexion;
    this.password = password;
    this.conn = null;  
}
   
 public void initDataBase() throws MyException {
        try {
            Class.forName(driver);  // Cargar el driver

            this.conn = DriverManager.getConnection(conexion + db, user, password);  

        } catch (ClassNotFoundException ex) {
            throw new MyException("No has puesto la librería MySQL");
        } catch (SQLException ex) {
            throw new MyException(ex.getSQLState() + " Error al conectar");
        }
 }

    public void cerrarConexion() throws MyException, IOException {
        try {
            this.conn.close();
            System.out.println("La base de datos se ha cerrado con éxito");

        } catch (SQLException ex) {
            throw new MyException("Error al cerrar la conexión");
        }
    }
}
