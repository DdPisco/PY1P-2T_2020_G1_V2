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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import modelo.Comida;
import modelo.cliente;
import modelo.local;
import modelo.pedido;



public class ventanaPedido {

    private VBox root;
    private Label titulo;
    private HBox seccionCombos;
    private HBox seccionBotones;
    private HBox seccionOpcionPedido;
    private VBox seccionValores;
    private VBox opciones;
    private cliente usuario;
    private pedido pedido;
    private ArrayList<Comida> listaComida;
    private TableView tPedido;
    private Button continuar;
    private Button limpiar;
    private Label vSubtotal;
    private Label vIVA;
    private Label vTotal;


    public ventanaPedido(cliente usuario) throws IOException {
        root = new VBox();
        seccionBotones = new HBox();
        seccionCombos = new HBox();
        seccionOpcionPedido = new HBox();
        seccionValores = new VBox();
        //valores = new VBox();
        listaComida= new ArrayList<>();
        opciones = new VBox();
        titulo = new Label("Realice su pedido");
        titulo.setFont(new Font("Arial", 30));
        tPedido = new TableView();
        continuar = new Button("Continuar");
        limpiar = new Button("Limpiar");
        vSubtotal = new Label("0.00");
        vIVA = new Label("0.00");
        vTotal = new Label("0.00");
        this.usuario= usuario;
        cargarComida(Archivos.leerArchivos("src/recursos/menu.txt"));
    }

    public VBox getRoot() {
        crearSeccionCombo();
        crearSeccionValores();
        crearOpcionPedido();
        crearSeccionBotones();
        root.setSpacing(10);
        root.getChildren().addAll(titulo, seccionCombos, seccionOpcionPedido, seccionBotones);
        root.setPadding(new Insets(20, 20, 20, 20));

        return root;
    }

