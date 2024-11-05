/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.censogeneradoresloja.utils.estructuras;

/**
 *
 * @author david
 */
import java.util.LinkedList;
import java.util.Queue;

public class Cola<T> {
    private final Queue<T> queue;

    public Cola() {
        this.queue = new LinkedList<>();
    }

    public void enqueue(T element) {
        queue.offer(element);
    }

    public T dequeue() {
        return queue.poll();
    }

    public T front() {
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
}