package com.lojageneradores.censo.tda.utils;

import com.lojageneradores.censo.models.Generador;

public class SearchUtils {
    public static int binarySearch(Generador[] array, int capacidad) {
        int low = 0, high = array.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (array[mid].getCapacidad() == capacidad) {
                return mid;
            } else if (array[mid].getCapacidad() < capacidad) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}
