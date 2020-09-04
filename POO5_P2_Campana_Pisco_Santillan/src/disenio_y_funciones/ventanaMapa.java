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
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import modelo.local;

/**
 *
 * @author Lenovo
 */
public class ventanaMapa {
    Pane root;
    ArrayList<local> listalocales;
    Label cuenta;
    Stage info;
    Thread t2;
    public void mostrarVentanaMapa(){
        
        Stage mapa=new Stage();
        root=new Pane();
        root.setStyle("-fx-background-image: url(/imagenes/mapa2.png);-fx-background-size: 750px,500px;-fx-background-repeat: no-repeat no-repeat;");
        listalocales=leerArchivo();
        Thread t1=new Thread(new Runnable(){
            @Override
            public void run() {
                mostrarImagen(); 
            }
        });
        t1.start();
        
     
        Scene scene = new Scene(root,750, 500);
        
        mapa.setTitle("mapa");
        mapa.setScene(scene);
        mapa.show();
        
    }
    public ArrayList<local> leerArchivo(){
        ArrayList<local> locales=new ArrayList();
        try ( BufferedReader bf = new BufferedReader(new FileReader("src/recursos/localessin.txt"))) {
            String linea;
            while ((linea = bf.readLine()) != null) {
                String p[] = linea.split(",");
                locales.add(new local(p[3],p[2],p[4],Double.parseDouble(p[0]),Double.parseDouble(p[1])));
            }

        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException | NullPointerException ex) {
            System.out.println(ex.getMessage());
        }
        
        return locales;
    }
    public void mostrarImagen(){
        
        for (local l : listalocales) {
            ImageView localisacion = new ImageView(new Image("imagenes/local.png"));
            localisacion.setFitHeight(30);
            localisacion.setFitWidth(30);
            Double cordenadax = l.getCoordenadaX();
            Double cordenaday = l.getCoordenadaY();
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    localisacion.setLayoutX(cordenadax);
                    localisacion.setLayoutY(cordenaday);
                    root.getChildren().add(localisacion);
                }
            });
            localisacion.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent t) {
                    mostrarVentanainfo(l);
                    t2 = new Thread(new Runnable(){
                    @Override
                    public void run() {
                        for (int i = 5; i >0; i--) {
                            iniciarCuenta(i);
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException ex) {
                                ex.printStackTrace();
                               }
                        }
                        cerrarVentana(info);
                       }
                });
                    t2.start();
                    
                    }
            });
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(ventanaMapa.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    public void mostrarVentanainfo(local l){
        VBox datos=new VBox(20);
        HBox cuentaBoton=new HBox(40);
        datos.setPadding(new Insets(10,10,10,10));
        Label l1=new Label(l.getNombre());
        Label l2=new Label(l.getDireccion());
        Label l3=new Label(l.getHorario());
        l1.setStyle( "-fx-font-size: 15px;-fx-font-family:Arial Black;-fx-font-weight: bold;");
        l1.setTextFill(Color.BLACK);
        l2.setStyle( "-fx-font-size: 15px;-fx-font-family:Arial Black;-fx-font-weight: bold;");
        l2.setTextFill(Color.BLACK);
        l3.setStyle( "-fx-font-size: 15px;-fx-font-family:Arial Black;-fx-font-weight: bold;");
        l3.setTextFill(Color.BLACK);
        cuenta=new Label();
        cuenta.setStyle( "-fx-font-size: 15px;-fx-font-family:Arial Black;-fx-font-weight: bold;");
        cuenta.setTextFill(Color.BLACK);
        Button b1=new Button("Aceptar");
        cuentaBoton.setAlignment(Pos.CENTER);
        cuentaBoton.getChildren().addAll(cuenta,b1);
        datos.setAlignment(Pos.CENTER_LEFT);
        datos.getChildren().addAll(l1,l2,l3,cuentaBoton);
        datos.setStyle("-fx-background-color:orange");
        
        b1.setOnAction(new EventHandler <ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                info.close();
                t2.stop();
                }
        });
        
        
        info=new Stage();
        
        Scene scene = new Scene(datos,350, 200);
        
        info.setTitle("informacion");
        info.setScene(scene);
        info.show();
     
    }
    public void iniciarCuenta(int n){
        Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    cuenta.setText("Mostrando "+n+" segundos...");
                }
            });
        
    }
    public void cerrarVentana(Stage i){
        Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    i.close();
                }
            });
        
    }
}
