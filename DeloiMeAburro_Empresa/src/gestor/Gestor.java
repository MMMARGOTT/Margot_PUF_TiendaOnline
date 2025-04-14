/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestor;

import com.sun.jdi.connect.spi.Connection;
import excepciones.MyException;

/**
 *
 * @author paolaschicote
 */
public class Gestor {
      private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private String user;
    private String db;
    private String conexion;
    private String password;
    private Connection conn;

    public Gestor(String user, String db, String conexion, String password) {
        this.user = user;
        this.db = db;
        this.conexion = conexion;
        this.password = password;
        this.conn = null;
    }

    public void initDataBase() throws MyException {
        try {
            Class.forName(DRIVER);
            this.conn = DriverManager.getConnection(conexion + db, user, password);
        } catch (ClassNotFoundException ex) {
            throw new MyException("No has puesto la librería MySQL");
        } catch (SQLException ex) {
            throw new MyException("Error al conectar: " + ex.getMessage());
        }
    }

    public void cerrarConexion() throws MyException {
        try {
            if (this.conn != null) {
                this.conn.close();
                System.out.println("Conexión cerrada.");
            }
        } catch (SQLException ex) {
            throw new MyException("Error al cerrar la conexión");
        }
    }

    public void registrarEmpleado(String nombre, String apellido, String puesto, double salario, String tipoContrato, int idJefe) {
        try {
            String sql = "INSERT INTO Empleados (nombre, apellido, puesto, salario, tipo_contrato, idJefe) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement sentencia = conn.prepareStatement(sql);
            sentencia.setString(1, nombre);
            sentencia.setString(2, apellido);
            sentencia.setString(3, puesto);
            sentencia.setDouble(4, salario);
            sentencia.setString(5, tipoContrato);
