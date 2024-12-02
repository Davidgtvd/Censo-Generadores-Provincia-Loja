package com.tercerotest.controller.dao;

import java.util.function.ToIntBiFunction;

import com.tercerotest.controller.dao.implement.AdapterDao;
import com.tercerotest.controller.tda.list.LinkedList;
import com.tercerotest.models.OrderDetalle;

public class OrderDetalleDao extends AdapterDao<OrderDetalle> {
    private OrderDetalle OrderDetalle;
    private LinkedList listAll;

    public OrderDetalleDao() {
        super(OrderDetalle.class);
    }

    public OrderDetalle getOrderDetalle() {
        if (OrderDetalle == null) {
            OrderDetalle = new OrderDetalle();
        }
        return this.OrderDetalle;
    }

    public void setOrderDetalle(OrderDetalle OrderDetalle) {
        this.OrderDetalle = OrderDetalle;
    }

    public LinkedList getListAll() {
        if (listAll == null) {
            this.listAll = listAll();
        }
        return listAll;
    }

    public Boolean save() throws Exception {
        Integer id = getListAll().getSize() + 1;
        OrderDetalle.setId(id);
        this.persist(this.OrderDetalle);
        this.listAll = listAll();
        return true;
    }

    public Boolean update() throws Exception {

        this.merge(getOrderDetalle(), getOrderDetalle().getId() - 1);
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
            OrderDetalle[] lista = (OrderDetalle[]) listita.toArray();
            listita.reset();
            for (int i = 1; i < lista.length; i++) {
                OrderDetalle aux = lista[i]; // valor a ordenar
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

    private Boolean verify(OrderDetalle a, OrderDetalle b, Integer type_order, String atributo) {
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

    public LinkedList<OrderDetalle> buscar_apellidos(String texto) {
        LinkedList<OrderDetalle> lista = new LinkedList<>();
        LinkedList<OrderDetalle> listita = listAll();
        if (!listita.isEmpty()) {
            OrderDetalle[] aux = listita.toArray();
            for (int i = 0; i < aux.length; i++) {

                if (aux[i].getApellidos().toLowerCase().startsWith(texto.toLowerCase())) {
                    //System.out.println("**** "+aux[i].get);
                    lista.add(aux[i]);
                }
            }
        }
        return lista;
    }

    public OrderDetalle buscar_identificacion(String texto) {
        OrderDetalle OrderDetalle = null;
        LinkedList<OrderDetalle> listita = listAll();
        if (!listita.isEmpty()) {
            OrderDetalle[] aux = listita.toArray();
            for (int i = 0; i < aux.length; i++) {
                if (aux[i].getIdentificacion().equals(texto)) {
                    //System.out.println("**** "+aux[i].get);
                    OrderDetalle = aux[i];
                    break;
                }
            }
        }
        return OrderDetalle;
    }
    */
}
