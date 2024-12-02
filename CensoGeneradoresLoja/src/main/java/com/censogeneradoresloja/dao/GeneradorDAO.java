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
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class GeneradorDAO {
    private List<Generador> generadores = new ArrayList<>();

    public void agregarGenerador(Generador generador) {
        generadores.add(generador);
    }

    public Generador obtenerGenerador(Long id) {
        for (Generador g : generadores) {
            if (g.getId().equals(id)) { 
                return g;
            }
        }
        return null; 
    }

    public List<Generador> obtenerTodosGeneradores() {
        return new ArrayList<>(generadores); 
    }

    public boolean actualizarGenerador(Generador generadorActualizado) {
        for (int i = 0; i < generadores.size(); i++) {
            Generador g = generadores.get(i);
            if (g.getId().equals(generadorActualizado.getId())) { 
                generadores.set(i, generadorActualizado);
                return true; 
            }
        }
        return false; 
    }

    public boolean eliminarGenerador(Long id) {
        return generadores.removeIf(g -> g.getId().equals(id)); 
    }

    public int contarGeneradores() {
        return generadores.size();
    }
    
    public List<Generador> encontrarGeneradoresPorMarca(String marca) {
        List<Generador> encontrados = new ArrayList<>();
        for (Generador g : generadores) {
            if (g.getMarca().equalsIgnoreCase(marca)) { 
                encontrados.add(g);
            }
        }
        return encontrados;
    }

    public Map<String, Integer> obtenerComprasPorFamilia() {
        Map<String, Integer> comprasPorFamilia = new HashMap<>();
        for (Generador g : generadores) {
            String familia = g.getFamilia(); 
            comprasPorFamilia.put(familia, comprasPorFamilia.getOrDefault(familia, 0) + 1);
        }
        return comprasPorFamilia;
    }
}