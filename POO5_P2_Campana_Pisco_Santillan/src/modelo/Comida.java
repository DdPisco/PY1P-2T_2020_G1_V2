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
public class Comida implements Comparable<Comida>{
    private String descripcion;
    private Double precio;
    private char tipo;
    
    public Comida(String descripcion,double precio,char tipo){
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
    public int compareTo(Comida o) {
        return 0;
        
    }
}
