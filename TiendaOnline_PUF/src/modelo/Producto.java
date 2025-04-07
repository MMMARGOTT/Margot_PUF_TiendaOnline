/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author paolaschicote
 */
public class Producto extends Pedido {

    private int id;

    public Producto(int id, String nombre, String productos, double totalPagar, String estado) {
        super(id, nombre, productos, totalPagar, estado);
        this.id = id;
    }
}
