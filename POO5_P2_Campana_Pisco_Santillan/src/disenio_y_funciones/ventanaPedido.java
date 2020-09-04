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
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import modelo.Comida;


/**
 *
 * @author Lenovo
 */
public class ventanaPedido {
    private Stage escenario;
    private Scene escena1;
    VBox tablaOpciones = new VBox();
//    public ventanaPedido(Stage escenario){
//        this.escenario = escenario;
//
//    }
    public void getScene() {
        Stage pedido=new Stage();
      VBox arbol=new VBox(20);
      HBox tipoOrden = new HBox(150);
      tipoOrden.setAlignment(Pos.CENTER);
      
      HBox OpcionesPedido= new HBox(300);

      //Estilo de Titulo
      StackPane titulo = new StackPane();
      Text Titulo = new Text("Realice su pedido");
      Titulo.setStyle("-fx-font-size: 28px;-fx-font-family:Arial Black;-fx-font-weight: bold;");
      Titulo.setFill(Color.ORANGE);


      //Creacion de la caja de Tipo de Plato
      HBox tipo = new HBox(30);
      Label lbtipo = new Label("Tipo:"); lbtipo.setStyle("-fx-font-weight: bold;");
      ComboBox optipo = new ComboBox();
      optipo.getItems().addAll("Piqueos","Platos Fuertes","Postres","Bebidas");   
      tipo.getChildren().addAll(lbtipo,optipo);
      System.out.print(optipo.getValue());
      optipo.addEventHandler(ActionEvent.ACTION,new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent t) {
                
                if(optipo.getValue().equals("Piqueos")){
                    try(BufferedReader bf = new BufferedReader(new FileReader("src/recursos/menu.txt"))){
                        String linea ;
                        while ((linea= bf.readLine())!= null){
                            String p[] = linea.split(",");
                            if(p[2].equals(tipo)){
                    //.add(new Comida(p[0],Integer.valueOf(p[1]),tipo));
                } 
            }
        }catch(FileNotFoundException ex){
            System.out.print("No se encontro el archivo menu");
        }catch (IOException ex){
            System.out.print("Se ha producido un error");
        }
                }if(optipo.getValue().equals("Platos Fuertes")){
                  
                }if(optipo.getValue().equals("Postres")){
                  
            }if(optipo.getValue().equals("Bebidas")){
                
            }
            }
          
      });
      //Creacion de la caja de Ordenar por
      HBox orden = new HBox(10);
      Label lborden = new Label("Ordenar por:"); lborden.setStyle("-fx-font-weight: bold;");
      ComboBox oporden = new ComboBox();
      oporden.getItems().addAll("Precio","A-Z","Z-A");
      orden.getChildren().addAll(lborden,oporden);
      
      
      

      //Linea de Texto de opciones y pedidos
      Text TxtOpciones = new Text("Opciones");
      TxtOpciones.setFill(Color.ORANGE);
      TxtOpciones.setStyle("-fx-font-weight:bold;-fx-font-size: 18px");
      Text TxtPedido = new Text("Pedido");
      TxtPedido.setFill(Color.ORANGE);
      TxtPedido.setStyle("-fx-font-weight:bold;-fx-font-size: 18px");
      OpcionesPedido.getChildren().addAll(TxtOpciones,TxtPedido);

      
      

      //Personalizacion de la tabla de Opciones
      Label lb1 = new Label("Descripcion");lb1.setStyle("-fx-font-weight: bold;");
      Label  lb2 = new Label("Precio");lb2.setStyle("-fx-font-weight: bold;");
      Label  lb3 = new Label("Cantidad");lb3.setStyle("-fx-font-weight: bold;");
      HBox detalles =new HBox(25);
      optipo.addEventHandler(ActionEvent.ACTION,new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent t) {
                
                if(optipo.getValue().equals("Piqueos")){
                   
                }if(optipo.getValue().equals("Platos Fuertes")){
                  
                }if(optipo.getValue().equals("Postres")){
                  
            }
            }
          
      });
      detalles.getChildren().addAll(lb1,lb2,lb3);
      
      
      
      
      
      GridPane totalpedido = new GridPane(); 
      totalpedido.setStyle("-fx-background-color:gray ;-fx-grid-lines-visible: true");
      Label lb4 = new Label("Descripcion");lb4.setStyle("-fx-font-weight: bold;");//lb4.setTextFill(Color.WHITE);
      Label lb5= new Label("Cantidad");lb5.setStyle("-fx-font-weight: bold;");//lb5.setTextFill(Color.WHITE);
      Label lb6 = new Label("Valor");lb6.setStyle("-fx-font-weight: bold;");//lb6.setTextFill(Color.WHITE);
      HBox detalles2 =new HBox(5);
      detalles2.getChildren().addAll(lb4,lb5,lb6);
      
      HBox contenedor = new HBox(150);
      contenedor.getChildren().addAll(detalles,detalles2);
      
      
     

      //Creacion de la caja de Cuentatotal (Dolares)
      VBox cuentatotal = new VBox();
      Text txtsbt = new Text("Subtotal:");txtsbt.setFill(Color.ORANGE);txtsbt.setStyle("-fx-font-weight:bold;-fx-font-size: 18px;-fx-set-text-fill: orange");
      Text txtiva = new Text("IVA:");txtiva.setFill(Color.ORANGE);txtiva.setStyle("-fx-font-weight:bold;-fx-font-size: 18px;-fx-set-text-fill: orange");
      Text txttotal = new Text("Total:");txttotal.setFill(Color.ORANGE);txttotal.setStyle("-fx-font-weight:bold;-fx-font-size: 18px;-fx-set-text-fill: orange");
      cuentatotal.getChildren().addAll(txtsbt,txtiva,txttotal);
      cuentatotal.setAlignment(Pos.CENTER_RIGHT);
      cuentatotal.setPadding(new Insets(0,100,0,0));
      tipoOrden.getChildren().addAll(tipo,orden);
      
      
      
      
      //Botones
      HBox btns = new HBox(10);
      Button continuar = new Button("Continuar");continuar.setStyle("-fx-background-color:orange;-fx-text-fill:black;");
      Button limpiar = new Button("Limpiar");limpiar.setStyle("-fx-background-color:orange;-fx-text-fill:black;");
      btns.getChildren().addAll(continuar,limpiar);
      btns.setAlignment(Pos.CENTER);
      
      
      
      
      
      //Agregacion de todos los objetos al contenedor princial
      arbol.setStyle("-fx-background-color:white");
      arbol.getChildren().addAll(Titulo,tipoOrden,OpcionesPedido,contenedor,cuentatotal,btns);
      arbol.setPadding(new Insets (50,30,30,30));
      escena1 = new Scene(arbol,750,500);
      pedido.setTitle("pedido");
      pedido.setScene(escena1);
      pedido.show();
    }
    
        
    }

