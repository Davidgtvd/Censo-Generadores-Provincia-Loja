package com.loja.censogeneradores.tda.queue;

import com.loja.censogeneradores.tda.list.Node;

public class Queue<T> {
    private Node<T> front; // Primer nodo de la cola
    private Node<T> rear;  // Último nodo de la cola
    private int size;      // Tamaño de la cola

    // Constructor
    public Queue() {
        front = rear = null;
        size = 0;
    }

    // Método para agregar un elemento al final de la cola
    public void enqueue(T data) {
        Node<T> newNode = new Node<>(data);
        if (rear == null) {
            front = rear = newNode;
        } else {
            rear.setNext(newNode);
            rear = newNode;
        }
        size++;
    }

    // Método para eliminar un elemento de la parte frontal de la cola
    public T dequeue() {
        if (front == null) {
            return null;
        }
        T data = front.getData();
        front = front.getNext();
        if (front == null) {
            rear = null; // Si la cola está vacía, rear también es null
        }
        size--;
        return data;
    }

    // Método para ver el elemento en la parte frontal sin eliminarlo
    public T peek() {
        if (front == null) {
            return null;
        }
        return front.getData();
    }

    // Método para verificar si la cola está vacía
    public boolean isEmpty() {
        return size == 0;
    }

    // Método para obtener el tamaño de la cola
    public int size() {
        return size;
    }
}
