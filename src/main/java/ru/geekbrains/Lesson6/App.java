package ru.geekbrains.Lesson6;

public class App {
    // Абстракция
    //Инкапсюляция
    // Наследование

    public static void main(String[] args) {
        Circle circle = new Circle(1, 1, "WIT", 3);
        System.out.println(circle.square());
        circle.info();
        Square black = new Square(2, 2, "Black", 2);
        black.info();

    }
}
