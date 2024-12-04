package com.example.rest.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Censo {
    @JsonProperty("direccion")
    private String direccion;

    @JsonProperty("num_generadores")
    private int numGeneradores;

    public Censo() {
    }

    public Censo(String direccion, int numGeneradores) {
        this.direccion = direccion;
        this.numGeneradores = numGeneradores;
    }

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
        return "Censo{" +
                "direccion='" + direccion + '\'' +
                ", numGeneradores=" + numGeneradores +
                '}';
    }
}
