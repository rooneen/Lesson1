package ru.geekbrains.Lesson1;

import java.util.Scanner;

    public class Lesson4 {


        public static void main(String[] args) {


            Scanner scanner = new Scanner(System.in);
            int a = scanner.nextInt();
            int b = scanner.nextInt();


            //String s = (a + b >= 10 && a + b <= 20) ? "true" : "false";

            /*if (a + b >= 10 && a + b <= 20) {
                System.out.println(true);
            } else {
                System.out.println(false);
            }*/

            System.out.println(a + b >= 10 && a + b <= 20);

        }
    }
