/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.censogeneradoresloja.dao;

/**
 *
 * @author david
 */
import com.censogeneradoresloja.models.Generador;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class GeneradorDAO {
    private final String ARCHIVO_GENERADORES = "generadores.json";
    private final ObjectMapper objectMapper;

    public GeneradorDAO() {
        this.objectMapper = new ObjectMapper();
    }

    /**
     * Obtiene todos los generadores registrados en el archivo JSON.
     *
     * @return Lista de generadores.
     * @throws IOException Si ocurre un error al leer el archivo.
     */
    public List<Generador> obtenerTodos() throws IOException {
        Path archivoPath = Path.of(ARCHIVO_GENERADORES);
        if (!Files.exists(archivoPath)) {
            return new ArrayList<>();
        }
        
        CollectionType listType = objectMapper.getTypeFactory()
            .constructCollectionType(ArrayList.class, Generador.class);
        return objectMapper.readValue(archivoPath.toFile(), listType);
    }

    /**
     * Guarda un generador en el archivo JSON. Asigna un ID único si es necesario.
     *
     * @param generador El generador a guardar.
     * @throws IOException Si ocurre un error al escribir el archivo.
     */
    public void guardar(Generador generador) throws IOException {
        List<Generador> generadores = obtenerTodos();
        // Asignar un nuevo ID si es necesario
        if (generador.getId() == null) {
            Long nuevoId = generadores.stream()
                .mapToLong(Generador::getId)
                .max()
                .orElse(0L) + 1;
            generador.setId(nuevoId);
        }
        // Eliminamos cualquier generador con el mismo ID antes de agregar el nuevo
        generadores.removeIf(g -> g.getId().equals(generador.getId()));
        generadores.add(generador);
        
        // Escribimos la lista actualizada en el archivo
        try {
            objectMapper.writeValue(new File(ARCHIVO_GENERADORES), generadores);
        } catch (IOException e) {
            e.printStackTrace(); // Manejo de error simple; puedes mejorar esto según tus necesidades
            throw e;
        }
    }

    /**
     * Elimina un generador del archivo JSON basado en su ID.
     *
     * @param id El ID del generador a eliminar.
     * @throws IOException Si ocurre un error al escribir el archivo.
     */
    public void eliminar(Long id) throws IOException {
        List<Generador> generadores = obtenerTodos();
        // Removemos el generador que tenga el ID especificado
        generadores.removeIf(g -> g.getId().equals(id));
        
        // Escribimos la lista actualizada en el archivo
        try {
            objectMapper.writeValue(new File(ARCHIVO_GENERADORES), generadores);
        } catch (IOException e) {
            e.printStackTrace(); // Manejo de error simple; puedes mejorar esto según tus necesidades
            throw e;
        }
    }

    /**
     * Obtiene un generador específico por su ID.
     *
     * @param id El ID del generador a buscar.
     * @return Un Optional que contiene el generador si se encuentra, o vacío si no.
     * @throws IOException Si ocurre un error al leer el archivo.
     */
    public Optional<Generador> obtenerPorId(Long id) throws IOException {
        List<Generador> generadores = obtenerTodos();
        return generadores.stream()
            .filter(g -> g.getId().equals(id))
            .findFirst();
    }
}