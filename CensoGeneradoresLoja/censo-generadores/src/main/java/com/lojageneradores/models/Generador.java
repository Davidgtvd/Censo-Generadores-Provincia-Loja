package com.lojageneradores.censo.models;

public class Generador implements Comparable<Generador> {
    private String nombre;
    private int capacidad;

    public Generador(String nombre, int capacidad) {
        this.nombre = nombre;
        this.capacidad = capacidad;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCapacidad() {
        return capacidad;
    }

    @Override
    public int compareTo(Generador o) {
        return Integer.compare(this.capacidad, o.capacidad);
    }

    @Override
    public String toString() {
        return nombre + " (Capacidad: " + capacidad + ")";
    }
}
