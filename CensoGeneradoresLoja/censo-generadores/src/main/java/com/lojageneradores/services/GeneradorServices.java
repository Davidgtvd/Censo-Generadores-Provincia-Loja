package com.lojageneradores.services;

import com.lojageneradores.api.GeneradorApi;
import com.lojageneradores.models.Generador;
import com.lojageneradores.tda.list.LinkedList;

public class GeneradorServices {
    private final GeneradorApi generadorApi;

    public GeneradorServices() {
        this.generadorApi = new GeneradorApi();
    }

    public LinkedList<Generador> listarGeneradores() {
        return generadorApi.listarGeneradores();
    }

    public boolean guardarGenerador(Generador generador) throws Exception {
        return generadorApi.guardarGenerador(generador);
    }

    public boolean actualizarGenerador(Generador generador) throws Exception {
        return generadorApi.actualizarGenerador(generador);
    }

    public boolean eliminarGenerador(Integer id) {
        return generadorApi.eliminarGenerador(id);
    }

    public Generador buscarGeneradorPorId(Integer id) {
        return generadorApi.buscarGeneradorPorId(id);
    }

    public LinkedList<Generador> buscarGeneradoresPorNombre(String nombre) {
        return generadorApi.buscarGeneradoresPorNombre(nombre);
    }

    public Generador buscarGeneradorPorIdentificacion(String identificacion) {
        return generadorApi.buscarGeneradorPorIdentificacion(identificacion);
    }
}
