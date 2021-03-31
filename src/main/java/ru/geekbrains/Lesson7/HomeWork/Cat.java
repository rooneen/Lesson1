package ru.geekbrains.Lesson7.HomeWork;

public class Cat {

    private String name;
    protected int appetite;
    private int hungerTime;
    private int satiety;

    String getName() {
        return name;
    }

    int getAppetite() {
        return appetite;
    }

    int getSatiety() {
        return satiety;
    }

    void setSatiety(int satiety) {
        this.satiety = satiety;
    }

    Cat(String name, int appetite, int hungerTime) {

        this.name = name;
        this.appetite = appetite;
        this.hungerTime = hungerTime;
        this.satiety = 0;
    }

    void eat(Plate p) {
        p.decreaseFood(appetite);
        satiety += hungerTime;

    }

}
