package ru.geekbrains.Lesson8.HomeWork2;

public class Wall implements Barrier {

    private int height;

    public Wall(int height) {
        this.height = height;
    }

    @Override
    public void overcome(Player player) {
        player.jump(this);
    }

    @Override
    public String toString() {
        return "Стена высотой " + height + " матров";
    }

    public int getHeight() {
        return height;
    }
}
