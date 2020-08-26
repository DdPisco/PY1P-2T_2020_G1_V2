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
public class pago {
    private double idPago;
    private double idPedido;
    private String nombreCliente;
    private double totalPagar;
    private String fecha;
    private char tipo;
    
    public pago(double idPago,double idPedido,String nombreCliente,
            double totalPagar,String fecha,char tipo){
        this.idPago=idPago;
        this.idPedido=idPedido;
        this.nombreCliente=nombreCliente;
        this.totalPagar=totalPagar;
        this.tipo=tipo;
    }
    public double getidPago(){
        return idPago;
    }
    public void setidPago(double id){
        this.idPago=id;
    }
    public double getidPedido(){
        return idPedido;
    }
    public void setidPedido(double id){
        this.idPedido=id;
    }
    public String getnombreCliente(){
        return nombreCliente;
    }
    public void setnombreCliente(String nombre){
        this.nombreCliente=nombre;
    }
    public double getTotalPagar(){
        return totalPagar;
    }
    public void setTotalPagar(double total){
        this.totalPagar=total;
    }
    public String getFecha(){
        return fecha;
    }
    public void setFecha(String fecha){
        this.fecha=fecha;
    }
    public char getTipo(){
        return tipo;
    }
    public void setTipo(char tipo){
        this.tipo=tipo;
    }
}
