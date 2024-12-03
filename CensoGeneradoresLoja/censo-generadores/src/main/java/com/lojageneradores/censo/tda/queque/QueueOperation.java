package com.loja.censogeneradores.tda.queue;

import com.loja.censogeneradores.tda.queue.Queue;

public class QueueOperation<T> {
    private Queue<T> queue;

    // Constructor
    public QueueOperation() {
        queue = new Queue<>();
    }

    // Método para encolar un elemento
    public void enqueue(T data) {
        queue.enqueue(data);
    }

    // Método para desencolar un elemento
    public T dequeue() {
        return queue.dequeue();
    }

    // Método para ver el primer elemento sin eliminarlo
    public T peek() {
        return queue.peek();
    }

    // Método para verificar si la cola está vacía
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    // Método para obtener el tamaño de la cola
    public int size() {
        return queue.size();
    }

    // Método para limpiar la cola
    public void clear() {
        while (!queue.isEmpty()) {
            queue.dequeue();
        }
    }

    // Método para mostrar los elementos de la cola (por ejemplo, casas o generadores en proceso)
    public void displayQueue() {
        Queue<T> tempQueue = new Queue<>();
        while (!queue.isEmpty()) {
            T data = queue.dequeue();
            System.out.println(data);
            tempQueue.enqueue(data); // Re-encolar para mantener la cola original intacta
        }
        while (!tempQueue.isEmpty()) { // Re-encolamos los elementos a la cola original
            queue.enqueue(tempQueue.dequeue());
        }
    }
}
