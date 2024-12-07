package com.lojageneradores.censo.dao;

import com.lojageneradores.censo.dao.implement.AdapterDao;
import com.lojageneradores.models.Casa;
import com.lojageneradores.tda.list.LinkedList;

public class CasaDao extends AdapterDao<Casa, Integer> {

    private Casa servicio;
    private final LinkedList<Casa> listAll;

    public CasaDao() {
        super(Casa.class);
        listAll = new LinkedList<>();
    }

    @Override
    public LinkedList<Casa> listar() {
        return listAll;
    }

    public Casa getServicio() {
        synchronized (this) {
            if (servicio == null) {
                servicio = new Casa(null, "");
                servicio.setId(generarNuevoId());
            }
            return servicio;
        }
    }

    public void setServicio(Casa servicio) {
        this.servicio = servicio;
    }

    @Override
    public boolean guardar(Casa casa) {
        if (casa == null) {
            throw new IllegalArgumentException("Casa no puede ser nulo");
        }

        // Validate unique ID
        if (casa.getId() == null) {
            casa.setId(generarNuevoId());
        } else if (buscar(casa.getId()) != null) {
            throw new IllegalArgumentException("Ya existe una casa con este ID");
        }

        listAll.add(casa);
        return true;
    }

    private Integer generarNuevoId() {
        return listAll.isEmpty() ? 1 : listAll.size() + 1;
    }

    public boolean save() {
        if (servicio != null) {
            try {
                guardar(servicio);
                return true;
            } catch (IllegalArgumentException e) {
                return false;
            }
        }
        return false;
    }

    public boolean update() {
        if (servicio != null && servicio.getId() != null) {
            Casa existente = buscar(servicio.getId());
            if (existente != null) {
                for (int i = 0; i < listAll.size(); i++) {
                    if (listAll.get(i).getId().equals(existente.getId())) {
                        listAll.update(servicio, i);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean eliminar(Integer id) {
        if (id == null) {
            return false;
        }

        for (int i = 0; i < listAll.size(); i++) {
            if (listAll.get(i).getId().equals(id)) {
                listAll.remove(i);
                return true;
            }
        }
        return false;
    }

    public Casa buscar(Integer id) {
        if (id == null) {
            return null;
        }

        for (Casa casa : listAll.toArray()) {
            if (casa.getId().equals(id)) {
                return casa;
            }
        }
        return null;
    }

    // Método adicional para buscar por nombre
    public LinkedList<Casa> buscarPorNombre(String nombre) {
        LinkedList<Casa> resultado = new LinkedList<>();
        for (Casa casa : listAll.toArray()) {
            if (casa.getNombre().equalsIgnoreCase(nombre)) {
                resultado.add(casa);
            }
        }
        return resultado;
    }
}
