/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aplicacion;

import disenio_y_funciones.ventanaPedido;
import disenio_y_funciones.ventanaPrincipal;
import disenio_y_funciones.ventanaPago;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 *
 * @author Dustin Pisco
 */
public class Principal extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage salida) throws Exception {
        ventanaPago sal = new ventanaPago(salida);
        //sal.getScene().getStylesheets().add(ventanaPrincipal.class.getResource("ventanaPrincipal.css").toExternalForm());
        salida.setScene(sal.getScene());
        salida.setTitle("Pagina de Inicio");
        
        salida.show();
    }

}
