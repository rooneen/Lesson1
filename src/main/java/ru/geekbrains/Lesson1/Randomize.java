package ru.geekbrains.Lesson1;

import java.util.Random;
import java.util.Scanner;

public class Randomize {



    public static void main(String[] args) {

        int s = 9; // кол - во загаданных чисел
        Random rand = new Random();
        int x = rand.nextInt(s);
        int d = 3; // кол - во попыток

        for (int i = 1; i <= d; i++) {
            System.out.println("Введите число от 0 до " + s + ": ");
            Scanner sc = new Scanner(System.in);
            int a = sc.nextInt();

            if (a > x){
                System.out.println("Вы ввели слишком большое число. Осталось " + (d - i) + " попыток");
            } else if (a < x){
                System.out.println("Вы ввели слишком маленькое число. Осталось " + (d - i) + " попыток");
            } else {
                System.out.println("Вы ввели правильное число.");
                break;
            }

        }

    }
   
}
