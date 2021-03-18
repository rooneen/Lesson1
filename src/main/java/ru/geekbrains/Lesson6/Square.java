package ru.geekbrains.Lesson6;

public class Square extends Circle {
    public Square(double centerX, double centerY, String color, double radius) {
        super(centerX, centerY, color, radius);
    }

    @Override
    public double square() {
        return (getRadius() + getRadius()) * (getRadius() + getRadius());
    }

    @Override
    public void info() {
        System.out.printf("Квадрат с координатами %f, %f, радиусом вписанной окружности %f и цветом %s\n", centerX, centerY, getRadius(), color);

    }
}
