package ru.geekbrains.Lesson4;

import java.util.Random;
import java.util.Scanner;

public class BattleshipGame {
    private static final int EMPTY = 0;
    private static final int SHIP = 1;
    private static final int HIT_SHIP = -1;
    private static final int HIT = -2;

    public static void main(String[] args) {
        System.out.println("" +
                "            Привет!\n" +
                "     Сыграем в морской бой!\n");
        do {
            int size = Integer.parseInt(args[0]);
            int ships = Integer.parseInt(args[1]);
            play(size, ships);
        } while (isPlayAgain());
    }

    private static boolean isPlayAgain() {
        Scanner sc = new Scanner(System.in);
        int answer;
        do {
            System.out.print("Игра окончена.\nСыграем еще (0 - нет / 1 - да)? ");
            answer = sc.nextInt();
        } while (answer != 1 && answer != 0);
        return answer == 1;
    }

    private static void play(int size, int ships) {
        int[][] board = generateBoard(size, ships);
        int hits = 0;
        while (hits < ships) {
            printBoard(board);
            boolean isHit = makeMove(board);
            if (isHit) {
                System.out.println("\nПопал!");
                ++hits;
            } else {
                System.out.println("\nПромазал!");
            }
        }
    }

    private static boolean makeMove(int[][] board) {
        int row, line;
        int size = board[0].length;
        System.out.print("\nВаш ход: ");
        Scanner sc = new Scanner(System.in);
        do {
            String move = sc.nextLine().toUpperCase();
            row = move.charAt(0) - 'A';
            line = Integer.parseInt(move.substring(1)) - 1;
        } while (row < 0 || row >= size || line < 0 || line >= size);
        if (board[line][row] == SHIP) {
            board[line][row] = HIT_SHIP;
            return true;
        }
        board[line][row] = HIT;
        return false;
    }

    private static int[][] generateBoard(int size, int ships) {
        int[][] board = new int[size][size];
        Random rnd = new Random();
        for (int i = 0; i < ships; i++) {
            int i1;
            int i2;
            do {
                i1 = rnd.nextInt(size);
                i2 = rnd.nextInt(size);
            } while (board[i1][i2] == SHIP);
            board[i1][i2] = SHIP;
        }
        return board;
    }

    private static void printBoard(int[][] board) {
        System.out.print("    ");
        for (char i = 'A'; i < board[0].length + 'A'; i++) {
            System.out.print(" " + i + " ");
        }
        System.out.println();
        int i = 0;
        for (int[] lines : board) {
            System.out.printf("%3d ", ++i);
            for (int cell : lines) {
                switch (cell) {
                    case EMPTY:
                        System.out.print(" . ");
                        break;
                    case SHIP:
                        System.out.print("[ ]");
                        break;
                    case HIT:
                        System.out.print(" x ");
                        break;
                    case HIT_SHIP:
                        System.out.print("[X]");
                        break;
                }
            }
            System.out.println();
        }
    }
}