package ru.geekbrains.HomeWork3;

import java.util.Random;
import java.util.Scanner;

public class BullsCowsGame {
    public static void main(String[] args) {
        BullsCowsGame game = new BullsCowsGame();
        game.play();
    }

    public void play() {
        int[] guessNum = generateNum();
        Scanner sc = new Scanner(System.in);
        int step = 0;
        int bulls;
        do {
            int cows = 0;
            bulls = 0;
            String playerNum = sc.nextLine();
            for (int i = 0; i < 4; i++) {
                if (guessNum[i] == playerNum.charAt(i) - '0') {
                    bulls++;
                } else if (playerNum.contains(String.valueOf(guessNum[i]))) {
                    cows++;
                }
            }
            step++;
            System.out.printf("%d. Введено число %s, быков %d, коров %d. %s\n", step, playerNum, bulls, cows, bulls == 3 ? "Хороший ход!" : "");
        } while (bulls != 4);
        System.out.println("Угадал!");
    }

    private int[] generateNum() {
        Random rnd = new Random();
        int[] a = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        for (int i = 0; i < 100; i++) {
            int i1 = rnd.nextInt(10);
            int i2 = rnd.nextInt(10);
            int c = a[i2];
            a[i2] = a[i1];
            a[i1] = c;
        }
        return new int[]{a[0], a[1], a[2], a[3]};
    }
}
