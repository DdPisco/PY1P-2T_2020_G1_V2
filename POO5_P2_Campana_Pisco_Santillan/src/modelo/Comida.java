/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Lenovo
 */
public class Comida implements Comparable<Comida>{
    private String descripcion;
    private Double precio;
    private Tipo tipo;
    
    public Comida(String descripcion,double precio,Tipo tipo){
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
    public Tipo getTipo(){
        return tipo;
    }
    public void setTipo(Tipo tipo){
        this.tipo=tipo;
    }

    @Override
    public int compareTo(Comida o) {
        return 0;
        
    }
    public static ArrayList<Comida> CargarMenu(Tipo tipo){
         ArrayList <Comida> Menu = new ArrayList();
        try(BufferedReader bf = new BufferedReader(new FileReader("src/recursos/menu.txt"))){
            String linea ;
            while ((linea= bf.readLine())!= null){
                String p[] = linea.split(",");
                if(p[2].equals(tipo.getCode())){
                    Menu.add(new Comida(p[0],Integer.valueOf(p[1]),tipo));
                } 
            }
        }catch(FileNotFoundException ex){
            System.out.print("No se encontro el archivo menu");
        }catch (IOException ex){
            System.out.print("Se ha producido un error");
        }
        return Menu;
    }
}
