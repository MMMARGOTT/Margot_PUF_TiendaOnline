/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestor;

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
    
     public void registrarPedido(String nombreCliente, String productos, double totalPagar, String estadoPedido) throws MyException {
        String query = "INSERT INTO pedidos (nombre, productos, total_pagar, estado_pedido) VALUES (?, ?, ?, ?)";
        try (PreparedStatement secuencia = conn.prepareStatement(query)) {
            secuencia.setString(1, nombre);
            secuencia.setString(2, productos);
           secuencia.setDouble(3, totalPagar);
            secuencia.setString(4, estadoPedido);
            secuencia.executeUpdate();
            System.out.println("Pedido registrado correctamente.");
        } catch (SQLException e) {
            throw new MyException("Error al registrar el pedido: " + e.getMessage());
        }
    }
     
       // Consultar pedidos por el nombre
    public ArrayList<Pedido> consultarPedidosPorNombre(String nombre) throws MyException {
        ArrayList<Pedido> pedidos = new ArrayList<>();
        String query = "SELECT * FROM pedidos WHERE nombre = ?";
        try (PreparedStatement sentencia = conn.prepareStatement(query)) {
            sentencia.setString(1, nombreCliente);
            ResultSet rs = sentencia.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String productos = rs.getString("productos");
                double totalPagar = rs.getDouble("total_pagar");
                String estado = rs.getString("estado_pedido");
                pedidos.add(new Pedido(id, nombre, productos, totalPagar, estado));
            }
        } catch (SQLException e) {
            throw new MyException("Error al consultar los pedidos: " + e.getMessage());
        }
        return listaPedidos;
    }
    
      public void modificarPedido(int idPedido, String nuevoEstado) throws MyException {
      
        String query = "UPDATE Pedidos SET estado_pedido = ? WHERE id = ?";
        try (PreparedStatement sentencia = conn.prepareStatement(query)) {
            sentencia.setString(1, nuevoEstado);
            sentencia.setInt(2, idPedido);
            int rowsUpdated = sentencia.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Estado del pedido actualizado.");
            } else {
                throw new MyException("Pedido no encontrado.");
            }
        } catch (SQLException e) {
            throw new MyException("Error al modificar el estado del pedido: " + e.getMessage());
        }
    }
}
