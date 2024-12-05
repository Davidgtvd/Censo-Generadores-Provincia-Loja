package com.lojageneradores.dao;

import com.lojageneradores.dao.implement.AdapterDao;
import com.lojageneradores.models.Casa;
import com.lojageneradores.tda.list.LinkedList;

public class CasaDao extends AdapterDao<Casa, Integer> {
    private Casa servicio;
    private LinkedList<Casa> listAll;

    public CasaDao() {
        super(Casa.class);
    }

    public Casa getServicio() {
        if (servicio == null) {
            servicio = new Casa();
        }
        return servicio;
    }

    public void setServicio(Casa servicio) {
        this.servicio = servicio;
    }

    public LinkedList<Casa> getListAll() {
        if (listAll == null) {
            listAll = listar();
        }
        return listAll;
    }

    public boolean save() throws Exception {
        if (servicio != null) {
            servicio.setId(getListAll().size() + 1);
            guardar(servicio);
            listAll = listar();
            return true;
        }
        return false;
    }

    public boolean update() throws Exception {
        if (servicio != null && servicio.getId() != null) {
            eliminar(servicio.getId());
            guardar(servicio);
            listAll = listar();
            return true;
        }
        return false;
    }
}
