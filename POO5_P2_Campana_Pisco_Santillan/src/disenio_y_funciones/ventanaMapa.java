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
import javafx.scene.layout.BackgroundImage;
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
public class ventanaMapa {
    
    private Stage escenario;
    private Scene escena1;
    public ventanaMapa(Stage escenario){
        this.escenario = escenario;

    }
    
    public Scene getScene(){
        VBox root = new VBox();
        root.setStyle("-fx-background-image: url(/Imagenes/mapa2.png);-fx-background-size:750,500;-fx-background-repeat:no-repeat no-repeat;");
        escena1= new Scene(root,750,500);
        return escena1;
    }
    
    
            
}
