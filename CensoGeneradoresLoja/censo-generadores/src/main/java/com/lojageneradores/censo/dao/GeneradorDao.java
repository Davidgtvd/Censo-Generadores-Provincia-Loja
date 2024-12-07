package com.lojageneradores.censo.dao;

import com.lojageneradores.censo.dao.implement.AdapterDao;
import com.lojageneradores.models.Generador;
import com.lojageneradores.tda.list.LinkedList;

public class GeneradorDao extends AdapterDao<Generador, Integer> {

    private Generador servicio;
    private LinkedList<Generador> listAll;

    public GeneradorDao() {
        super(Generador.class);
        listAll = new LinkedList<>();
    }

    public LinkedList<Generador> listar() {
        return listAll;
    }

    public Generador getServicio() {
        synchronized (this) {
            if (servicio == null) {
                servicio = new Generador("defaultName", 0);
                servicio.setId(listAll.size() + 1);
            }
            return servicio;
        }
    }

    public void setServicio(Generador servicio) {
        this.servicio = servicio;
    }

    public LinkedList<Generador> getListAll() {
        return listAll;
    }

    @Override
    public boolean guardar(Generador generador) {
        if (generador == null) {
            throw new IllegalArgumentException("Generador no puede ser nulo");
        }

        if (generador.getId() == null) {
            generador.setId(generarNuevoId());
        } else if (buscar(generador.getId()) != null) {
            throw new IllegalArgumentException("Ya existe un generador con este ID");
        }

        listAll.add(generador);
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
            Generador existente = buscar(servicio.getId());
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

    public Generador buscar(Integer id) {
        if (id == null) {
            return null;
        }

        for (Generador generador : listAll.toArray()) {
            if (generador.getId().equals(id)) {
                return generador;
            }
        }
        return null;
    }

    public LinkedList<Generador> buscarPorNombre(String nombre) {
        LinkedList<Generador> result = new LinkedList<>();
        for (Generador generador : listAll.toArray()) {
            if (generador.getNombre().equalsIgnoreCase(nombre)) {
                result.add(generador);
            }
        }
        return result;
    }
}
