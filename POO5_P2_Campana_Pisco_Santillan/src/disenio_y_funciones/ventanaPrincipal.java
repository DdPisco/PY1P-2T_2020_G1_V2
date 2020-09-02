/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package disenio_y_funciones;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author Lenovo
 */
public class ventanaPrincipal {
    private Stage escenario;
    private Scene escena1;
    public ventanaPrincipal(Stage escenario){
        this.escenario = escenario;
       
    }
    public Scene getScene() throws Exception{
        VBox arbol = new VBox(60); //Este es el NodeRoot de la Escena de la ventana de Ingreso
        
        StackPane cajatitulo = new StackPane();
        Text Titulo = new Text("The Good Burger Restaurant");
        Titulo.setStyle( "-fx-font-size: 32px;-fx-font-family:Arial Black;-fx-font-weight: bold;");
        Titulo.setFill(Color.ORANGE);
       
        cajatitulo.getChildren().add(Titulo);
       
      
        
        HBox Usuario = new HBox(20); 
        HBox Contrasenia =new HBox(7);
        TextField CajaUsuario = new TextField();
        Label TxtCajaUsuario = new Label("Usuario: ");
        Usuario.getChildren().addAll(TxtCajaUsuario,CajaUsuario);
        Usuario.setAlignment(Pos.CENTER);
        TextField CajaContrasenia = new TextField();
        Label TxtCajaPswd = new Label("Contraseña: ");
        Contrasenia.getChildren().addAll(TxtCajaPswd,CajaContrasenia);
        Contrasenia.setAlignment(Pos.CENTER);
        VBox datos = new VBox(30);
        datos.getChildren().addAll(Usuario,Contrasenia);
        
        HBox ultFila =  new HBox(75);
        ultFila.setAlignment(Pos.CENTER);
        ImageView repartidor = new ImageView(new Image("Imagenes/delivery.png"));
        repartidor.setFitHeight(180);
        repartidor.setFitWidth(200);
        
        ImageView burger = new ImageView(new Image("Imagenes/burger.png"));
        burger.setFitWidth(140);
        burger.setFitHeight(140);
        Button ingresar = new Button("Ingresar");
        ingresar.setStyle("-fx-background-color:orange;-fx-text-fill:black;-fx-font-weight:bold");
        ultFila.getChildren().addAll(repartidor,ingresar,burger);
        
        //arbol.setStyle("-fx-background-color:white");
        arbol.getChildren().addAll(cajatitulo,datos,ultFila);
        arbol.setPadding(new Insets(80,50,50,50));
        arbol.setStyle("-fx-background-image:Imagenes/I5.png)");
        /*Esto es lo que debe aparecer luego del ingreso
        
        arbol.
        
        
        */
        
        escena1 = new Scene(arbol,750,500);
        return escena1;    
    }
}
