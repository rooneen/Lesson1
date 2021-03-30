package ru.geekbrains.Lesson8.HomeWork2;

public class Track implements Barrier {

    private int length;

    @Override
    public void overcome(Player player) {
        player.run(this);

    }

    public int getLength() {
        return length;
    }

    @Override
    public String toString() {
        return "==== Беговая дорожка длиной " + length + " метров =====";
    }

    public Track(int length) {
        this.length = length;
    }
}