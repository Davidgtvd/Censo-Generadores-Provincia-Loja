package com.lojageneradores.tda.list;

import java.lang.reflect.Array;
import java.util.Iterator;
import java.util.NoSuchElementException;

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

public class LinkedList<T extends Comparable<T>> implements Iterable<T> {

    private Node<T> head;
    private int size;

    public LinkedList() {
        head = null;
        size = 0;
    }

    public void add(T data) {
        if (data == null) {
            throw new IllegalArgumentException("No se pueden agregar elementos nulos");
        }

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
        if (size == 0) {
            return null;
        }

        @SuppressWarnings("unchecked")
        T[] array = (T[]) Array.newInstance(head.getData().getClass(), size);
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
            throw new IndexOutOfBoundsException("Índice fuera de rango");
        }

        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        return current.getData();
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Índice fuera de rango");
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
        reset();
        for (T item : items) {
            add(item);
        }
    }

    public void update(T object, int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Índice fuera de rango");
        }

        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        current.setData(object);
    }

    public void sort() {
        if (size > 1) {
            for (int i = 0; i < size - 1; i++) {
                Node<T> current = head;
                Node<T> next = head.getNext();
                for (int j = 0; j < size - 1 - i; j++) {
                    if (current.getData().compareTo(next.getData()) > 0) {
                        T temp = current.getData();
                        current.setData(next.getData());
                        next.setData(temp);
                    }
                    current = next;
                    next = next.getNext();
                }
            }
        }
    }

    public int search(T data) {
        Node<T> current = head;
        int index = 0;
        while (current != null) {
            if (current.getData().equals(data)) {
                return index;
            }
            current = current.getNext();
            index++;
        }
        return -1;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node<T> current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T data = current.getData();
                current = current.getNext();
                return data;
            }
        };
    }

    public int indexOf(T data) {
        return search(data);
    }
}
