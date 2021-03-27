package ru.geekbrains.Lesson8.HomeWork;

public class Human implements JumpRun{

    private final String name;
    private final int maxRun;
    private final int maxJump;

    public Human(String name, int maxRun, int maxJump) {
        this.name = name;
        this.maxRun = maxRun;
        this.maxJump = maxJump;
    }

    @Override
    public String run() {
        return name + " бежит";
    }

    @Override
    public String jump() {
        return name + " прыгнул";
    }

    @Override
    public int getMaxRun() {
        return maxRun;
    }

    @Override
    public int getMaxJump() {
        return maxJump;
    }

    public String toString() {
        return "Человек " + name;
    }
}
