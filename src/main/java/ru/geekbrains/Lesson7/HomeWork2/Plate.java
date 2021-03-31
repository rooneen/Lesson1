package ru.geekbrains.Lesson7.HomeWork2;

public class Plate {
    private int food;

    public Plate(int food) {
        this.food = food;
    }

    public boolean decreaseFood(int n) {
        if(n >= 0 && food >= n) {
            food -= n;
            return true;
        }
        return false;
    }

    public int getFood() {
        return food;
    }
}
