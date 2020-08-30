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
public class cliente {
    private String usuario;
    private String contrasenia;
    private String nombre;
    private String direccion;
    
    public cliente(String usuario,String contrasenia,String nombre,String direccion){
        this.usuario=usuario;
        this.contrasenia=contrasenia;
        this.nombre=nombre;
        this.direccion=direccion;
    }
    
    public String getUsuario(){
        return usuario;
    }
    public void setUsuario(String usu){
        this.usuario=usuario;
    }
    public String getContrasenia(){
        return contrasenia;
    }
    public void setContrasenia(String con){
        this.contrasenia=con;
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
    public void setDireccion(String dir){
        this.direccion=dir;
    }
    
}
