package ru.geekbrains.Lesson6;

public abstract class Shape { // super или родительский класс
    //круг, квадрат, прямоугольник
    protected double centerX;
    protected double centerY;
    protected String color;

    public Shape(double centerX, double centerY, String color) {
        this.centerX = centerX;
        this.centerY = centerY;
        this.color = color;

    }

    public double getCenterX() {
        return centerX;
    }

    public void setCenterX(double centerX) {
        this.centerX = centerX;
    }

    public double getCenterY() {
        return centerY;
    }

    public void setCenterY(double centerY) {
        this.centerY = centerY;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public abstract double square();


}
