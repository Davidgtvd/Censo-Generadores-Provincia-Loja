package com.tercerotest.controller.dao.services;

import com.tercerotest.controller.dao.MarcaDao;
import com.tercerotest.controller.tda.list.LinkedList;
import com.tercerotest.models.Marca;
import com.tercerotest.models.enumerator.TipoIdentificacion;

public class MarcaServices {
    private MarcaDao obj;
    public MarcaServices() {
        obj = new MarcaDao();
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

    public Marca getMarca() {
        return obj.getMarca();
    }

    public void setMarca(Marca Marca) {
        obj.setMarca(Marca);
    }
    /* 
    public TipoIdentificacion getTipoIdentificacion(String tipo) {
        return obj.getTipoIdentificacion(tipo);
    }

    public TipoIdentificacion[] getTipos() {
        return obj.getTipos();
    }
    */
    public Marca get(Integer id) throws Exception {
        return obj.get(id);
    }
/* 
    public LinkedList order(Integer type_order, String atributo) {
        return obj.order(type_order, atributo);
    }
*/
    public LinkedList order_object(Integer type, String atributo) throws Exception {
        return obj.listAll().order(atributo, type);
    }

/*    public LinkedList<Marca> buscar_apellidos(String texto) {
        return obj.buscar_apellidos(texto);
    }
    public Marca buscar_identificacion(String texto) {
        return obj.buscar_identificacion(texto);
    }
    */
}
