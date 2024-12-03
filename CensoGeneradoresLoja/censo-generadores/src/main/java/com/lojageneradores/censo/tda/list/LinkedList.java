package com.loja.censogeneradores.tda.list;

public class LinkedList<T> {
    private Node<T> head; // Primer nodo de la lista
    private int size; // Tamaño de la lista

    // Constructor
    public LinkedList() {
        head = null;
        size = 0;
    }

    // Método para agregar un elemento al final de la lista
    public void add(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
        } else {
            Node<T> current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newNode);
        }
        size++;
    }

    // Método para obtener el tamaño de la lista
    public int size() {
        return size;
    }

    // Método para convertir la lista a un arreglo
    public T[] toArray() {
        T[] array = (T[]) new Object[size];
        Node<T> current = head;
        int i = 0;
        while (current != null) {
            array[i++] = current.getData();
            current = current.getNext();
        }
        return array;
    }

    // Método para obtener el nodo en un índice específico
    public T get(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        return current.getData();
    }

    // Método para eliminar un elemento de la lista (por ejemplo, si ya no se censa una casa)
    public void remove(int index) {
        if (index < 0 || index >= size) {
            return;
        }
        if (index == 0) {
            head = head.getNext();
        } else {
            Node<T> current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.getNext();
            }
            current.setNext(current.getNext().getNext());
        }
        size--;
    }
}
