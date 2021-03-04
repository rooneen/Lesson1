package ru.geekbrains.HomeWork3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class HomeWork1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        do {
            Random r = new Random();
            int x = r.nextInt(10);
            int n;
            int b = 3; // кол - во попыток
            System.out.println("Отгадайте номер!\nУ Вас " + b + " попытки\nВведите цифру: от 0 до 9");

            for (int i = 1; i <= b; i++) {
                n = Integer.parseInt(br.readLine());

                if (n == x) {
                    System.out.println(n + " = " + x + " Вы выиграли!");
                    break;
                }
                else if (n > x) System.out.println(n + " Слишком большой. Введите еще раз.\nУ Вас осталось " + (3 - i) + " попытки");
                else if (n < x) System.out.println(n + " Слишком маленький. Введите еще раз.\nУ Вас осталось " + (3 - i) + " попытки");

                if (i == 3) System.out.println("Вы програли! Это номер : " + x);
            }

            System.out.println("Хотите сыграть ещё раз? 1 - Да / 0 - Нет");

            int repeat = Integer.parseInt(br.readLine());
            while ((repeat < 0) || (repeat > 1)) {
                System.out.println("Введите цифру: 1 - Да / 0 - Нет");
                repeat = Integer.parseInt(br.readLine());
            }

            if (repeat == 1) {
                System.out.println("Новая игра...");
            }
            else {
                System.out.println("Досвидания!");
                return;
            }
        } while (true);
    }
}


