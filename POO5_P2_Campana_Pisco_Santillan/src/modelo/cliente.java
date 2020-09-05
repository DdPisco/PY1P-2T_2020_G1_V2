/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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

    public String toString(){
        return nombre;
    }
    

    public ArrayList<cliente> leerArchivo(){
         ArrayList<cliente> clientes=new ArrayList();
        
        try ( BufferedReader bf = new BufferedReader(new FileReader("src/recursos/clientes.txt"))) {
             String linea;
             while ((linea = bf.readLine()) != null) {
                 String p[] = linea.split(",");
                clientes.add(new cliente (p[0],p[1],p[2],p[3]));
         }
        } catch (IOException | NullPointerException ex) {
             System.out.println(ex.getMessage());
         }
         
         return clientes;
     }

}
