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
 * @author Dustin Pisco
 */
public class Tipo {

    public Tipo(String par, String par1) {
    }
    private char code;
    private String nombretipo;
    
    public void Tipo(char tipo,String nombretipo){
        this.code = code;
        this.nombretipo = nombretipo;
    }
    public void setNombreTipo(String nombretipo){
        this.nombretipo = nombretipo;
    }
    
    public void SetCode(char tipo){
        this.code = tipo;
    }
    
    public String getNombreTipo(){
        return nombretipo;
    }
    
    public char getCode(){
        return code;
    }
    
    
    
    
    public static ArrayList<Tipo>CargarTipos(){
        ArrayList <Tipo> tipos = new ArrayList();
        try(BufferedReader bf = new BufferedReader(new FileReader("src/recursos/tipos.txt"))){
            String linea ;
            while ((linea= bf.readLine())!= null){
                String p[] = linea.split("=");
                tipos.add(new Tipo(p[0],p[1]));
              
            }
        }catch(FileNotFoundException ex){
            
            System.out.print("No se encontro el archivo");
        }catch (IOException ex){
            System.out.print("Se ha producido un error");
        }
        return tipos;
    }
}
