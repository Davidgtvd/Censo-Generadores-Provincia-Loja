package com.tercerotest.controller.dao;

import com.tercerotest.controller.dao.implement.AdapterDao;
import com.tercerotest.controller.tda.list.LinkedList;
import com.tercerotest.models.Casa;
import com.tercerotest.models.enumerator.TipoIdentificacion;

public class CasaDao extends AdapterDao<Casa> {
    private Casa persona;
    private LinkedList listAll;

    public CasaDao() {
        super(Casa.class);
    }

    public Casa getPersona() {
        if (persona == null) {
            persona = new Casa();
        }
        return this.persona;
    }

    public void setPersona(Casa persona) {
        this.persona = persona;
    }

    public LinkedList getListAll() {
        if (listAll == null) {
            this.listAll = listAll();
        }
        return listAll;
    }

    public Boolean save() throws Exception {
        Integer id = getListAll().getSize() + 1;
        persona.setId(id);
        this.persist(this.persona);
        this.listAll = listAll();
        return true;
    }

    public Boolean update() throws Exception {

        this.merge(getPersona(), getPersona().getId() - 1);
        this.listAll = listAll();
        return true;
    }

    public TipoIdentificacion getTipoIdentificacion(String tipo) {
        return TipoIdentificacion.valueOf(tipo);
    }

    public TipoIdentificacion[] getTipos() {
        return TipoIdentificacion.values();
    }

    public LinkedList order(Integer type_order, String atributo) {
        LinkedList listita = listAll();
        if (!listAll().isEmpty()) {
            Casa[] lista = (Casa[]) listita.toArray();
            listita.reset();
            for (int i = 1; i < lista.length; i++) {
                Casa aux = lista[i]; // valor a ordenar
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

    private Boolean verify(Casa a, Casa b, Integer type_order, String atributo) {
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

    public LinkedList<Casa> buscar_apellidos(String texto) {
        LinkedList<Casa> lista = new LinkedList<>();
        LinkedList<Casa> listita = listAll();
        if (!listita.isEmpty()) {
            Casa[] aux = listita.toArray();
            for (int i = 0; i < aux.length; i++) {

                if (aux[i].getApellidos().toLowerCase().startsWith(texto.toLowerCase())) {
                    //System.out.println("**** "+aux[i].get);
                    lista.add(aux[i]);
                }
            }
        }
        return lista;
    }

    public Casa buscar_identificacion(String texto) {
        Casa persona = null;
        LinkedList<Casa> listita = listAll();
        if (!listita.isEmpty()) {
            Casa[] aux = listita.toArray();
            for (int i = 0; i < aux.length; i++) {
                if (aux[i].getIdentificacion().equals(texto)) {
                    //System.out.println("**** "+aux[i].get);
                    persona = aux[i];
                    break;
                }
            }
        }
        return persona;
    }

}
