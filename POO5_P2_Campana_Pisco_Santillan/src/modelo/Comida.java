/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 *
 * @author Lenovo
 */
public class Comida implements Comparable<Comida>{
    private String descripcion;
    private double precio;
    private char tipo;
    private int cantidad;
    private double valor;
    private DecimalFormat df = new DecimalFormat("####0.00");

    public Comida(String descripcion, double precio, char tipo, int cantidad) {
        this.descripcion = descripcion;
        this.precio = precio;
        this.tipo = tipo;
        this.cantidad = cantidad;
        this.valor = Double.valueOf(df.format(cantidad * precio));
    }

    public Comida(String descripcion, double precio, char tipo) {
        this.descripcion = descripcion;
        this.precio = precio;
        this.tipo = tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public char getTipo() {
        return tipo;
    }

    public void setTipo(char tipo) {
        this.tipo = tipo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
        setValor(cantidad*precio);
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return descripcion;
    }

    @Override
    public int compareTo(Comida o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}