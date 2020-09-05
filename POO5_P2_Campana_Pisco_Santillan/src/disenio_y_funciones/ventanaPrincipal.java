/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package disenio_y_funciones;


import java.io.IOException;
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
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import modelo.cliente;

/**
 *
 * @author Lenovo
 */
public class ventanaPrincipal {
    private Stage escenario;
    private Scene escena1;
    private Scene escena2;
    private TextField CajaUsuario;
    private cliente usuario;
    public ventanaPrincipal(Stage escenario){
        this.escenario = escenario;
       
    }
    public Scene getScene(){
        VBox arbol = new VBox(60); //Este es el NodeRoot de la Escena de la ventana de Ingreso
        
        StackPane cajatitulo = new StackPane();
        Text Titulo = new Text("The Good Burger Restaurant");
        Titulo.setStyle( "-fx-font-size: 32px;-fx-font-family:Arial Black;-fx-font-weight: bold;");
        Titulo.setFill(Color.ORANGE);
       
        cajatitulo.getChildren().add(Titulo);
       
      
        
        HBox Usuario = new HBox(20); 
        HBox Contrasenia =new HBox(7);
        CajaUsuario = new TextField();
        Label TxtCajaUsuario = new Label("Usuario: ");
        Usuario.getChildren().addAll(TxtCajaUsuario,CajaUsuario);
        Usuario.setAlignment(Pos.CENTER);
        TextField CajaContrasenia = new TextField();
        Label TxtCajaPswd = new Label("Contraseña: ");
        Contrasenia.getChildren().addAll(TxtCajaPswd,CajaContrasenia);
        Contrasenia.setAlignment(Pos.CENTER);
        VBox datos = new VBox(30);
        datos.getChildren().addAll(Usuario,Contrasenia);
        String datoUsuario = TxtCajaUsuario.getText();
        String datoPswd = TxtCajaPswd.getText();
        cliente uno = new cliente(datoUsuario, datoPswd, null, null);
        
        HBox ultFila =  new HBox(75);
        ultFila.setAlignment(Pos.CENTER);
        ImageView repartidor = new ImageView(new Image("/Imagenes/delivery.png"));
        repartidor.setFitHeight(180);
        repartidor.setFitWidth(200);
        
        ImageView burger = new ImageView(new Image("/Imagenes/burger.png"));
        burger.setFitWidth(140);
        burger.setFitHeight(140);
        Button ingresar = new Button("Ingresar");

        ingresar.setStyle("-fx-background-color:orange;-fx-text-fill:black;-fx-font-weight:bold");
        ultFila.getChildren().addAll(repartidor,ingresar,burger);
        ingresar.setOnAction(e->escenario.setScene(crearEscena2()));
        //ingresar.setOnAction(e->escenario.setScene(escena2));
        
        arbol.setStyle("-fx-background-color:white");
        arbol.getChildren().addAll(cajatitulo,datos,ultFila);
        arbol.setPadding(new Insets(80,50,50,50));
        
        escena1 = new Scene(arbol,750,500);
        return escena1;    
    }
    
    
    
    
    
    
    public Scene crearEscena2(){
        HBox ventanaBi=new HBox(100);

        ventanaBi.setStyle("-fx-background-image: url(/Imagenes/I5.jpg);-fx-background-size: 750px,500px;-fx-background-repeat: no-repeat no-repeat;");
       

        
        VBox bienvenida=new VBox(50);
        
        
        VBox topBi=new VBox(20);
        Text TituloA = new Text("Bienvenid@ "+CajaUsuario.getText());
        TituloA.setStyle( "-fx-font-size: 32px;-fx-font-family:Arial Black;-fx-font-weight: bold;");
        TituloA.setFill(Color.ORANGE);
        Text TituloB = new Text("Elige la opcion que prefieras");
        TituloB.setStyle( "-fx-font-size: 15px;-fx-font-family:Arial Black;-fx-font-weight: bold;");
        TituloB.setFill(Color.WHITE);
        topBi.setAlignment(Pos.CENTER);
        topBi.getChildren().addAll(TituloA,TituloB);
        
        
        VBox inferiorBi=new VBox(20);
        Button encuentra=new Button("Encuentra el local mas cercano");
        encuentra.setStyle("-fx-background-color:orange;-fx-text-fill:black;-fx-font-weight:bold");
        encuentra.setMaxSize(300, 10);
        Button pedido=new Button("Haz tu pedido");
        pedido.setStyle("-fx-background-color:orange;-fx-text-fill:black;-fx-font-weight:bold");
        pedido.setMaxSize(300, 10);
        pedido.setTextAlignment(TextAlignment.CENTER);
        pedido.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent arg0) {
                ;
                ventanaPedido p = null;
                try {
                    p = new ventanaPedido(usuario);
                    escenario.setScene(new Scene(p.getRoot()));
                } catch (IOException ex) {
                    Logger.getLogger(ventanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
               } catch (Exception ex) {                    
            System.out.println("Ha ocurrido  un error");
                    System.out.println(ex);
                }
            }
        });
        inferiorBi.getChildren().addAll(encuentra,pedido);
        bienvenida.getChildren().addAll(topBi,inferiorBi);
        ventanaBi.getChildren().addAll(bienvenida);
        ventanaBi.setPadding(new Insets(20,50,50,50));
        
        //Programacion del boton Encontrar Local 
        encuentra.setOnAction(new EventHandler <ActionEvent>(){
            @Override
            public void handle(ActionEvent t) {
                ventanaMapa m= new ventanaMapa();
                m.mostrarVentanaMapa();
                }
        });

        
        escena2 =new Scene(ventanaBi,750,500);
        return escena2;
    }
}
