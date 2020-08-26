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
public class menuComida implements Comparable<menuComida>{
    private String descripcion;
    private Double precio;
    private char tipo;
    
    public menuComida(String descripcion,double precio,char tipo){
        this.descripcion=descripcion;
        this.precio=precio;
        this.tipo=tipo;
    }
    public String getDescripcion(){
        return descripcion;
    }
    public void setDescripcion(String desc){
        this.descripcion=desc;
    }
    public double getPrecio(){
        return precio;
    }
    public void setPrecio(double precio){
        this.precio=precio;
    }
    public char getTipo(){
        return tipo;
    }
    public void setTipo(char tipo){
        this.tipo=tipo;
    }

    @Override
    public int compareTo(menuComida o) {
        return 0;
        
    }
}
