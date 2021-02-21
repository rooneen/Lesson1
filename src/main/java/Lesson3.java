import java.util.Scanner;

public class Lesson3 {

    public static void main(String[] args) {

        //Создать переменные всех пройденных типов данных

        byte a = 120;
        short b = 15155;
        int c = 444555255;
        long d = 515622611;
        float e = 56.25f;
        double db = 225.36;
        char ch = 'u';
        boolean bu = true;

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





}
