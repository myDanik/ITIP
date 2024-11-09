package SixthLab;

import java.util.EmptyStackException;

public class Stack<T> {
    private T[] data;
    private int size;
    public Stack(int capacity) {
        data = (T[]) new Object[capacity];
        size = 0;
    }
    public void push(T element) {
        if (size == data.length) {
            throw new StackOverflowError("Стек заполнен, невозможно добавить элемент");
        }
        data[size] = element;
        size++;
    }
    public T pop() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        T element = data[size - 1];
        data[size-1] = null;
        size--;
        return element;
    }
    public T peek() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        return data[size - 1];
    }
}
