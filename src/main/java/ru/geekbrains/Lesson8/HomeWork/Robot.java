package ru.geekbrains.Lesson8.HomeWork;

public class Robot implements JumpRun{

    private final String name;
    private final int maxRun;
    private final int maxJump;

    public Robot(String name, int maxRun, int maxJump) {
        this.name = name;
        this.maxRun = maxRun;
        this.maxJump = maxJump;
    }

    @Override
    public int getMaxJump() {
        return maxJump;
    }

    @Override
    public int getMaxRun() {
        return maxRun;
    }

    @Override
    public String run() {
        return name + " бежит";
    }

    @Override
    public String jump() {
        return name + " прыгнул";
    }

    public String toString() {
        return "робот " + name;
    }
}
