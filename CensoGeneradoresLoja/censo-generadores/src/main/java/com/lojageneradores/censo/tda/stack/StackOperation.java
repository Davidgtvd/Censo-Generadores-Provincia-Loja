package com.loja.censogeneradores.tda.stack;

import com.loja.censogeneradores.tda.stack.Stack;

public class StackOperation<T> {
    private Stack<T> stack;

    public StackOperation() {
        this.stack = new Stack<>();
    }

    public void push(T data) {
        stack.push(data);
    }

    public T pop() {
        return stack.pop();
    }

    public T peek() {
        return stack.peek();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public int size() {
        return stack.size();
    }

    public void clear() {
        while (!stack.isEmpty()) {
            stack.pop();
        }
    }

    public void displayStack() {
        Stack<T> tempStack = new Stack<>();
        while (!stack.isEmpty()) {
            T data = stack.pop();
            System.out.println(data);
            tempStack.push(data);
        }
        while (!tempStack.isEmpty()) {
            stack.push(tempStack.pop());
        }
    }
}
