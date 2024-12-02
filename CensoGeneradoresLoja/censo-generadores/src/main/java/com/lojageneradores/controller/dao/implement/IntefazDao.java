package com.lojageneradores.censo.dao.implement;

import com.lojageneradores.censo.tda.list.LinkedList;

public interface IntefazDao<T> {
    void persist(T object) throws Exception;

    void merge(T object, Integer index) throws Exception;

    LinkedList<T> listAll();

    T get(Integer id) throws Exception;
}
