package com.lojageneradores.models;

import java.util.Objects;

public class Casa implements Comparable<Casa> {

    private Integer id;
    private String nombre;

    public Casa(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
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

    @Override
    public String toString() {
        return "Casa{id=" + id + ", nombre='" + nombre + "'}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Casa casa = (Casa) o;
        return Objects.equals(id, casa.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public int compareTo(Casa other) {

        if (this.id == null && other.id == null) {
            return this.nombre.compareTo(other.nombre);
        }
        if (this.id == null) {
            return -1;
        }
        if (other.id == null) {
            return 1;
        }
        return this.id.compareTo(other.id);
    }
}
