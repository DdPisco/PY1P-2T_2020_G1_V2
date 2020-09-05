
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Random;
import javafx.scene.control.TextField;
/**
 *
 * @author Lenovo
 */
public class pedido {
    private String id;
    private ArrayList<Comida> listaComida;
    private String direccion;
    private double subtotal;
    private double iva;
    

    public pedido(ArrayList<Comida> listaComida, double subtotal) {
        generarId();
        iva = subtotal * 0.12;
        this.listaComida = listaComida;
        this.subtotal = subtotal;
    }

    public pedido(ArrayList<Comida> listaComida, double subtotal, String direccion) {
        generarId();
        iva = subtotal * 0.12;
        this.listaComida = listaComida;
        this.direccion = direccion;
        this.subtotal = subtotal;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ArrayList<Comida> getListaComida() {
        return listaComida;
    }

    public void setListaComida(ArrayList<Comida> listaComida) {
        this.listaComida = listaComida;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public void generarId() {
        Random r = new Random();
        int high = 40000;
        int low = 1000;
        setId(String.valueOf(r.nextInt(high - low) + low));
    }

    public double getIva() {
        return iva;
    }

    public void setIva(double iva) {
        this.iva=iva;
    }

    @Override
    public String toString() {
        return "Pedido{" + "id=" + id + ", listaItems=" + listaComida + ", direccion=" + direccion + ", subtotal=" + subtotal + ", iva=" + iva + '}';
    }


}
    