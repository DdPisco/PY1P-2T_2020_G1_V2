
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package disenio_y_funciones;

import java.awt.Paint;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import static java.lang.Double.parseDouble;
import java.util.ArrayList;
import java.util.Collections;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import modelo.local;

/**
 *
 * @author Lenovo
 */
public class ventanaMapa {
    Pane root;
    public void mostrarVentanaMapa(){
        
        Stage mapa=new Stage();
        root=new Pane();
        root.setStyle("-fx-background-image: url(/Imagenes/mapa2.png);-fx-background-size: 750px,500px;-fx-background-repeat: no-repeat no-repeat;");
  
        Scene scene = new Scene(root,750, 500);
        
        mapa.setTitle("mapa");
        mapa.setScene(scene);
        mapa.show();
        
    }
    
    
    
    
    
    
    
    
    
    
    public ArrayList<local> leerArchivo(){
        ArrayList<local> locales=new ArrayList();
        try ( BufferedReader bf = new BufferedReader(new FileReader("src/recursos/locales.txt"))) {
            String linea;
            while ((linea = bf.readLine()) != null) {
                String p[] = linea.split(",");
                locales.add(new local(p[3],p[2],p[4],Double.parseDouble(p[0]),Double.parseDouble(p[1])));
            }

        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } catch (NullPointerException ex){
            System.out.println(ex.getMessage());
        }
        
        return locales;
    }
}
