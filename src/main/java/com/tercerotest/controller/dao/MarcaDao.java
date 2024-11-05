package com.tercerotest.controller.dao;

import java.util.function.ToIntBiFunction;

import com.tercerotest.controller.dao.implement.AdapterDao;
import com.tercerotest.controller.tda.list.LinkedList;
import com.tercerotest.models.Marca;
import com.tercerotest.models.enumerator.TipoIdentificacion;

public class MarcaDao extends AdapterDao<Marca> {
    private Marca Marca;
    private LinkedList listAll;

    public MarcaDao() {
        super(Marca.class);
    }

    public Marca getMarca() {
        if (Marca == null) {
            Marca = new Marca();
        }
        return this.Marca;
    }

    public void setMarca(Marca Marca) {
        this.Marca = Marca;
    }

    public LinkedList getListAll() {
        if (listAll == null) {
            this.listAll = listAll();
        }
        return listAll;
    }

    public Boolean save() throws Exception {
        Integer id = getListAll().getSize() + 1;
        Marca.setId(id);
        this.persist(this.Marca);
        this.listAll = listAll();
        return true;
    }

    public Boolean update() throws Exception {

        this.merge(getMarca(), getMarca().getId() - 1);
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
            Marca[] lista = (Marca[]) listita.toArray();
            listita.reset();
            for (int i = 1; i < lista.length; i++) {
                Marca aux = lista[i]; // valor a ordenar
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

    private Boolean verify(Marca a, Marca b, Integer type_order, String atributo) {
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

    public LinkedList<Marca> buscar_apellidos(String texto) {
        LinkedList<Marca> lista = new LinkedList<>();
        LinkedList<Marca> listita = listAll();
        if (!listita.isEmpty()) {
            Marca[] aux = listita.toArray();
            for (int i = 0; i < aux.length; i++) {

                if (aux[i].getApellidos().toLowerCase().startsWith(texto.toLowerCase())) {
                    //System.out.println("**** "+aux[i].get);
                    lista.add(aux[i]);
                }
            }
        }
        return lista;
    }

    public Marca buscar_identificacion(String texto) {
        Marca Marca = null;
        LinkedList<Marca> listita = listAll();
        if (!listita.isEmpty()) {
            Marca[] aux = listita.toArray();
            for (int i = 0; i < aux.length; i++) {
                if (aux[i].getIdentificacion().equals(texto)) {
                    //System.out.println("**** "+aux[i].get);
                    Marca = aux[i];
                    break;
                }
            }
        }
        return Marca;
    }
    */
}
