package ru.geekbrains.Lesson7;

import java.awt.*;

public class Canvas {
    public static final int CANVAS_SIZE = 10;
    private Shape[] shapes;

    public Canvas() {
        shapes = new Shape[CANVAS_SIZE]; // Ctrl + Alt + C - быстрое создание константы (имени переменной)
    }

    public void add(Shape shape) {
        int i = 0;
        while (i < CANVAS_SIZE && shapes[i] != null) {
            i++;
        }
        if (i == CANVAS_SIZE) {
            i = 0;
        }

        shapes[i] = shape;
    }
}
