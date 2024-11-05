package com.tercerotest.controller.dao;

import java.util.function.ToIntBiFunction;

import com.tercerotest.controller.dao.implement.AdapterDao;
import com.tercerotest.controller.tda.list.LinkedList;
import com.tercerotest.models.Equipo;
import com.tercerotest.models.enumerator.TipoEquipo;
import com.tercerotest.models.enumerator.TipoIdentificacion;

public class EquipoDao extends AdapterDao<Equipo> {
    private Equipo Equipo;
    private LinkedList listAll;

    public EquipoDao() {
        super(Equipo.class);
    }

    public Equipo getEquipo() {
        if (Equipo == null) {
            Equipo = new Equipo();
        }
        return this.Equipo;
    }

    public void setEquipo(Equipo Equipo) {
        this.Equipo = Equipo;
    }

    public LinkedList getListAll() {
        if (listAll == null) {
            this.listAll = listAll();
        }
        return listAll;
    }

    public Boolean save() throws Exception {
        Integer id = getListAll().getSize() + 1;
        Equipo.setId(id);
        this.persist(this.Equipo);
        this.listAll = listAll();
        return true;
    }

    public Boolean update() throws Exception {

        this.merge(getEquipo(), getEquipo().getId() - 1);
        this.listAll = listAll();
        return true;
    }
    public TipoEquipo getTipoEquipo(String tipo) {
        return TipoEquipo.valueOf(tipo);
    }
    public TipoEquipo[] getTipoEquipos() {
        return TipoEquipo.values();
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
            Equipo[] lista = (Equipo[]) listita.toArray();
            listita.reset();
            for (int i = 1; i < lista.length; i++) {
                Equipo aux = lista[i]; // valor a ordenar
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

    private Boolean verify(Equipo a, Equipo b, Integer type_order, String atributo) {
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

    public LinkedList<Equipo> buscar_apellidos(String texto) {
        LinkedList<Equipo> lista = new LinkedList<>();
        LinkedList<Equipo> listita = listAll();
        if (!listita.isEmpty()) {
            Equipo[] aux = listita.toArray();
            for (int i = 0; i < aux.length; i++) {

                if (aux[i].getApellidos().toLowerCase().startsWith(texto.toLowerCase())) {
                    //System.out.println("**** "+aux[i].get);
                    lista.add(aux[i]);
                }
            }
        }
        return lista;
    }

    public Equipo buscar_identificacion(String texto) {
        Equipo Equipo = null;
        LinkedList<Equipo> listita = listAll();
        if (!listita.isEmpty()) {
            Equipo[] aux = listita.toArray();
            for (int i = 0; i < aux.length; i++) {
                if (aux[i].getIdentificacion().equals(texto)) {
                    //System.out.println("**** "+aux[i].get);
                    Equipo = aux[i];
                    break;
                }
            }
        }
        return Equipo;
    }
    */
}
