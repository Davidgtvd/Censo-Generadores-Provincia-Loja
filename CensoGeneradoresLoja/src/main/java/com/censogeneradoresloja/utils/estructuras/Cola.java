/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.censogeneradoresloja.utils.estructuras;

/**
 *
 * @author david
 */
public class Cola<T> {
    private Nodo<T> frente;
    private Nodo<T> final_;
    private int tamano;
    
    private static class Nodo<T> {
        T dato;
        Nodo<T> siguiente;
        
        Nodo(T dato) {
            this.dato = dato;
            this.siguiente = null;
        }
    }
    
    public Cola() {
        this.frente = null;
        this.final_ = null;
        this.tamano = 0;
    }
    
    public void encolar(T elemento) {
        Nodo<T> nuevoNodo = new Nodo<>(elemento);
        if (estaVacia()) {
            frente = final_ = nuevoNodo;
        } else {
            final_.siguiente = nuevoNodo;
            final_ = nuevoNodo;
        }
        tamano++;
    }
    
    public T desencolar() {
        if (estaVacia()) {
            throw new IllegalStateException("La cola está vacía");
        }
        T elemento = frente.dato;
        frente = frente.siguiente;
        if (frente == null) {
            final_ = null;
        }
        tamano--;
        return elemento;
    }
    
    public T verFrente() {
        if (estaVacia()) {
            throw new IllegalStateException("La cola está vacía");
        }
        return frente.dato;
    }
    
    public boolean estaVacia() {
        return frente == null;
    }
    
    public int getTamano() {
        return tamano;
    }
    
    public void limpiar() {
        frente = final_ = null;
        tamano = 0;
    }
}