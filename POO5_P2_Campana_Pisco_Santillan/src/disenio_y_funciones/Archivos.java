/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package disenio_y_funciones;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import modelo.Comida;
import modelo.local;

/**
 *
 * @author Dustin Pisco
 */
class Archivos {
    public static ArrayList<String> leerArchivos(String ruta   ) throws IOException{
        ArrayList<String> data=new ArrayList();
        try ( BufferedReader bf = new BufferedReader(new FileReader(ruta))) {
            String linea;
            while ((linea = bf.readLine()) != null) {
                
                data.add(linea);
            }

        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException | NullPointerException ex) {
            System.out.println(ex.getMessage());
        }
        
        return data;
    }
}
