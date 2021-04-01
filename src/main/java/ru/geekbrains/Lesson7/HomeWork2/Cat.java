package ru.geekbrains.Lesson7.HomeWork2;

public class Cat {
    private final String name;
    private final int appetite;
    private boolean satiety;

    public Cat(String name, int appetite) {
        assert appetite > 0 : "Аппетит должен быть > 0";
        this.name = name;
        this.appetite = appetite;
        this.satiety = false;
    }

    public void eat(Plate plate) {
        if (satiety) {
            System.out.printf("%s: сытый \n", name);
            return;
        }

        if (plate.decreaseFood(appetite)) {
            System.out.printf("%s: покушал и сытый \n", name);
            satiety = true;
            return;
        }
        System.out.printf("%s: не хватило еды в миске \n", name);
        satiety = false;
    }
}
