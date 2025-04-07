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

    public Producto(int idPedido, String nombreCliente, String productos, double totalPagar) {
        super(idPedido, nombreCliente, productos, totalPagar);
        this.id = id;
    }

   
}
