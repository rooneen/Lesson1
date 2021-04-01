package ru.geekbrains.Lesson11;

abstract class Animal {
    private final String name;
    private final int age;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void feed() {
        System.out.println(name + " сыт.");
    }
}