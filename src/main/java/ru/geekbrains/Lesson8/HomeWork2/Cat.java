package ru.geekbrains.Lesson8.HomeWork2;

public class Cat implements Player {

    private boolean play = true;
    private final String name;
    private final int runLimit;
    private final int jumpLimit;

    public Cat(String name, int runLimit, int jumpLimit) {
        this.name = name;
        this.runLimit = runLimit;
        this.jumpLimit = jumpLimit;
    }

    @Override
    public void jump(Wall wall) {
        if (play) {
            if (jumpLimit >= wall.getHeight()) {
                System.out.println("кот " + name + " преодолел препятствие " + wall.toString());
            } else {
                System.out.println("кот " + name + " не преодолел препятствие " + wall.toString());
                play = false;
            }
        }
    }

    @Override
    public boolean isPlay() {
        return play;
    }

    @Override
    public void run(Track track) {
        if (play) {
            if (runLimit >= track.getLength()) {
                System.out.println("кот " + name + " преодолел препятствие " + track.toString());
            } else {
                System.out.println("кот " + name + " не преодолел препятствие " + track.toString());
                play = false;
            }
        }
    }

    @Override
    public String toString() {
        return "Кот" + name;
    }
}
