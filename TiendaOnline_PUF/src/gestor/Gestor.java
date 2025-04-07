/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestor;

import java.sql.*;
import excepciones.MyException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import modelo.Estado;
import modelo.Pedido;

/**
 *
 * @author paolaschicote
 */
public class Gestor {

    private static final String driver = "com.mysql.cj.jdbc.Driver";

    private String user;
    private String db;
    private String conexion;
    private String password;
    private Connection conn;
    private ArrayList<Pedido> listaPedidos = new ArrayList<>();

    public Gestor(String user, String db, String conexion, String password) {
        this.user = user;
        this.db = db;
        this.conexion = conexion;
        this.password = password;
        this.conn = null;
    }

    public void initDataBase() throws MyException {
        try {

            Class.forName(driver);

            this.conn = DriverManager.getConnection(conexion + db, user, password);

        } catch (ClassNotFoundException ex) {
            throw new MyException("No has puesto la librería MySQL");
        } catch (SQLException ex) {
            throw new MyException(ex.getSQLState() + " Error al conectar");
        }
    }

    public void cerrarConexion() throws MyException {
        try {
            this.conn.close();
            System.out.println("La base de datos se ha cerrado con éxito");

        } catch (SQLException ex) {
            throw new MyException("Error al cerrar la conexión");
        }
    }

    public boolean idValido(String idPedido) {

        String id = "^[0-9]";
        Pattern pattern = Pattern.compile(id);

        Matcher matcher = pattern.matcher(id);

        return matcher.matches();

    }
   

    public void registrarPedido(String nombreCliente, String productos, double totalPagar, Estado estado) {
        try {
            String sql = "INSERT INTO Pedidos (nombre_cliente, productos, total_pagar, estado_pedido) VALUES (?, ?, ?, ?)";
            PreparedStatement sentencia = conn.prepareStatement(sql);
            sentencia.setString(1, nombreCliente);
            sentencia.setString(2, productos);
            sentencia.setDouble(3, totalPagar);
            sentencia.setString(4, estado.toString()); //Esto es un enum

            int pedidosInsertados = sentencia.executeUpdate();
            if (pedidosInsertados > 0) {
                JOptionPane.showMessageDialog(null, "Pedido registrado con éxito.");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        }
    }

    public void consultarPedidosPorCliente(String nombreCliente) {
        try {
            String sql = "SELECT * FROM Pedidos WHERE nombre_cliente = ?";
            PreparedStatement sentencia = conn.prepareStatement(sql);
            sentencia.setString(1, nombreCliente);
            ResultSet rs = sentencia.executeQuery();

            while (rs.next()) {
                System.out.println("Id: " + rs.getInt("id") + "Productos: " + rs.getString("productos") + "Total: " + rs.getDouble("total_pagar") + "Estado: " + rs.getString("estado_pedido"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        }
    }

    public void modificarEstadoPedido(int idPedido, String nuevoEstadoPedido) {
        try {
            String sql = "UPDATE Pedidos SET estado_pedido = ? WHERE id = ?";
            PreparedStatement sentencia = conn.prepareStatement(sql);
            sentencia.setString(1, nuevoEstadoPedido);
            sentencia.setInt(2, idPedido);

            int pedidoActualizado = sentencia.executeUpdate();
            if (pedidoActualizado > 0) {
                JOptionPane.showMessageDialog(null, "El pedido se ha actualizado con éxito.");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        }
    }

    public void eliminarPedido(int idPedido) {
        try {
            String sql = "DELETE FROM Pedidos WHERE id = ?";
            PreparedStatement sentencia = conn.prepareStatement(sql);
            sentencia.setInt(1, idPedido);

            int pedidoEliminados = sentencia.executeUpdate();
            if (pedidoEliminados > 0) {
                JOptionPane.showMessageDialog(null, "Pedido eliminado con éxito");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        }
    }

    public void registrarPago(int idPedido, String metodoPago, Date fechaPago) {
        try {
            String sql = "INSERT INTO Pagos (id_pedido, metodo_pago, fecha_pago) VALUES (?, ?, ?)";
            PreparedStatement sentencia = conn.prepareStatement(sql);
            sentencia.setInt(1, idPedido);
            sentencia.setString(2, metodoPago);
            sentencia.setDate(3, fechaPago);

            int pagoRegistrado = sentencia.executeUpdate();
            if (pagoRegistrado > 0) {
                JOptionPane.showMessageDialog(null, "Pago registrado con éxito.");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        }
    }

    /*

    public void pagoRegistrado(int idPedido) {    igual es boolean al ser un estado?
        try {
            String sql = "SELECT COUNT(*) FROM Pagos WHERE id_pedido = ?";
            PreparedStatement sentencia = conn.prepareStatement(sql);
            sentencia.setInt(1, idPedido);
            ResultSet rs = sentencia.executeQuery();

        }
    }
     */
    public void actualizarEstadoPedido(int idPedido) {

    }
}
