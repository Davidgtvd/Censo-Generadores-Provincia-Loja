package com.loja.censogeneradores.tda.list;

public class Node<T> {
    private T data; // Dato almacenado en el nodo (puede ser Casa, Generador, etc.)
    private Node<T> next; // Referencia al siguiente nodo en la lista o cola

    // Constructor
    public Node(T data) {
        this.data = data;
        this.next = null;
    }

    // Getters y Setters
    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }
}
