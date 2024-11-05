/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.censogeneradoresloja.utils.helpers;

/**
 *
 * @author david
 */
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileHelper {
    private static final ObjectMapper objectMapper = new ObjectMapper();
    
    public static <T> void guardarDatos(List<T> datos, String archivo) {
        try {
            objectMapper.writeValue(new File(archivo), datos);
        } catch (IOException e) {
            throw new RuntimeException("Error al guardar datos: " + e.getMessage());
        }
    }
    
    public static <T> List<T> cargarDatos(String archivo, Class<T> clase) {
        try {
            File file = new File(archivo);
            if (!file.exists()) {
                return new ArrayList<>();
            }
            CollectionType type = objectMapper.getTypeFactory()
                .constructCollectionType(List.class, clase);
            return objectMapper.readValue(file, type);
        } catch (IOException e) {
            throw new RuntimeException("Error al cargar datos: " + e.getMessage());
        }
    }
}
