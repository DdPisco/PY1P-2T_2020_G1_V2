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
public class local {
    private String nombre;
    private String direccion;
    private String horario;
    private double coordenadaX;
    private double coordenadaY;
    
    public local(String nombre,String direccion,String horario,
            double cordenadax,double cordenaday){
        this.nombre=nombre;
        this.direccion=direccion;
        this.horario=horario;
        this.coordenadaX=cordenadax;
        this.coordenadaY=cordenaday;
    }
    public String getNombre(){
        return nombre;
    }
    public void setNombre(String nombre){
        this.nombre=nombre;
    }
    public String getDireccion(){
        return direccion;
    }
    public void setDireccion(String direccion){
        this.direccion=direccion;
    }
    public String getHorario(){
        return horario;
    }
    public void setHorario(String horario){
        this.horario=horario;
    }
    public double getCoordenadaX(){
        return coordenadaX;
    }
    public void setCoordenadaX(int coordenada){
        this.coordenadaX=coordenada;
    }
    public double getCoordenadaY(){
        return coordenadaY;
    }
    public void setCoordenadaY(int coordenada){
        this.coordenadaY=coordenada;
    }
}
