package com.example.actividad1_2;

import java.io.Serializable;

public class Jugador implements Serializable {
    private String nombre;
    private String posicion;
    private String precio;
    private boolean seleccionado;

    public Jugador(String nombre, String posicion, String precio) {
        this.nombre = nombre;
        this.posicion = posicion;
        this.precio = precio;
        this.seleccionado = false;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPosicion() {
        return posicion;
    }

    public String getPrecio() {
        return precio;
    }

    public boolean isSeleccionado() {
        return seleccionado;
    }

    public void setSeleccionado(boolean seleccionado) {
        this.seleccionado = seleccionado;
    }
}
