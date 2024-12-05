package com.lojageneradores.censo;

import com.lojageneradores.censo.models.Generador;
import com.lojageneradores.censo.tda.SortUtils;
import com.lojageneradores.censo.tda.SearchUtils;

public class Main {
    public static void main(String[] args) {
        Generador[] generadores = {
            new Generador("Generador A", 1000),
            new Generador("Generador B", 750),
            new Generador("Generador C", 1500),
            new Generador("Generador D", 500)
        };

        System.out.println("Generadores originales:");
        printArray(generadores);

        System.out.println("\nOrdenando generadores por capacidad usando QuickSort...");
        SortUtils.quickSort(generadores, 0, generadores.length - 1);
        printArray(generadores);

        System.out.println("\nBuscando el generador con capacidad 750...");
        int index = SearchUtils.binarySearch(generadores, 750);
        if (index != -1) {
            System.out.println("Generador encontrado: " + generadores[index]);
        } else {
            System.out.println("Generador no encontrado.");
        }

        System.out.println("\nBuscando un generador con capacidad 2000...");
        index = SearchUtils.binarySearch(generadores, 2000);
        if (index != -1) {
            System.out.println("Generador encontrado: " + generadores[index]);
        } else {
            System.out.println("Generador no encontrado.");
        }
    }

    private static void printArray(Generador[] array) {
        for (Generador generador : array) {
            System.out.println(generador);
        }
    }
}
