package com.lojageneradores.services;

import com.lojageneradores.models.CasaApi;
import com.lojageneradores.models.Casa;
import com.lojageneradores.tda.list.LinkedList;

public class CasaServices {

    private final CasaApi casaApi;

    public CasaServices() {
        this.casaApi = new CasaApi();
    }

    public LinkedList<Casa> listarCasas() {
        return casaApi.listarCasas();
    }

    public boolean guardarCasa(Casa casa) throws Exception {
        return casaApi.guardarCasa(casa);
    }

    public boolean actualizarCasa(Casa casa) throws Exception {
        return casaApi.actualizarCasa(casa);
    }

    public boolean eliminarCasa(Integer id) {
        return casaApi.eliminarCasa(id);
    }

    public Casa buscarCasaPorId(Integer id) {
        return casaApi.buscarCasaPorId(id);
    }
}
