package com.tercerotest.controller.dao;

import java.util.function.ToIntBiFunction;

import com.tercerotest.controller.dao.implement.AdapterDao;
import com.tercerotest.controller.tda.list.LinkedList;
import com.tercerotest.models.Order;

public class OrderDao extends AdapterDao<Order> {
    private Order Order;
    private LinkedList listAll;

    public OrderDao() {
        super(Order.class);
    }

    public Order getOrder() {
        if (Order == null) {
            Order = new Order();
        }
        return this.Order;
    }

    public void setOrder(Order Order) {
        this.Order = Order;
    }

    public LinkedList getListAll() {
        if (listAll == null) {
            this.listAll = listAll();
        }
        return listAll;
    }

    public Boolean save() throws Exception {
        Integer id = getListAll().getSize() + 1;
        Order.setId(id);
        this.persist(this.Order);
        this.listAll = listAll();
        return true;
    }

    public Boolean update() throws Exception {

        this.merge(getOrder(), getOrder().getId() - 1);
        this.listAll = listAll();
        return true;
    }
    
   /* public TipoIdentificacion getTipoIdentificacion(String tipo) {
        return TipoIdentificacion.valueOf(tipo);
    }

    public TipoIdentificacion[] getTipos() {
        return TipoIdentificacion.values();
    }

    public LinkedList order(Integer type_order, String atributo) {
        LinkedList listita = listAll();
        if (!listAll().isEmpty()) {
            Order[] lista = (Order[]) listita.toArray();
            listita.reset();
            for (int i = 1; i < lista.length; i++) {
                Order aux = lista[i]; // valor a ordenar
                int j = i - 1; // índice anterior
                while (j >= 0 && (verify(lista[j], aux, type_order, atributo))) {
                    lista[j + 1] = lista[j--]; // desplaza elementos hacia la derecha
                }
                lista[j + 1] = aux; // inserta el valor en su posición correcta
            }

            listita.toList(lista);
        }
        return listita;
    }

    private Boolean verify(Order a, Order b, Integer type_order, String atributo) {
        if (type_order == 1) {
            if (atributo.equalsIgnoreCase("apellidos")) {
                return a.getApellidos().compareTo(b.getApellidos()) > 0;
            } else if (atributo.equalsIgnoreCase("nombres")) {
                return a.getNombres().compareTo(b.getNombres()) > 0;
            } else if (atributo.equalsIgnoreCase("id")) {
                return a.getId() > b.getId();
            }
        } else {
            if (atributo.equalsIgnoreCase("apellidos")) {
                return a.getApellidos().compareTo(b.getApellidos()) < 0;
            } else if (atributo.equalsIgnoreCase("nombres")) {
                return a.getNombres().compareTo(b.getNombres()) < 0;
            } else if (atributo.equalsIgnoreCase("id")) {
                return a.getId() < b.getId();
            }
        }
        return false;
    }

    public LinkedList<Order> buscar_apellidos(String texto) {
        LinkedList<Order> lista = new LinkedList<>();
        LinkedList<Order> listita = listAll();
        if (!listita.isEmpty()) {
            Order[] aux = listita.toArray();
            for (int i = 0; i < aux.length; i++) {

                if (aux[i].getApellidos().toLowerCase().startsWith(texto.toLowerCase())) {
                    //System.out.println("**** "+aux[i].get);
                    lista.add(aux[i]);
                }
            }
        }
        return lista;
    }

    public Order buscar_identificacion(String texto) {
        Order Order = null;
        LinkedList<Order> listita = listAll();
        if (!listita.isEmpty()) {
            Order[] aux = listita.toArray();
            for (int i = 0; i < aux.length; i++) {
                if (aux[i].getIdentificacion().equals(texto)) {
                    //System.out.println("**** "+aux[i].get);
                    Order = aux[i];
                    break;
                }
            }
        }
        return Order;
    }
    */
}
