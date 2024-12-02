package com.tercerotest.models;

import com.tercerotest.models.enumerator.TipoEquipo;

public class Equipo {
    private Integer id;
    private String caracteristica;
    private String modelo;
    private Boolean estado;
    private TipoEquipo tipo;
    private Integer id_marca;
    private Integer id_persona;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCaracteristica() {
        return this.caracteristica;
    }

    public void setCaracteristica(String caracteristica) {
        this.caracteristica = caracteristica;
    }

    public String getModelo() {
        return this.modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Boolean getEstado() {
        return this.estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public TipoEquipo getTipo() {
        return this.tipo;
    }

    public void setTipo(TipoEquipo tipo) {
        this.tipo = tipo;
    }

    public Integer getId_marca() {
        return this.id_marca;
    }

    public void setId_marca(Integer id_marca) {
        this.id_marca = id_marca;
    }

    public Integer getId_persona() {
        return this.id_persona;
    }

    public void setId_persona(Integer id_persona) {
        this.id_persona = id_persona;
    }
      
}
