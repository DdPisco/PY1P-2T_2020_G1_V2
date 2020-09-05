/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aplicacion;

import disenio_y_funciones.ventanaGracias;
import disenio_y_funciones.ventanaMapa;
import disenio_y_funciones.ventanaPedido;
import disenio_y_funciones.ventanaPrincipal;
import disenio_y_funciones.ventanaPago;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import javafx.stage.StageStyle;
import modelo.cliente;

/**
 *
 * @author Dustin Pisco
 */
public class Principal extends Application {
    Stage window;
    public static void main(String[] args) {
        launch(args);
    ArrayList<cliente> cl = new ArrayList<>();
    cl.add(new cliente("vduarte","veronica1","Veronica","Samanes4, mz12, villa4"));
    cl.add(new cliente("cluzardo","CristinaL","Bianca","Ceibos, mz5, villa1"));
    cl.add(new cliente("dZambrano","Damian96","Damian","Portete y la 29"));
    cl.add(new cliente("jbriones","Juan23","Juan","Suburbio, calle 28 y la h"));
        System.out.println(cl);
    }

    @Override
    public void start(Stage salida) {
        window=salida;
        salida.setTitle("The Good Burger Restaurant APP");
        ventanaPrincipal sal = new ventanaPrincipal(salida);
        salida.getIcons().add(new Image("/Imagenes/icon.jpg"));
        salida.initStyle(StageStyle.DECORATED);
        window.setScene(sal.getScene());
        window.show();
    }

}
