/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.censogeneradoresloja.dao;

/**
 *
 * @author david
 */

import com.censogeneradoresloja.models.Transaccion;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TransaccionDAO {
    private final String ARCHIVO_TRANSACCIONES = "transacciones.json";
    private final ObjectMapper objectMapper;

    public TransaccionDAO() {
        this.objectMapper = new ObjectMapper();
    }

    public List<Transaccion> obtenerTodas() throws IOException {
        File archivo = new File(ARCHIVO_TRANSACCIONES);
        if (!archivo.exists()) {
            return new ArrayList<>();
        }
        CollectionType listType = objectMapper.getTypeFactory()
            .constructCollectionType(ArrayList.class, Transaccion.class);
        return objectMapper.readValue(archivo, listType);
    }

    public void guardar(Transaccion transaccion) throws IOException {
        List<Transaccion> transacciones = obtenerTodas();
        if (transaccion.getId() == null) { // Comparación con null
            Long nuevoId = transacciones.stream()
                .mapToLong(Transaccion::getId)
                .max()
                .orElse(0L) + 1;
            transaccion.setId(nuevoId);
        }
        transacciones.add(transaccion);
        objectMapper.writeValue(new File(ARCHIVO_TRANSACCIONES), transacciones);
    }

    public Optional<Transaccion> obtenerPorId(Long id) throws IOException {
        List<Transaccion> transacciones = obtenerTodas();
        return transacciones.stream()
            .filter(transaccion -> transaccion.getId().equals(id))
            .findFirst(); // Devuelve un Optional
    }

    public void eliminar(Long id) throws IOException {
        List<Transaccion> transacciones = obtenerTodas();
        transacciones.removeIf(transaccion -> transaccion.getId().equals(id)); // Elimina la transacción con el ID dado
        objectMapper.writeValue(new File(ARCHIVO_TRANSACCIONES), transacciones); // Escribe la lista actualizada en el archivo
    }
}