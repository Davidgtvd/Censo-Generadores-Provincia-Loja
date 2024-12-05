package com.lojageneradores.dao;

import com.lojageneradores.dao.implement.AdapterDao;
import com.lojageneradores.models.Generador;
import com.lojageneradores.tda.list.LinkedList;

public class GeneradorDao extends AdapterDao<Generador, Integer> {
    private Generador servicio;
    private LinkedList<Generador> listAll;

    public GeneradorDao() {
        super(Generador.class);
    }

    public Generador getServicio() {
        if (servicio == null) {
            servicio = new Generador();
        }
        return servicio;
    }

    public void setServicio(Generador servicio) {
        this.servicio = servicio;
    }

    public LinkedList<Generador> getListAll() {
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
