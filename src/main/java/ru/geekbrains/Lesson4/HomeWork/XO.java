package ru.geekbrains.Lesson4.HomeWork;

import java.util.Random;
import java.util.Scanner;

public class XO {

    public static char[][] map;
    public static final int SIZE = 5;
    public static final int DOTS_TO_WIN = 3;

    public static final char DOT_EMPTY = '*';
    public static final char DOT_X = 'X';
    public static final char DOT_O = 'O';

    public static Scanner sc = new Scanner(System.in);
    public static Random rand = new Random();

    public static void main(String[] args) {

        initMap();
        printMap();
        while (true) {
                humanTurn();
                printMap();
            if (checkWin(DOT_X)) {
                System.out.println("Победил человек");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }
                aiTurn();
                printMap();
            if (checkWin(DOT_O)) {
                System.out.println("Победил компьютер");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }

        }
        System.out.println("Игра закончена");

    }

    public static void initMap() {
        map = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }

    public static void printMap () {
        for (int i = 0; i < SIZE + 1; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }


    public static void humanTurn() {
        int x, y;
        do {
            System.out.println("Введите координаты в формате  X Y");
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
        } while (isCellValid(x, y));
        map[y][x] = DOT_X;
    }

    public static boolean isCellValid(int x, int y) {
        if (x < 0 || x >= SIZE || y < 0 || y >= SIZE)
            return true;
        if (map[y][x] == DOT_EMPTY)
            return false;
        return true;
    }

    public static void aiTurn() {
        int x, y;
            do {
                x = rand.nextInt(SIZE);
                y = rand.nextInt(SIZE);
            } while (isCellValid(x, y));
        System.out.println("Компьютер пошёл в точку " + (x + 1) + " " + (y + 1));
        map[y][x] = DOT_O;
    }

    public static boolean checkWin(char dot) {
        for (int i = 0; i < 4; i++)
            if ((map[i][0] == dot && map[i][1] == dot &&
                    map[i][2] == dot && map[i][3] == dot && map[i][4] == dot) ||
                    (map[0][i] == dot && map[1][i] == dot &&
                            map[2][i] == dot && map[3][i] == dot && map[4][i] == dot))
                return true;
        if ((map[0][0] == dot && map[1][1] == dot &&
                map[2][2] == dot && map[3][3] == dot && map[4][4] == dot) ||
                (map[4][0] == dot && map[3][1] == dot && map[2][2] == dot && map[1][3] == dot &&
                        map[0][4] == dot ))
            return true;
        return false;
    }

    /*public static boolean checkWin(char symb) {
        if(map[0][0] == symb && map[0][1] == symb && map[0][2] == symb) return true;
        if(map[1][0] == symb && map[1][1] == symb && map[1][2] == symb) return true;
        if(map[2][0] == symb && map[2][1] == symb && map[2][2] == symb) return true;
        if(map[0][0] == symb && map[1][0] == symb && map[2][0] == symb) return true;
        if(map[0][1] == symb && map[1][1] == symb && map[2][1] == symb) return true;
        if(map[0][2] == symb && map[1][2] == symb && map[2][2] == symb) return true;
        if(map[0][0] == symb && map[1][1] == symb && map[2][2] == symb) return true;
        if(map[2][0] == symb && map[1][1] == symb && map[0][2] == symb) return true;
        return false;
    }*/

    public static boolean isMapFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_EMPTY)
                    return false;
            }
        }
        return true;
    }


}
