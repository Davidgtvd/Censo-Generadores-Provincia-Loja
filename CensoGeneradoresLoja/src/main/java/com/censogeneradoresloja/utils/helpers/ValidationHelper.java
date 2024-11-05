/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.censogeneradoresloja.utils.helpers;

/**
 *
 * @author david
 */

public class ValidationHelper {
    public static boolean esNumeroValido(String numero) {
        try {
            Double.parseDouble(numero);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
    public static boolean esCadenaValida(String cadena) {
        return cadena != null && !cadena.trim().isEmpty();
    }
    
    public static boolean esIdValido(String id) {
        return id != null && id.matches("[A-Za-z0-9-]+");
    }
    
    public static void validarCampoNoVacio(String campo, String nombreCampo) {
        if (!esCadenaValida(campo)) {
            throw new IllegalArgumentException(nombreCampo + " no puede estar vacío");
        }
    }
    
    public static void validarNumeroPositivo(double numero, String nombreCampo) {
        if (numero <= 0) {
            throw new IllegalArgumentException(nombreCampo + " debe ser un número positivo");
        }
    }
}
