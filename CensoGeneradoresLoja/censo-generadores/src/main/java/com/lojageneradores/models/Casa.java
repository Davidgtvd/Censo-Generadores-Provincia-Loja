package com.loja.censogeneradores.model;

import com.loja.censogeneradores.enumerator.TipoIdentificacion;
import com.loja.censogeneradores.enumerator.TipoEquipo;
import com.loja.censogeneradores.tda.list.LinkedList;

public class Casa {

    private String idCasa;                // ID único de la casa
    private String direccion;              // Dirección de la casa
    private TipoIdentificacion tipoId;    // Tipo de identificación del propietario
    private String identificacion;        // Número de identificación del propietario
    private LinkedList<Generador> generadores;  // Lista de generadores en la casa

    // Constructor
    public Casa(String idCasa, String direccion, TipoIdentificacion tipoId, String identificacion) {
        this.idCasa = idCasa;
        this.direccion = direccion;
        this.tipoId = tipoId;
        this.identificacion = identificacion;
        this.generadores = new LinkedList<>();  // Lista vacía de generadores al crear la casa
    }

    // Getters y Setters
    public String getIdCasa() {
        return idCasa;
    }

    public void setIdCasa(String idCasa) {
        this.idCasa = idCasa;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public TipoIdentificacion getTipoId() {
        return tipoId;
    }

    public void setTipoId(TipoIdentificacion tipoId) {
        this.tipoId = tipoId;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public LinkedList<Generador> getGeneradores() {
        return generadores;
    }

    public void setGeneradores(LinkedList<Generador> generadores) {
        this.generadores = generadores;
    }

    // Método para añadir un generador a la casa
    public void addGenerador(Generador generador) {
        this.generadores.add(generador);
    }

    // Método para obtener la cantidad de generadores en la casa
    public int getCantidadGeneradores() {
        return generadores.size();
    }

    @Override
    public String toString() {
        return "Casa [ID: " + idCasa + ", Dirección: " + direccion + ", Identificación: " + identificacion + ", Generadores: " + generadores.size() + "]";
    }
}
