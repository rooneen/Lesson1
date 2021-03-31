package ru.geekbrains.Lesson6.HomeWork2;

public class Dog extends Animal {

    private static final int RUN_LIMIT = 500;
    private static final int SWIM_LIMIT = 10;

    private static int count;

    public Dog(String name) {
        super(name, Breed.DOG, RUN_LIMIT, SWIM_LIMIT); // Alt + Ctrl + C - быстрое создание константы
        count++;
    }

    public static int getCount() {
        return count;
    }
}
