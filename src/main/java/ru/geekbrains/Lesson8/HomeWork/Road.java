package ru.geekbrains.Lesson8.HomeWork;

public class Road implements Test {

    private int length;

    public Road(int length) {
        this.length = length;
    }

    @Override
    public String toString() {
        return "длина дорожки " + length + " метров.";
    }

    @Override
    public boolean toRun(int maxRun) {
        return (maxRun >= length);
    }

    @Override
    public boolean toJump(int maxJump) {
        return false;
    }
}
