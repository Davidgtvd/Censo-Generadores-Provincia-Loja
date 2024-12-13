package com.lojageneradores.models;

import java.util.Objects;

public class Generador implements Comparable<Generador> {

    private Integer id;
    private String nombre;
    private int capacidad;
    private String identificacion;

    public Generador() {
        this("", 0, null);
    }

    public Generador(String nombre, int capacidad) {
        this(nombre, capacidad, null);
    }

    public Generador(String nombre, int capacidad, String identificacion) {
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.identificacion = identificacion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    @Override
    public String toString() {
        return "Generador{"
                + "id=" + id
                + ", nombre='" + nombre + '\''
                + ", capacidad=" + capacidad
                + ", identificacion='" + identificacion + '\''
                + '}';
    }

    @Override
    public int compareTo(Generador otro) {
        return Integer.compare(this.capacidad, otro.capacidad);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Generador generador = (Generador) o;
        return capacidad == generador.capacidad
                && Objects.equals(id, generador.id)
                && Objects.equals(nombre, generador.nombre)
                && Objects.equals(identificacion, generador.identificacion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, capacidad, identificacion);
    }
}
