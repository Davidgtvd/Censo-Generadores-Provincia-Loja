package com.lojageneradores.censo.utils;

import com.lojageneradores.models.Generador; // Corregir importación

public class SearchUtils {

    public static int binarySearch(Generador[] array, int capacidadBuscada) {
        // Primero, ordenar el array (necesario para binary search)
        SortUtils.quickSort(array, 0, array.length - 1);

        int low = 0;
        int high = array.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int capacidadMid = array[mid].getCapacidad();

            if (capacidadMid == capacidadBuscada) {
                return mid;
            } else if (capacidadMid < capacidadBuscada) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1; // No encontrado
    }
}
