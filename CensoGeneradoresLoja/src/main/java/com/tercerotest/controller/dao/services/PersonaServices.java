package com.tercerotest.controller.dao.services;

import com.tercerotest.controller.dao.CasaDao;
import com.tercerotest.controller.tda.list.LinkedList;
import com.tercerotest.models.Persona;
import com.tercerotest.models.enumerator.TipoIdentificacion;

public class PersonaServices {
    private CasaDao obj;
    public PersonaServices() {
        obj = new CasaDao();
    }
    public Boolean save() throws Exception {
        return obj.save();
    }

    public Boolean update() throws Exception {
        return obj.update();
    }

    public LinkedList listAll() {
        return obj.getListAll();
    }

    public Persona getPersona() {
        return obj.getPersona();
    }

    public void setPersona(Persona persona) {
        obj.setPersona(persona);
    }

    public TipoIdentificacion getTipoIdentificacion(String tipo) {
        return obj.getTipoIdentificacion(tipo);
    }

    public TipoIdentificacion[] getTipos() {
        return obj.getTipos();
    }

    public Persona get(Integer id) throws Exception {
        return obj.get(id);
    }

    public LinkedList order(Integer type_order, String atributo) {
        return obj.order(type_order, atributo);
    }

    public LinkedList order_object(Integer type, String atributo) throws Exception {
        return obj.listAll().order(atributo, type);
    }

    public LinkedList<Persona> buscar_apellidos(String texto) {
        return obj.buscar_apellidos(texto);
    }
    public Persona buscar_identificacion(String texto) {
        return obj.buscar_identificacion(texto);
    }
}
