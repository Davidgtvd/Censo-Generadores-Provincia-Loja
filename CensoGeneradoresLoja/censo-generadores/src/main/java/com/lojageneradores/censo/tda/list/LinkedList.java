package com.loja.censogeneradores.tda.list;

class Node<T> {
    private T data;  
    private Node<T> next;  

    public Node(T data) {
        this.data = data;
        this.next = null;
    }

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

public class LinkedList<T> {
    private Node<T> head; 
    private int size; 
    // Constructor
    public LinkedList() {
        head = null;
        size = 0;
    }

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

    public int size() {
        return size;
    }

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

    public boolean isEmpty() {
        return size == 0;
    }

    public void reset() {
        head = null;
        size = 0;
    }

    public void toList(T[] items) {
        head = null;
        size = 0;
        for (T item : items) {
            add(item);
        }
    }

    public void update(T object, int index) {
        if (index < 0 || index >= size) {
            return;
        }
        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        current.setData(object);
    }
}
