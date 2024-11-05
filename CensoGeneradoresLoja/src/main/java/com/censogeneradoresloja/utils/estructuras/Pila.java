/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.censogeneradoresloja.utils.estructuras;

/**
 *
 * @author david
 */
import java.util.EmptyStackException;

public class Pila<T> {
    private Nodo<T> tope;
    private int tamaño;

    private static class Nodo<T> {
        T dato;
        Nodo<T> siguiente;

        Nodo(T dato) {
            this.dato = dato;
            this.siguiente = null;
        }
    }

    public Pila() {
        tope = null;
        tamaño = 0;
    }

    public void push(T dato) {
        Nodo<T> nuevoNodo = new Nodo<>(dato);
        nuevoNodo.siguiente = tope;
        tope = nuevoNodo;
        tamaño++;
    }

    public T pop() {
        if (estaVacia()) {
            throw new EmptyStackException();
        }
        T dato = tope.dato;
        tope = tope.siguiente;
        tamaño--;
        return dato;
    }

    public T peek() {
        if (estaVacia()) {
            throw new EmptyStackException();
        }
        return tope.dato;
    }

    public boolean estaVacia() {
        return tamaño == 0;
    }

    public int tamaño() {
        return tamaño;
    }

    public void limpiar() {
        tope = null;
        tamaño = 0;
    }
}
