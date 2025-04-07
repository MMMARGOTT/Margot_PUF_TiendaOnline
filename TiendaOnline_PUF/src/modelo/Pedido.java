/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author paolaschicote
 */
public class Pedido {

    private int idPedido;
    private String nombreCliente;
    private String productos;
    private double totalPagar;
    private Estado estados;

    public Pedido(int idPedido, String nombreCliente, String productos, double totalPagar) {
        this.idPedido = idPedido;
        this.nombreCliente = nombreCliente;
        this.productos = productos;
        this.totalPagar = totalPagar;
        this.estados = Estado.EN_PROCESO;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getProductos() {
        return productos;
    }

    public void setProductos(String productos) {
        this.productos = productos;
    }

    public double getTotalPagar() {
        return totalPagar;
    }

    public void setTotalPagar(double totalPagar) {
        this.totalPagar = totalPagar;
    }

    public Estado getEstados() {
        return estados;
    }

    public void setEstados(Estado estados) {
        this.estados = estados;
    }

    @Override
    public String toString() {
        return "Pedido{" + "idPedido=" + idPedido + ", nombreCliente=" + nombreCliente + ", productos=" + productos + ", totalPagar=" + totalPagar + ", estados=" + estados + '}';
    }
    
    
}