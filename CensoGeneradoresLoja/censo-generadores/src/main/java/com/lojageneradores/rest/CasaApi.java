package com.lojageneradores.rest;

import com.lojageneradores.censo.dao.CasaDao;
import com.lojageneradores.models.Casa;
import com.lojageneradores.tda.list.LinkedList;

public class CasaApi {

    private final CasaDao casaDao;

    public CasaApi() {
        casaDao = new CasaDao();
    }

    public LinkedList<Casa> listarCasas() {
        return casaDao.listar();
    }

    public boolean guardarCasa(Casa casa) {
        casaDao.setServicio(casa);
        return casaDao.save();
    }

    public boolean actualizarCasa(Casa casa) {
        casaDao.setServicio(casa);
        return casaDao.update();
    }

    public boolean eliminarCasa(Integer id) {
        return casaDao.eliminar(id);
    }

    public Casa buscarCasaPorId(Integer id) {
        return casaDao.buscar(id);
    }

    public LinkedList<Casa> buscarCasasPorNombre(String nombre) {
        return casaDao.buscarPorNombre(nombre);
    }

    public static void main(String[] args) {
        CasaApi casaApi = new CasaApi();

    }
}
