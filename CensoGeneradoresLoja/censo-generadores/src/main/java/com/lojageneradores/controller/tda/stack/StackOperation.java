package com.loja.censogeneradores.tda.stack;

import com.loja.censogeneradores.tda.stack.Stack;

public class StackOperation<T> {
    private Stack<T> stack;

    // Constructor
    public StackOperation() {
        this.stack = new Stack<>();
    }

    // Método para apilar un elemento
    public void push(T data) {
        stack.push(data);
    }

    // Método para desapilar un elemento
    public T pop() {
        return stack.pop();
    }

    // Método para ver el elemento en la cima sin eliminarlo
    public T peek() {
        return stack.peek();
    }

    // Método para verificar si la pila está vacía
    public boolean isEmpty() {
        return stack.isEmpty();
    }

    // Método para obtener el tamaño de la pila
    public int size() {
        return stack.size();
    }

    // Método para limpiar la pila
    public void clear() {
        while (!stack.isEmpty()) {
            stack.pop();
        }
    }

    // Método para mostrar los elementos de la pila (por ejemplo, generadores apilados)
    public void displayStack() {
        Stack<T> tempStack = new Stack<>();
        while (!stack.isEmpty()) {
            T data = stack.pop();
            System.out.println(data);
            tempStack.push(data); // Re-apilamos para mantener la pila original intacta
        }
        while (!tempStack.isEmpty()) { // Reapilamos los elementos a la pila original
            stack.push(tempStack.pop());
        }
    }
}
