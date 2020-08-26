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
    private int coordenadaX;
    private int coordenadaY;
    
    public local(String nombre,String direccion,String horario,
            int cordenadax,int cordenaday){
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
    public int getCoordenadaX(){
        return coordenadaX;
    }
    public void setCoordenadaX(int coordenada){
        this.coordenadaX=coordenada;
    }
    public int getCoordenadaY(){
        return coordenadaY;
    }
    public void setCoordenadaY(int coordenada){
        this.coordenadaY=coordenada;
    }
}
