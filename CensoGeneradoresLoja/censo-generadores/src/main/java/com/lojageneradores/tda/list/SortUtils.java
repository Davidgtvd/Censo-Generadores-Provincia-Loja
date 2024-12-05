package com.lojageneradores.censo.tda.utils;

import com.lojageneradores.censo.models.Generador;

public class SortUtils {
    public static void quickSort(Generador[] array, int low, int high) {
        if (low < high) {
            int pi = partition(array, low, high);
            quickSort(array, low, pi - 1);
            quickSort(array, pi + 1, high);
        }
    }

    private static int partition(Generador[] array, int low, int high) {
        Generador pivot = array[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (array[j].compareTo(pivot) <= 0) {
                i++;
                Generador temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        Generador temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;
        return i + 1;
    }
}
