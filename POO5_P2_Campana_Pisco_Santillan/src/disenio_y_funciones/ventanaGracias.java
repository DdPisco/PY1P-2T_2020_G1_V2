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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
public class ventanaGracias {
    private Stage escenario;
    private Scene escena1;
    public ventanaGracias (Stage escenario){
        this.escenario = escenario;

    }
    public Scene getScene() throws Exception{
        VBox root = new VBox(40);
        Label txtagrad = new Label("¡Muchas gracias!");
        txtagrad.setStyle("-fx-font-size: 36px;-fx-font-family:Arial Black;-fx-font-weight: bolder;-fx-text-fill:orange");
        txtagrad.setAlignment(Pos.CENTER);
        Label txt = new Label("Su pedido Nro /*El numero de orden*/ ha sido pagado y ahora empezamos a prepararlo.\n"
                + "                             En Aproximadamente 30 minutos llegara a su destino.\n"
                + "                                              Gracias por preferirnos.");
        txt.setStyle("-fx-font-size: 12px;-fx-font-family:Arial Black;-fx-font-weight: bold");
        txt.setAlignment(Pos.BASELINE_LEFT);
        ImageView rept = new ImageView(new Image("Imagenes/repartidor.gif"));
        rept.setFitHeight(200);
        rept.setFitWidth(235);
        Label cierre = new Label("Cerrando en tiempo...");
        cierre.setAlignment(Pos.BASELINE_RIGHT);
        
        
        root.setStyle("-fx-background-color:white");
        root.getChildren().addAll(txtagrad,txt,rept,cierre);root.setAlignment(Pos.TOP_CENTER);
        root.setPadding(new Insets(40,30,20,30));
        escena1 = new Scene(root,750,500)  ;
    return escena1;
    }
}
