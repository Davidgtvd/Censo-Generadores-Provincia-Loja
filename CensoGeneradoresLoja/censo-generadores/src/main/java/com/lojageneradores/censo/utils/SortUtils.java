package com.lojageneradores.censo.utils;

import com.lojageneradores.models.Generador; // Corregir importación

public class SortUtils {

    public static void quickSort(Generador[] array, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(array, low, high);
            quickSort(array, low, pivotIndex - 1);
            quickSort(array, pivotIndex + 1, high);
        }
    }

    private static int partition(Generador[] array, int low, int high) {
        Generador pivot = array[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            // Usar compareTo para comparar generadores
            if (array[j].compareTo(pivot) <= 0) {
                i++;
                swap(array, i, j);
            }
        }

        swap(array, i + 1, high);
        return i + 1;
    }

    private static void swap(Generador[] array, int i, int j) {
        Generador temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
