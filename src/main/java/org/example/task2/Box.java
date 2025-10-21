package org.example.task2;

public class Box {

    private double length;
    private double width;
    private double height;

    public Box(double length, double width, double height) {
        this.setLength(length);
        this.setWidth(width);
        this.setHeight(height);
    }

    private void setLength(double length) {
        if (length <= 0) {
            throw new IllegalArgumentException("Довжина не може бути нульовою або від'ємною.");
        }
        this.length = length;
    }

    private void setWidth(double width) {
        if (width <= 0) {
            throw new IllegalArgumentException("Ширина не може бути нульовою або від'ємною.");
        }
        this.width = width;
    }

    private void setHeight(double height) {
        if (height <= 0) {
            throw new IllegalArgumentException("Висота не може бути нульовою або від'ємною.");
        }
        this.height = height;
    }

    public double getVolume() {
        return this.length * this.width * this.height;
    }

    public double getSurfaceArea() {
        return 2 * (this.length * this.width +
                this.length * this.height +
                this.width * this.height);
    }

    public double getLateralSurfaceArea() {
        return 2 * (this.length * this.height + this.width * this.height);
    }

    public static void main(String[] args) {
        try {
            Box box = new Box(10, 5, 3);

            System.out.println("--- Параметри коробки (10x5x3) ---");
            System.out.println("Об'єм: " + box.getVolume());
            System.out.println("Площа поверхні: " + box.getSurfaceArea());
            System.out.println("Площа бічної поверхні: " + box.getLateralSurfaceArea());

        } catch (IllegalArgumentException e) {
            System.err.println("Помилка при створенні коробки: " + e.getMessage());
        }
    }
}