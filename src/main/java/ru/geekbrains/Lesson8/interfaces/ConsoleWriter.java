package ru.geekbrains.Lesson8.interfaces;

public class ConsoleWriter implements Writer {
    @Override
    public void write(String text) {
        System.out.println(text);
    }
}