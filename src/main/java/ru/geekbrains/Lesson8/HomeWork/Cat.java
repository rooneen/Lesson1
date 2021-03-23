package ru.geekbrains.Lesson8.HomeWork;

public class Cat implements JumpRun {

    private final String name;
    private final int maxRun;
    private final int maxJump;

    public Cat(String name, int maxRun, int maxJump) {
        this.name = name;
        this.maxRun = maxRun;
        this.maxJump = maxJump;
    }

    public String toString() {
        return "кот " + name;
    }

    @Override
    public int getMaxRun() {
        return maxRun;
    }

    @Override
    public int getMaxJump() {
        return maxJump;
    }

    @Override
    public String run() {
        return name + " бежит";
    }

    @Override
    public String jump() {
        return name + " прыгнул";
    }
}
