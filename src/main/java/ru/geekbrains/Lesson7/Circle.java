package ru.geekbrains.Lesson7;


import ru.geekbrains.Lesson6.Shape;

public class Circle extends Shape {

    private double radius;

    public Circle(double centerX, double centerY, String color, double radius) {
        super(centerX, centerY, color);
        this.radius = radius;
    }

    public void info() {
        System.out.printf("Окружность с координатами %f, %f, радиусом %f и цветом %s\n", centerX, centerY, radius, color);
    }

    @Override
    public double square() {
        return Math.PI * radius * radius;
    }

    public double getRadius() {
        return radius;
    }


}
