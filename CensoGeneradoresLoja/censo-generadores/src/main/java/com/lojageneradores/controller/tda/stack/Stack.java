package com.loja.censogeneradores.tda.stack;

import com.loja.censogeneradores.tda.list.Node;

public class Stack<T> {
    private Node<T> top; // Nodo en la cima de la pila
    private int size;    // Tamaño de la pila

    // Constructor
    public Stack() {
        top = null;
        size = 0;
    }

    // Método para apilar (agregar un elemento en la cima de la pila)
    public void push(T data) {
        Node<T> newNode = new Node<>(data); // Crear un nuevo nodo
        newNode.setNext(top); // El siguiente nodo será el actual top
        top = newNode; // El nuevo nodo se convierte en el top
        size++; // Incrementa el tamaño de la pila
    }

    // Método para desapilar (eliminar el elemento en la cima de la pila)
    public T pop() {
        if (top == null) {
            return null; // Si la pila está vacía, no se puede desapilar
        }
        T data = top.getData(); // Obtiene el dato del nodo en la cima
        top = top.getNext(); // Mueve el top al siguiente nodo
        size--; // Decrementa el tamaño de la pila
        return data; // Retorna el dato desapilado
    }

    // Método para ver el elemento en la cima de la pila sin eliminarlo
    public T peek() {
        if (top == null) {
            return null; // Si la pila está vacía, retorna null
        }
        return top.getData(); // Retorna el dato en la cima de la pila
    }

    // Método para verificar si la pila está vacía
    public boolean isEmpty() {
        return size == 0;
    }

    // Método para obtener el tamaño de la pila
    public int size() {
        return size;
    }
}
