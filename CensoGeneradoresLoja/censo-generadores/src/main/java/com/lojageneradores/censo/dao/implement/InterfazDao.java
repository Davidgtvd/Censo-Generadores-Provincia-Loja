package com.lojageneradores.censo.dao;

import jakarta.xml.bind.JAXBException;
import com.lojageneradores.censo.tda.list.LinkedList;

/**
 * Interfaz genérica para operaciones de acceso a datos.
 *
 * @param <T> Tipo de datos manejados.
 * @param <K> Tipo de clave primaria.
 */
public interface InterfazDao<T, K> {
    T buscar(K id) throws JAXBException;
    LinkedList<T> listar() throws JAXBException;
    boolean guardar(T entidad) throws JAXBException;
    boolean eliminar(K id) throws JAXBException;
}
