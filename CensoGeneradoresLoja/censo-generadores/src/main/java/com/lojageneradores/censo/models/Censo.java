package com.lojageneradores.censo.models;

/**
 * Modelo que representa el Censo de Generadores en una casa.
 */
public class Censo {
    private String direccion;      // Dirección de la casa
    private int numGeneradores;   // Número de generadores en la casa

    // Constructor
    public Censo(String direccion, int numGeneradores) {
        this.direccion = direccion;
        this.numGeneradores = numGeneradores;
    }

    // Getters y Setters
    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getNumGeneradores() {
        return numGeneradores;
    }

    public void setNumGeneradores(int numGeneradores) {
        this.numGeneradores = numGeneradores;
    }

    @Override
    public String toString() {
        return "Censo [direccion=" + direccion + ", numGeneradores=" + numGeneradores + "]";
    }
}
