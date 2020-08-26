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
public class pagoTarjeta extends pago{
    private String titular;
    private String numero;       
    private String caducidad;
    private int CVV;
    
    public pagoTarjeta(double idPago, double idPedido, String nombreCliente, double totalPagar, String fecha, char tipo) {
        super(idPago, idPedido, nombreCliente, totalPagar, fecha, tipo);
    }
    public String getTitular(){
        return titular;
    }
    public void setTitular(String t){
        this.titular=t;
    }
    public String getNumero(){
        return numero;
    }
    public void setNumero(String num){
        this.numero=num;
    }
    public String getcaducidad(){
        return caducidad;
    }
    public void setCaducidad(String cad){
        this.caducidad=cad;
    }
    public int getCVV(){
        return CVV;
    }
    public void setCVV(int cvv){
        this.CVV=cvv;
    }
}
