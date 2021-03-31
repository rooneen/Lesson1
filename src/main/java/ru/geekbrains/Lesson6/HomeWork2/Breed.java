package ru.geekbrains.Lesson6.HomeWork2;

public enum Breed {
    CAT("Котик"), DOG("Собачка");

    private String breed;

    Breed(String breed) { // Alt + Ent - быстрое создание класса
        this.breed = breed;
    }

    public String getBreed() {
        return breed;
    }
}
