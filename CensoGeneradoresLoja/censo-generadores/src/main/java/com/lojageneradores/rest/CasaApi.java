package com.lojageneradores.api;

import com.lojageneradores.dao.CasaDao;
import com.lojageneradores.models.Casa;
import com.lojageneradores.tda.list.LinkedList;

public class CasaApi {
    private final CasaDao casaDao;

    public CasaApi() {
        casaDao = new CasaDao();
    }

    public LinkedList<Casa> listarCasas() {
        return casaDao.getListAll();
    }

    public boolean guardarCasa(Casa casa) throws Exception {
        casaDao.setServicio(casa);
        return casaDao.save();
    }

    public boolean actualizarCasa(Casa casa) throws Exception {
        casaDao.setServicio(casa);
        return casaDao.update();
    }

    public boolean eliminarCasa(Integer id) {
        return casaDao.eliminar(id);
    }

    public Casa buscarCasaPorId(Integer id) {
        return casaDao.buscar(id);
    }
}
