package ru.geekbrains.Lesson8.HomeWork2;

import javax.sound.midi.Track;
import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        App app = new App();
        app.start();
    }

    private void start() {
        Player[] players = {
                new Cat("gggg",10,3),
                new Cat("hhhh",9,2),
                new Cat("jjjj",11,4),
                new Cat("dddd",6,1)
        };

        Barrier[] barriers = {
                //new Track(5),
                new Wall(3),
                new Wall(5),

        };

        for (Barrier barrier : barriers) {
            System.out.println("Игроки приступают к преодолению препятствия " + barrier);
            for (Player player : players) {
                barrier.overcome(player);
            }
        }

        System.out.println("Соревнования закончены! Список победителей: ");
        Arrays.stream(players)
                .filter(Player::isPlay)
                .forEach(System.out::println);
    }
}
