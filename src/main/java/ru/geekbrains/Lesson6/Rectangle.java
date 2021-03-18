package ru.geekbrains.Lesson6;

public class Rectangle extends Shape {
    private double sideA;
    private double sideB;

    public Rectangle(double centerX, double centerY, String color, double sideA, double sideB) {
        super(centerX, centerY, color);
        this.sideA = sideA;
        this.sideB = sideB;

    }

    @Override
    public double square() {
        return sideB * sideA;
    }
}
