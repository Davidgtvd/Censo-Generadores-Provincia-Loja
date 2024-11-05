package com.tercerotest.controller.dao;

import java.util.function.ToIntBiFunction;

import com.tercerotest.controller.dao.implement.AdapterDao;
import com.tercerotest.controller.tda.list.LinkedList;
import com.tercerotest.models.Servicio;

public class ServicioDao extends AdapterDao<Servicio> {
    private Servicio Servicio;
    private LinkedList listAll;

    public ServicioDao() {
        super(Servicio.class);
    }

    public Servicio getServicio() {
        if (Servicio == null) {
            Servicio = new Servicio();
        }
        return this.Servicio;
    }

    public void setServicio(Servicio Servicio) {
        this.Servicio = Servicio;
    }

    public LinkedList getListAll() {
        if (listAll == null) {
            this.listAll = listAll();
        }
        return listAll;
    }

    public Boolean save() throws Exception {
        Integer id = getListAll().getSize() + 1;
        Servicio.setId(id);
        this.persist(this.Servicio);
        this.listAll = listAll();
        return true;
    }

    public Boolean update() throws Exception {

        this.merge(getServicio(), getServicio().getId() - 1);
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
            Servicio[] lista = (Servicio[]) listita.toArray();
            listita.reset();
            for (int i = 1; i < lista.length; i++) {
                Servicio aux = lista[i]; // valor a ordenar
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

    private Boolean verify(Servicio a, Servicio b, Integer type_order, String atributo) {
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

    public LinkedList<Servicio> buscar_apellidos(String texto) {
        LinkedList<Servicio> lista = new LinkedList<>();
        LinkedList<Servicio> listita = listAll();
        if (!listita.isEmpty()) {
            Servicio[] aux = listita.toArray();
            for (int i = 0; i < aux.length; i++) {

                if (aux[i].getApellidos().toLowerCase().startsWith(texto.toLowerCase())) {
                    //System.out.println("**** "+aux[i].get);
                    lista.add(aux[i]);
                }
            }
        }
        return lista;
    }

    public Servicio buscar_identificacion(String texto) {
        Servicio Servicio = null;
        LinkedList<Servicio> listita = listAll();
        if (!listita.isEmpty()) {
            Servicio[] aux = listita.toArray();
            for (int i = 0; i < aux.length; i++) {
                if (aux[i].getIdentificacion().equals(texto)) {
                    //System.out.println("**** "+aux[i].get);
                    Servicio = aux[i];
                    break;
                }
            }
        }
        return Servicio;
    }
    */
}
