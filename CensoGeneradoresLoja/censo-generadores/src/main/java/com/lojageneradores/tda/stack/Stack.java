package com.loja.censogeneradores.tda.stack;

import com.loja.censogeneradores.tda.list.Node;

public class Stack<T> {
    private Node<T> top;
    private int size;

    public Stack() {
        top = null;
        size = 0;
    }

    public void push(T data) {
        Node<T> newNode = new Node<>(data);
        newNode.setNext(top);
        top = newNode;
        size++;
    }

    public T pop() {
        if (top == null) {
            return null;
        }
        T data = top.getData();
        top = top.getNext();
        size--;
        return data;
    }

    public T peek() {
        if (top == null) {
            return null;
        }
        return top.getData();
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }
}
