package ru.geekbrains.lesson1;

import java.util.Scanner;

public class Lesson3 {

    public static void main(String[] args) {

        //Создать переменные всех пройденных типов данных

        byte a = 120;
        short b = 15155;
        int c = 444555255;
        long d = 51562444662611L;
        float e = 56.25f;
        double db = 225.36;
        char ch = 'u';
        boolean bu = true;

    }

        //метод a + b >10 b <20

        public static boolean task10and20(int a, int b){
            if (a + b >= 10 && a + b <= 20) {
                return true;
            } else {
                return false;
            }

        }

    {

        //Написать метод вычисляющий выражение a * (b + (c / d)) и возвращающий результат,
        //где a, b, c, d – аргументы этого метода, имеющие тип float.

        float a = 12.5f;
        float b = 265.78f;
        float c = 3365.78f;
        float d = 7789.25f;
        float g = a * (b + (c / d));
        System.out.println(g);
    }



        // написать метод >0

    public static void isPositiveOrNegative(int a){
        if (a >= 0){
            System.out.println("true");
        } else {
            System.out.println("false");
        }


    }

        // написать метод <0

    public static boolean isNegative(int a){
        if (a < 0){
            return true;
        } return false;
    }


        // Hello World

    public static void greetings(String name){
        System.out.println("Hello " + " String name");

    }

    //2020 делится на 4 и не делится на 100


    public static void year(int year){
        if (year % 4 == 0 && year % 100 == 0 && year % 400 == 0){
            System.out.println("Год не високосный");
        } else if (year % 4== 0){
            System.out.println("Год високосный");
        } else {
            System.out.println("Год не високосный");
        }
    }


}
