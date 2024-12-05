package com.lojageneradores.api;

import com.lojageneradores.dao.GeneradorDao;
import com.lojageneradores.models.Generador;
import com.lojageneradores.tda.list.LinkedList;

public class GeneradorApi {
    private final GeneradorDao generadorDao;

    public GeneradorApi() {
        generadorDao = new GeneradorDao();
    }

    public LinkedList<Generador> listarGeneradores() {
        return generadorDao.getListAll();
    }

    public boolean guardarGenerador(Generador generador) throws Exception {
        generadorDao.setServicio(generador);
        return generadorDao.save();
    }

    public boolean actualizarGenerador(Generador generador) throws Exception {
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

    public Generador buscarGeneradorPorIdentificacion(String identificacion) {
        return generadorDao.buscarPorIdentificacion(identificacion);
    }
}
