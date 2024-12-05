package com.loja.censogeneradores.tda.queue;

import com.loja.censogeneradores.tda.list.Node;

public class Queue<T> {
    private Node<T> front;
    private Node<T> rear;
    private int size;

    public Queue() {
        front = rear = null;
        size = 0;
    }

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

    public T dequeue() {
        if (front == null) {
            return null;
        }
        T data = front.getData();
        front = front.getNext();
        if (front == null) {
            rear = null;
        }
        size--;
        return data;
    }

    public T peek() {
        if (front == null) {
            return null;
        }
        return front.getData();
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }
}
