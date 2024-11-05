package com.tercerotest.controller.dao.services;

import java.util.HashMap;

import com.tercerotest.controller.dao.OrderDetalleDao;
import com.tercerotest.controller.tda.list.LinkedList;
import com.tercerotest.models.OrderDetalle;
import com.tercerotest.models.Marca;
import com.tercerotest.models.Persona;


public class OrderDetalleServices {
    private OrderDetalleDao obj;
    public LinkedList listAll() {
        return obj.getListAll();
    }
    /*public Object[] listShowAll() throws Exception {
        if(!obj.getListAll().isEmpty()) {
            OrderDetalle[] lista = (OrderDetalle[]) obj.getListAll().toArray();
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
    public OrderDetalleServices() {
        obj = new OrderDetalleDao();
    }
    public Boolean save() throws Exception {
        return obj.save();
    }

    public Boolean update() throws Exception {
        return obj.update();
    }

   
    public OrderDetalle getOrderDetalle() {
        return obj.getOrderDetalle();
    }

    public void setOrderDetalle(OrderDetalle OrderDetalle) {
        obj.setOrderDetalle(OrderDetalle);
    }
    
   
    
    public OrderDetalle get(Integer id) throws Exception {
        return obj.get(id);
    }
/* 
    public LinkedList OrderDetalle(Integer type_OrderDetalle, String atributo) {
        return obj.OrderDetalle(type_OrderDetalle, atributo);
    }
*/
    public LinkedList OrderDetalle_object(Integer type, String atributo) throws Exception {
        return obj.listAll().order(atributo, type);
    }

/*    public LinkedList<OrderDetalle> buscar_apellidos(String texto) {
        return obj.buscar_apellidos(texto);
    }
    public OrderDetalle buscar_identificacion(String texto) {
        return obj.buscar_identificacion(texto);
    }
    */
}
