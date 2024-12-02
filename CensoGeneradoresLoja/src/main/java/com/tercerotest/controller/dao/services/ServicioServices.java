package com.tercerotest.controller.dao.services;

import com.tercerotest.controller.dao.GeneradorDao;
import com.tercerotest.controller.tda.list.LinkedList;
import com.tercerotest.models.Servicio;


public class ServicioServices {
    private GeneradorDao obj;
    public LinkedList listAll() {
        return obj.getListAll();
    }
    /*public Object[] listShowAll() throws Exception {
        if(!obj.getListAll().isEmpty()) {
            Servicio[] lista = (Servicio[]) obj.getListAll().toArray();
            Object[] respuesta = new Object[lista.length];
            for(int i = 0; i < lista.length; i++) {
                Persona p = new PersonaServices().get(lista[i].getId_persona());
                
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
    }*/
    public ServicioServices() {
        obj = new GeneradorDao();
    }
    public Boolean save() throws Exception {
        return obj.save();
    }

    public Boolean update() throws Exception {
        return obj.update();
    }

   
    public Servicio getServicio() {
        return obj.getServicio();
    }

    public void setServicio(Servicio Servicio) {
        obj.setServicio(Servicio);
    }
    
   
    
    public Servicio get(Integer id) throws Exception {
        return obj.get(id);
    }
/* 
    public LinkedList Servicio(Integer type_Servicio, String atributo) {
        return obj.Servicio(type_Servicio, atributo);
    }
*/
    public LinkedList Servicio_object(Integer type, String atributo) throws Exception {
        return obj.listAll().order(atributo, type);
    }

/*    public LinkedList<Servicio> buscar_apellidos(String texto) {
        return obj.buscar_apellidos(texto);
    }
    public Servicio buscar_identificacion(String texto) {
        return obj.buscar_identificacion(texto);
    }
    */
}
