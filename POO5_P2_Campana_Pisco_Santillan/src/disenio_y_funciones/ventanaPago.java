

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package disenio_y_funciones;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
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
public class ventanaPago {
    private Stage escenario;
    private Scene escena1;
     private GridPane cajaTC; 
    public ventanaPago(){
        //this.escenario = escenario;
    }
    

    

    public void getScene(double total){

        VBox contenedor = new VBox(20);//contenedor principal 
        Label Titulo = new Label("Direccion de Entrega");
        Titulo.setStyle("-fx-font-size: 28px;-fx-font-family:Arial Black;-fx-font-weight: bold;");Titulo.setTextFill(Color.ORANGE);
        
        HBox cajadirec= new HBox(10); //contenedor de subtitulo1 y direccion
        Label direc = new Label("Direccion: ");
        TextField indirec = new TextField("Ingrese su direccion...");indirec.setMaxWidth(1000);
        cajadirec.getChildren().addAll(direc,indirec);cajadirec.setPadding(new Insets(0,0,0,25));
       // String direcccion = indirec.getText();
        
        
        VBox cajadetpago= new VBox(10);
        Label detpago = new Label("Detalle de pago");
        detpago.setStyle("-fx-font-size: 28px;-fx-font-family:Arial Black;-fx-font-weight: bold;");detpago.setTextFill(Color.ORANGE);
        
        ToggleGroup oppago = new ToggleGroup();
        RadioButton ef = new RadioButton("Efectivo");
        
        Label l = new Label();
        ef.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>(){
            public void handle(ActionEvent arg0){
               cajaTC.getChildren().clear();
                l.setText("Tendra que pagar un total de " );
                cajaTC.add(l, 1, 1);
                // se relaciona con pedido
                // pagoEfectivo pge = new pagoEfectivo();
                //l.setText("Tendra que pagar un total de "+totalPagar);
            
            }   
        });
        
        
        
        RadioButton tc = new RadioButton("Tarjeta de Credito");
        cajaTC = new GridPane(); 
        cajaTC.setHgap(10);
       tc.setOnAction(new EventHandler<ActionEvent>(){
 
            @Override
            public void handle(ActionEvent t) {
                cajaTC.getChildren().clear();
                 
        TextField t1 = new TextField();
        TextField t2 = new TextField();
        TextField t3 = new TextField();
        TextField t4 = new TextField();
        cajaTC.add(new Label("Titular:"),0,0);
        cajaTC.add(t1,1,0);
        cajaTC.add(new Label("Numero:"),0,1);
        cajaTC.add(t2,1,1);
        cajaTC.add(new Label("Caducidad:"),0,2);
        cajaTC.add(t3,1,2);
        cajaTC.add(new Label("CVV:"),0,3);
        cajaTC.add(t4,1,3);
            }
        });
        total= (total*0.05)+total;
        l.setText("Tendra que pagar un total de "+total);
       
        ef.setToggleGroup(oppago);
        tc.setToggleGroup(oppago);
        HBox tg = new HBox(10);
        tg.getChildren().addAll(ef,tc);
        cajadetpago.getChildren().addAll(detpago,tg);
        
  
        
        //Botones   
        HBox btns = new HBox(10);
        Button continuar = new Button("Continuar");continuar.setStyle("-fx-background-color:orange;-fx-text-fill:black;");
        Button limpiar = new Button("Limpiar");limpiar.setStyle("-fx-background-color:orange;-fx-text-fill:black;");
        btns.getChildren().addAll(continuar,limpiar);
        btns.setAlignment(Pos.CENTER);
        
        contenedor.getChildren().addAll(Titulo,cajadirec,cajadetpago,btns,cajaTC);
        contenedor.setStyle("-fx-background-color: white");
        contenedor.setPadding(new Insets(40,60,15,15));
        escena1 = new Scene(contenedor,750,500);
        Stage pago=new Stage();
            pago.setTitle("pago");
            pago.setScene(escena1);
            pago.show();
       
    }
}
