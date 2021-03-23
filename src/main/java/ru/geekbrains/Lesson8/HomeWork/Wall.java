package ru.geekbrains.Lesson8.HomeWork;

public class Wall implements Test{

    private int height;

    public Wall(int height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "высота стены " + height + " метров.";
    }

    @Override
    public boolean toRun(int maxRun) {
        return false;
    }

    @Override
    public boolean toJump(int maxJump) {
        return (maxJump >= height);
    }
}
