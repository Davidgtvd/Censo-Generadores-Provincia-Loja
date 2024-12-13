package com.lojageneradores.rest;

import com.lojageneradores.censo.dao.GeneradorDao;
import com.lojageneradores.models.Generador;
import com.lojageneradores.tda.list.LinkedList;

public class GeneradorApi {

    private final GeneradorDao generadorDao;

    public GeneradorApi() {
        generadorDao = new GeneradorDao();
    }

    public LinkedList<Generador> listarGeneradores() {
        return generadorDao.listar();
    }

    public boolean guardarGenerador(Generador generador) {
        generadorDao.setServicio(generador);
        return generadorDao.save();
    }

    public boolean actualizarGenerador(Generador generador) {
        generadorDao.setServicio(generador);
        return generadorDao.update();
    }

    public boolean eliminarGenerador(Integer id) {
        return generadorDao.eliminar(id);
    }

    public Generador buscarGeneradorPorId(Integer id) {
        return generadorDao.buscar(id);
    }

    public LinkedList<Generador> buscarGeneradoresPorNombre(String nombre) {
        return generadorDao.buscarPorNombre(nombre);
    }

    public Generador buscarGeneradorPorIdentificacion(String nombre) {
        for (Generador generador : generadorDao.listar()) {
            if (generador.getNombre() != null
                    && generador.getNombre().equalsIgnoreCase(nombre)) {
                return generador;
            }
        }
        return null;
    }

    public java.util.LinkedList<Generador> listarGeneradoresComoJavaList() {
        LinkedList<Generador> listaPersonalizada = generadorDao.listar();
        java.util.LinkedList<Generador> listaJava = new java.util.LinkedList<>();

        for (Generador generador : listaPersonalizada) {
            listaJava.add(generador);
        }

        return listaJava;
    }
}
