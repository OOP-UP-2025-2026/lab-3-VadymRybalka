package org.example.task2;

import java.util.EmptyStackException;

public class IntStack {

    private int[] array;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;

    public IntStack() {
        this.array = new int[DEFAULT_CAPACITY];
        this.size = 0;
    }

    public void push(int element) {
        if (this.size == this.array.length) {
            this.resize();
        }
        this.array[this.size] = element;
        this.size++;
    }

    public int pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        this.size--;
        int element = this.array[this.size];
        return element;
    }

    public int peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return this.array[this.size - 1];
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public void clear() {
        this.size = 0;
    }

    private void resize() {
        int newCapacity = this.array.length * 2;
        int[] newArray = new int[newCapacity];
        System.arraycopy(this.array, 0, newArray, 0, this.size);
        this.array = newArray;
    }

    public static void main(String[] args) {
        IntStack stack = new IntStack();

        System.out.println("Стек порожній? " + stack.isEmpty());
        System.out.println("Розмір: " + stack.size());

        System.out.println("\n--- Push 1, 2, 3 ---");
        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println("Стек порожній? " + stack.isEmpty());
        System.out.println("Розмір: " + stack.size());
        System.out.println("Peek (верхній): " + stack.peek());

        System.out.println("\n--- Pop ---");
        System.out.println("Дістали: " + stack.pop());
        System.out.println("Новий Peek (верхній): " + stack.peek());
        System.out.println("Розмір: " + stack.size());

        System.out.println("\n--- Push (тест на resize) ---");
        stack.push(4);
        stack.push(5);
        stack.push(6);
        stack.push(7);
        stack.push(8);
        stack.push(9);
        stack.push(10);
        stack.push(11);
        System.out.println("Додали 11-й елемент.");
        System.out.println("Розмір: " + stack.size());
        System.out.println("Peek (верхній): " + stack.peek());

        System.out.println("\n--- Clear ---");
        stack.clear();
        System.out.println("Стек порожній? " + stack.isEmpty());
        System.out.println("Розмір: " + stack.size());

        try {
            System.out.println("\n--- Спроба Pop з порожнього стеку ---");
            stack.pop();
        } catch (EmptyStackException e) {
            System.out.println("Помилка! Спроба 'pop' з порожнього стеку.");
        }
    }
}