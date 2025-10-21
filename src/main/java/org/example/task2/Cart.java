package org.example.task2;

import java.util.Arrays;

public class Cart {

    private Item[] contents;
    private int index;

    public Cart(int capacity) {
        this.contents = new Item[capacity];
        this.index = 0;
    }

    public void add(Item item) {
        if (isCartFull()) {
            System.out.println("Кошик повний. Неможливо додати: " + item.getName());
            return;
        }
        this.contents[this.index] = item;
        this.index++;
    }

    public boolean removeById(int idToRemove) {
        int foundIndex = this.findItemIndexById(idToRemove);
        if (foundIndex == -1) {
            return false;
        }
        return this.removeByIndex(foundIndex);
    }

    public boolean removeByIndex(int indexToRemove) {
        if (indexToRemove < 0 || indexToRemove >= this.index) {
            return false;
        }

        if (indexToRemove != this.index - 1) {
            this.shiftArray(indexToRemove);
        }

        this.index--;
        this.contents[this.index] = null;
        return true;
    }

    private void shiftArray(int indexToRemove) {
        for (int i = indexToRemove; i < this.index - 1; i++) {
            this.contents[i] = this.contents[i + 1];
        }
    }

    private int findItemIndexById(int idToFind) {
        for (int i = 0; i < this.index; i++) {
            if (this.contents[i].getId() == idToFind) {
                return i;
            }
        }
        return -1;
    }

    public boolean isCartFull() {
        return this.index == this.contents.length;
    }

    public int getSize() {
        return this.index;
    }

    public Item[] getContents() {
        Item[] copy = new Item[this.index];
        System.arraycopy(this.contents, 0, copy, 0, this.index);
        return copy;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "items=" + Arrays.toString(Arrays.copyOf(this.contents, this.index)) +
                ", size=" + this.index +
                ", capacity=" + this.contents.length +
                '}';
    }
}