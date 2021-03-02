package ru.geekbrains.HomeWork3;

public class Lessons1 {
    /*public static void main(String[] args) {
        swap3(3,4);  //заменить числа а и в местами
    }

    public static void swap1(int a, int b) {
        System.out.printf("a = %d, b = %d;\n", a, b); //  \n перевод строки
        int c = a;
        a = b;
        b = c;
        System.out.printf("a = %d, b = %d;\n", a, b);

    }

    public static void swap2(int a, int b) {
        System.out.printf("a = %d, b = %d;\n", a, b); //  \n перевод строки
        a += b; // a = a + b = 3 + 4 = 7
        b = a - b;  // b = 7 - 4 = 3
        a -= b;  // a = a - b = 7 - 3 = 4
        System.out.printf("a = %d, b = %d;\n", a, b);

    }

    public static void swap3(int a, int b) {
        System.out.printf("a = %d, b = %d;\n", a, b); //  \n перевод строки
        a ^= b;
        b ^= a;
        a ^= b;
        System.out.printf("a = %d, b = %d;\n", a, b);

    }


    // FizzBuzz!!!!!

    public static void main(String[] args) {
        fizzbuzz(3);
        fizzbuzz(5);
        fizzbuzz(9);
        fizzbuzz(15);
        fizzbuzz(17);
    }

    public static void fizzbuzz(int a) {
        if (a % 3 == 0 && a % 5 == 0) {
            System.out.println("fizzbuzz");
        } else if (a % 3 == 0) {
            System.out.println("fizz");
        } else if (a % 5 == 0) {
            System.out.println("buzz");
        }
    }

    public static void fizzbuzz(int a) {
        String res = "";
        if (a % 3 == 0) {
            res = "fizz";
        }
        if (a % 5 == 0) {
            res += "buzz";
        }
            System.out.println(res);

    }*/


    //  фибоначи 1 , 1, 2, 3, 5, 8, 13...

    /*public static void main(String[] args) {
        /*System.out.println(fib(1));
        System.out.println(fib(2));
        System.out.println(fib(3));
        System.out.println(fib(4));
        System.out.println(fib(7));
        System.out.println(fibRec(10));
    }

    /*public static long fib(int n) {
        if (n < 3) {
            return 1;
        }
        return fib(n - 1) + fib(n - 2);
    }


    public static long fibopt(int n) { // оптимальный метод
        if (n < 3) {
            return 1;
        }
        long previous = 1, next = 1, sum = 0;
        for (int i = 3; i <= n; i++) {
            sum = previous + next;
            previous = next;
            next = sum;
        }
        return sum;
    }*/

    /*public  static long fibRec(int n) {
        return fibRec(n, 0, 1);
    }

    public static long fibRec(int n, long a, long b) {
        if (n == 0) {
            return a;
        }
        if (n == 1) {
            return b;
        }
        return fibRec(n - 1, b, a + b);
    }*/


    /*public static void main(String[] args) {  //сложить числа 2345678
        System.out.println(count(123));
    }

    public static int count(int n) {
        int c = 0;
        while (n != 0) {
            int b = (n % 10);
            c += b;
            n = n / 10;
        }
        return c;
    }*/


    public static void main(String[] args) {    // узнать кол-во каждой буквы в тексте
        int[] abcs = count("dfggkajauhuhrsaa");
        for (char i = 0; i < abcs.length; i++) {
            if (abcs[i] != 0) {
                System.out.printf("%s встретились %d раз\n", i, abcs[i]);
            }
        }
    }

    public static int[] count(String s) {
        int[] c = new int[127];
        char[] chars = s.toCharArray();
        for (char ch : chars) {
            c[ch]++;
        }
        return c;
    }



}
