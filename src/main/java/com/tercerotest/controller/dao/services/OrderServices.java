package com.tercerotest.controller.dao.services;

import java.util.HashMap;

import com.tercerotest.controller.dao.OrderDao;
import com.tercerotest.controller.tda.list.LinkedList;
import com.tercerotest.models.Order;
import com.tercerotest.models.Marca;
import com.tercerotest.models.Persona;


public class OrderServices {
    private OrderDao obj;
    public LinkedList listAll() {
        return obj.getListAll();
    }
    /*public Object[] listShowAll() throws Exception {
        if(!obj.getListAll().isEmpty()) {
            Order[] lista = (Order[]) obj.getListAll().toArray();
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
    public OrderServices() {
        obj = new OrderDao();
    }
    public Boolean save() throws Exception {
        return obj.save();
    }

    public Boolean update() throws Exception {
        return obj.update();
    }

   
    public Order getOrder() {
        return obj.getOrder();
    }

    public void setOrder(Order Order) {
        obj.setOrder(Order);
    }
    
   
    
    public Order get(Integer id) throws Exception {
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

/*    public LinkedList<Order> buscar_apellidos(String texto) {
        return obj.buscar_apellidos(texto);
    }
    public Order buscar_identificacion(String texto) {
        return obj.buscar_identificacion(texto);
    }
    */
}
