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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
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
public class ventanaPedido {
    private Stage escenario;
    private Scene escena1;
    public ventanaPedido(Stage escenario){
        this.escenario = escenario;

    }
    public Scene getScene() throws Exception{
      VBox arbol=new VBox(20);
      HBox tipoOrden = new HBox(150);
      tipoOrden.setAlignment(Pos.CENTER);
      GridPane tablaOpciones = new GridPane();
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
      tipo.getChildren().addAll(lbtipo,optipo);
      //Creacion de la caja de Ordenar por
      HBox orden = new HBox(10);
      Label lborden = new Label("Ordenar por:"); lborden.setStyle("-fx-font-weight: bold;");
      ComboBox oporden = new ComboBox();
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
      HBox contenedor = new HBox(100);
      Label descripcion = new Label("Descripcion");descripcion.setStyle("-fx-font-weight: bold;");descripcion.setPadding(new Insets(10,10,10,10));
      Label  precio = new Label("Precio");precio.setStyle("-fx-font-weight: bold;");precio.setPadding(new Insets(10,10,10,10));
      Label  cantidad = new Label("Cantidad");cantidad.setStyle("-fx-font-weight: bold;");cantidad.setPadding(new Insets(10,10,10,10));
      Label espaciado = new Label("        ");espaciado.setPadding(new Insets(10,10,10,10));
      tablaOpciones.add(descripcion, 0, 0);
      tablaOpciones.add(precio, 1, 0);
      tablaOpciones.add(cantidad, 2, 0);
      GridPane totalpedido = new GridPane(); totalpedido.setStyle("-fx-background-color:gray ;-fx-grid-lines-visible: true");
      Label lb1 = new Label("Descripcion");lb1.setStyle("-fx-font-weight: bold;");lb1.setPadding(new Insets(5,10,10,10));lb1.setTextFill(Color.WHITE);
      Label lb2 = new Label("Cantidad");lb2.setStyle("-fx-font-weight: bold;");lb2.setPadding(new Insets(5,20,10,20));lb2.setTextFill(Color.WHITE);
      Label lb3 = new Label("Valor");lb3.setStyle("-fx-font-weight: bold;");lb3.setPadding(new Insets(5,30,10,30));lb3.setTextFill(Color.WHITE);
      totalpedido.add(lb1, 0, 0);
      totalpedido.add(lb2, 1, 0);
      totalpedido.add(lb3, 2, 0);
      contenedor.getChildren().addAll(tablaOpciones, totalpedido);

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
      return escena1;
    }
}
