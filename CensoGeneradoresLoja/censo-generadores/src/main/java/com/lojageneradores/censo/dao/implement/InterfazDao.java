package com.lojageneradores.censo.dao.implement;

import com.lojageneradores.tda.list.LinkedList;

public interface InterfazDao<T, K> {

    T buscar(K id);

    LinkedList<T> listar();

    boolean guardar(T entidad);

    boolean eliminar(K id);
}