    public void crearSeccionCombo() {
        HBox izquierda = new HBox();
        HBox derecha = new HBox();
        ComboBox cbxTipo = new ComboBox();
        ComboBox cbxOrdenarPor = new ComboBox();
        cbxTipo.getItems().addAll("Platos Fuertes", "Postres", "Bebidas", "Piqueos");

        cbxTipo.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {

                mostrarOpciones(cbxTipo.getValue().toString());
            }
        });

        izquierda.getChildren().addAll(new Label("Tipo:"), cbxTipo);
        derecha.getChildren().addAll(new Label("Ordenar por:"), cbxOrdenarPor);
        izquierda.setAlignment(Pos.CENTER_LEFT);
        derecha.setAlignment(Pos.CENTER_LEFT);
        seccionCombos.getChildren().addAll(izquierda, derecha);
        seccionCombos.setSpacing(300);
        seccionCombos.setAlignment(Pos.CENTER_LEFT);

    }

    public void crearOpcionPedido() {
        //Seccion OPCION
        VBox izquierda = new VBox();
        Label head1 = new Label("Opciones");
        head1.setFont(new Font("Arial", 15));
        HBox campos = new HBox();
        campos.setSpacing(50);
        Label descrip = new Label("Descripcion");
        descrip.setPrefWidth(80);
        Label precio = new Label("Precio");
        precio.setPrefWidth(35);
        precio.setAlignment(Pos.CENTER);
        Label cantidad = new Label("Cantidad");
        cantidad.setPrefWidth(50);
        campos.getChildren().addAll(descrip, precio, cantidad);
        izquierda.setSpacing(10);
        izquierda.getChildren().addAll(head1, campos, opciones);

        //Seccion PEDIDO
        VBox derecha = new VBox();

        Label head2 = new Label("Pedido");
        head2.setFont(new Font("Arial", 15));

        TableColumn descripcion = new TableColumn("Descripcion");
        descripcion.setCellValueFactory(new PropertyValueFactory<>("descripcion"));
        descripcion.setPrefWidth(150);

        TableColumn cant = new TableColumn("Cantidad");
        cant.setCellValueFactory(new PropertyValueFactory<>("cantidad"));
        cant.setPrefWidth(80);

        TableColumn valor = new TableColumn("Valor");
        valor.setCellValueFactory(new PropertyValueFactory<>("valor"));
        valor.setPrefWidth(100);

        tPedido.getColumns().addAll(descripcion, cant, valor);
        tPedido.setPrefWidth(315);

        derecha.setAlignment(Pos.CENTER_RIGHT);
        derecha.getChildren().addAll(tPedido, seccionValores);
        seccionOpcionPedido.setSpacing(100);
        seccionOpcionPedido.getChildren().addAll(izquierda, derecha);
    }

    public void crearSeccionBotones() {

        seccionBotones.setAlignment(Pos.CENTER);
        seccionBotones.setSpacing(25);
        seccionBotones.getChildren().addAll(continuar, limpiar);

        //CONTINUAR
        continuar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                ArrayList<Comida> it = new ArrayList<>();
                double subtotal = 0;
                for (Object o : tPedido.getItems()) {
                    Comida i = (Comida) o;
                    subtotal += i.getValor();
                    it.add(i);
                }
                pedido = new pedido(it, subtotal);
                System.out.println(pedido);
            }
        });

        //LIMPIAR
        limpiar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {

                for (Object o : opciones.getChildren()) {
                    HBox fila = (HBox) o;
                    TextField c = (TextField) fila.getChildren().get(2);
                    c.setText("");
                }
                tPedido.getItems().clear();
                vSubtotal.setText("0.00");
                vTotal.setText("0.00");
                vIVA.setText("0.00");
            }
        });

    }

    public void cargarComida(ArrayList<String> data) {
        for (String d : data) {
            String[] datos = d.split(",");
            listaComida.add(new Comida(datos[0], Double.valueOf(datos[1]), datos[2].charAt(0)));
        }
    }

    public void mostrarOpciones(String tipo) {
        ArrayList<Comida> seleccion = new ArrayList<>();
        opciones.getChildren().clear();
        char cod;
        switch (tipo) {
            case "Platos Fuertes":
                cod = 'F';
                break;
            case "Postres":
                cod = 'P';
                break;
            case "Bebidas":
                cod = 'B';
                break;
            case "Piqueos":
                cod = 'Q';
                break;
            default:
                cod = ' ';
        }
        for (Comida i : listaComida) {
            if (cod == i.getTipo()) {
                seleccion.add(i);
            }
        }
        for (Comida i : seleccion) {
            HBox fila = new HBox();
            fila.setSpacing(50);
            Label descripcion = new Label(i.getDescripcion());
            descripcion.setPrefWidth(80);
            Label precio = new Label(String.valueOf(i.getPrecio()));
            precio.setPrefWidth(35);
            precio.setAlignment(Pos.CENTER);
            TextField cantidad = new TextField();
            cantidad.setPrefWidth(50);
            Button agregar = new Button("Agregar");
            agregar.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent t) {
                    i.setCantidad(Integer.valueOf(cantidad.getText()));
                    tPedido.getItems().add(i);
                    double st = 0;
                    for (Object o : tPedido.getItems()) {
                        Comida i = (Comida) o;
                        st += i.getValor();
                    }
                    vSubtotal.setText(String.valueOf(st));
                    vIVA.setText(String.valueOf(st * 0.12));
                    vTotal.setText(String.valueOf((st * 0.12) + st));
                }
            });
            fila.getChildren().addAll(descripcion, precio, cantidad, agregar);
            opciones.getChildren().add(fila);
            opciones.setSpacing(5);
        }
    }

    public void crearSeccionValores() {
        HBox hbSubtotal = new HBox();
        HBox hbIVA = new HBox();
        HBox hbTotal = new HBox();

        Label lbSubtotal = new Label("Subtotal: ");
        Label lbIVA = new Label("IVA: ");
        Label lbTotal = new Label("Total: ");
        hbSubtotal.getChildren().addAll(lbSubtotal, vSubtotal);
        hbIVA.getChildren().addAll(lbIVA, vIVA);
        hbTotal.getChildren().addAll(lbTotal, vTotal);
        seccionValores.getChildren().addAll(hbSubtotal, hbIVA, hbTotal);

    }

   
} 