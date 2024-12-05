package com.lojageneradores.censo.rest;

public class OperacionesSistema {
    public static int busquedaSecuencial(Registro[] registros, int id) {
        for (int i = 0; i < registros.length; i++) {
            if (registros[i].getId() == id) {
                return i;
            }
        }
        return -1;
    }

    public static int busquedaBinaria(Registro[] registros, int id) {
        int inicio = 0, fin = registros.length - 1;
        while (inicio <= fin) {
            int medio = (inicio + fin) / 2;
            if (registros[medio].getId() == id) {
                return medio;
            } else if (registros[medio].getId() < id) {
                inicio = medio + 1;
            } else {
                fin = medio - 1;
            }
        }
        return -1;
    }

    public static void ordenarPorId(Registro[] registros) {
        for (int i = 0; i < registros.length - 1; i++) {
            for (int j = 0; j < registros.length - i - 1; j++) {
                if (registros[j].getId() > registros[j + 1].getId()) {
                    Registro temp = registros[j];
                    registros[j] = registros[j + 1];
                    registros[j + 1] = temp;
                }
            }
        }
    }
}
