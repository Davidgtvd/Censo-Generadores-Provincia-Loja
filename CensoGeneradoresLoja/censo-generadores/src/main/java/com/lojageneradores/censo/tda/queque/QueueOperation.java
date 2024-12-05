package com.loja.censogeneradores.tda.queue;

import com.loja.censogeneradores.tda.queue.Queue;

public class QueueOperation<T> {
    private Queue<T> queue;

    public QueueOperation() {
        queue = new Queue<>();
    }

    public void enqueue(T data) {
        queue.enqueue(data);
    }

    public T dequeue() {
        return queue.dequeue();
    }

    public T peek() {
        return queue.peek();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public int size() {
        return queue.size();
    }

    public void clear() {
        while (!queue.isEmpty()) {
            queue.dequeue();
        }
    }

    public void displayQueue() {
        Queue<T> tempQueue = new Queue<>();
        while (!queue.isEmpty()) {
            T data = queue.dequeue();
            System.out.println(data);
            tempQueue.enqueue(data);
        }
        while (!tempQueue.isEmpty()) {
            queue.enqueue(tempQueue.dequeue());
        }
    }
}
