package ru.geekbrains.Lesson6.HomeWork2;

public class Cat extends Animal {

    private static final int RUN_LIMIT = 200;
    private static final int SWIM_LIMIT = 0;

    private static int count;

    public Cat(String name) {
        super(name, Breed.CAT, RUN_LIMIT, SWIM_LIMIT);
        count++;
    }

    @Override
    public void swim(double distance) {
        System.out.println("Коты не любят плавать");
    }

    public static int getCount() {
        return count;
    }
}
