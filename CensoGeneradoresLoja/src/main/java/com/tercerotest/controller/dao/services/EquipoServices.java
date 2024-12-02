package com.tercerotest.controller.dao.services;

import java.util.HashMap;

import com.tercerotest.controller.dao.EquipoDao;
import com.tercerotest.controller.tda.list.LinkedList;
import com.tercerotest.models.Equipo;
import com.tercerotest.models.Marca;
import com.tercerotest.models.Persona;
//import com.tercerotest.models.enumerator.TipoIdentificacion;
import com.tercerotest.models.enumerator.TipoEquipo;

public class EquipoServices {
    private EquipoDao obj;
    public Object[] listShowAll() throws Exception {
        if(!obj.getListAll().isEmpty()) {
            Equipo[] lista = (Equipo[]) obj.getListAll().toArray();
            Object[] respuesta = new Object[lista.length];
            for(int i = 0; i < lista.length; i++) {
                Persona p = new PersonaServices().get(lista[i].getId_persona());
                Marca m = new MarcaServices().get(lista[i].getId_marca());
                HashMap mapa = new HashMap<>();
                mapa.put("id", lista[i].getId());
                mapa.put("estado", lista[i].getEstado());
                mapa.put("caracteristica", lista[i].getCaracteristica());
                mapa.put("modelo", lista[i].getModelo());
                mapa.put("tipo", lista[i].getTipo().getName());
                mapa.put("client", p);
                mapa.put("brand", m);
                respuesta[i] = mapa;
            }
            return respuesta;
        }
        return new Object[]{};
    }
    public EquipoServices() {
        obj = new EquipoDao();
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

    public Equipo getEquipo() {
        return obj.getEquipo();
    }

    public void setEquipo(Equipo Equipo) {
        obj.setEquipo(Equipo);
    }
    
    public TipoEquipo getTipoEquipo(String tipo) {
        return obj.getTipoEquipo(tipo);
    }

    public TipoEquipo[] getTiposEquipos() {
        return obj.getTipoEquipos();
    }
    
    public Equipo get(Integer id) throws Exception {
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

/*    public LinkedList<Equipo> buscar_apellidos(String texto) {
        return obj.buscar_apellidos(texto);
    }
    public Equipo buscar_identificacion(String texto) {
        return obj.buscar_identificacion(texto);
    }
    */
}
