package com.loja.censogeneradores.model;

import com.loja.censogeneradores.enumerator.TipoEquipo;

public class Generador {

    private String idGenerador;        // ID único del generador
    private TipoEquipo tipoEquipo;     // Tipo de generador (eléctrico, eólico, solar, etc.)
    private String descripcion;        // Descripción o características del generador

    // Constructor
    public Generador(String idGenerador, TipoEquipo tipoEquipo, String descripcion) {
        this.idGenerador = idGenerador;
        this.tipoEquipo = tipoEquipo;
        this.descripcion = descripcion;
    }

    // Getters y Setters
    public String getIdGenerador() {
        return idGenerador;
    }

    public void setIdGenerador(String idGenerador) {
        this.idGenerador = idGenerador;
    }

    public TipoEquipo getTipoEquipo() {
        return tipoEquipo;
    }

    public void setTipoEquipo(TipoEquipo tipoEquipo) {
        this.tipoEquipo = tipoEquipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Generador [ID: " + idGenerador + ", Tipo: " + tipoEquipo.getNombre() + ", Descripción: " + descripcion + "]";
    }
}
