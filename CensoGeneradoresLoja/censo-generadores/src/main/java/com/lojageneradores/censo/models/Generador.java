package com.lojageneradores.models;

public class Generador {
    private Integer id;
    private String nombre;
    private String identificacion;
    private Integer capacidad;

    public Generador() {}

    public Generador(Integer id, String nombre, String identificacion, Integer capacidad) {
        this.id = id;
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.capacidad = capacidad;
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

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public Integer getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }

    @Override
    public String toString() {
        return "Generador{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", identificacion='" + identificacion + '\'' +
                ", capacidad=" + capacidad +
                '}';
    }
}
