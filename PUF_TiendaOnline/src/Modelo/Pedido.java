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

    private int id;
    private String nombre;
    private ArrayList<Producto> listaProductosComprados;
    private double totalPagar;
    private String estado;

    public Pedido(int id, String nombre, ArrayList<Producto> listaProductosComprados, double totalPagar, String estado) {
        this.id = id;
        this.nombre = nombre;
        this.listaProductosComprados = listaProductosComprados;
        this.totalPagar = totalPagar;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Producto> getListaProductosComprados() {
        return listaProductosComprados;
    }

    public void setListaProductosComprados(ArrayList<Producto> listaProductosComprados) {
        this.listaProductosComprados = listaProductosComprados;
    }

    public double getTotalPagar() {
        return totalPagar;
    }

    public void setTotalPagar(double totalPagar) {
        this.totalPagar = totalPagar;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Pedido{" + "id=" + id + ", nombre=" + nombre + ", listaProductosComprados=" + listaProductosComprados + ", totalPagar=" + totalPagar + ", estado=" + estado + '}';
    }

}
