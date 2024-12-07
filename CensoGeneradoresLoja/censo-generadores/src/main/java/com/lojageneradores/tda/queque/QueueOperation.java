package com.lojageneradores.tda.queque;

import java.util.LinkedList;
import java.util.Queue;

public class QueueOperation<T> {

    private final Queue<T> queue;

    public QueueOperation() {
        queue = new LinkedList<>();
    }

    public void enqueue(T data) {
        queue.add(data);
    }

    public T dequeue() {
        return queue.poll();
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
        queue.clear();
    }

    public void displayQueue() {
        Queue<T> tempQueue = new LinkedList<>();
        while (!queue.isEmpty()) {
            T data = queue.poll();
            System.out.println(data);
            tempQueue.add(data);
        }
        while (!tempQueue.isEmpty()) {
            queue.add(tempQueue.poll());
        }
    }
}
