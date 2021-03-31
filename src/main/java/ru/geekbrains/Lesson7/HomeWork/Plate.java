package ru.geekbrains.Lesson7.HomeWork;

public class Plate {

    public static final int FOOD = 400;
    private int food;

    int getFood() {
        return food;
    }

    Plate(int food) {
        this.food = food;
    }

    void decreaseFood(int n) {
        food -= n;
    }

    void increaseFood() {
        this.food += FOOD;
        System.out.println("В миску добавили" + FOOD +  " грамм корма");
    }

    boolean checkFood(int n) {
        return (food - n) >= 0;

    }


}
