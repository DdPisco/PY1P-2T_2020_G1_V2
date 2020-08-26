/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Lenovo
 */
public class pagoEfectivo extends pago{
    
    public pagoEfectivo(double idPago, double idPedido, String nombreCliente, double totalPagar, String fecha, char tipo) {
        super(idPago, idPedido, nombreCliente, totalPagar, fecha, tipo);
    }
    
}
