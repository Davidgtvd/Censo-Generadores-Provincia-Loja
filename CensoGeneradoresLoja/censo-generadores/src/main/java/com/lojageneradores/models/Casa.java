package com.lojageneradores.models;

public class Casa {
    private Integer id;
    private String direccion;
    private Integer numGeneradores;

    public Casa() {}

    public Casa(Integer id, String direccion, Integer numGeneradores) {
        this.id = id;
        this.direccion = direccion;
        this.numGeneradores = numGeneradores;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Integer getNumGeneradores() {
        return numGeneradores;
    }

    public void setNumGeneradores(Integer numGeneradores) {
        this.numGeneradores = numGeneradores;
    }

    @Override
    public String toString() {
        return "Casa{" +
                "id=" + id +
                ", direccion='" + direccion + '\'' +
                ", numGeneradores=" + numGeneradores +
                '}';
    }
}

