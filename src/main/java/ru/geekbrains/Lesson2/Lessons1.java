package ru.geekbrains.Lesson2;


public class Lessons1 {

    public static void main(String[] args) {
        //task(new int[]{7, 4, 1, 2, 4, 5, 7});
        System.out.println(task2_1(new int[]{1, 2, 3, 5, 1}));
        System.out.println(task2_1(new int[]{1, 2, 3, 5, 2}));


        int[] a = {1, 0, 1, 0, 0, 1};
        for (int i = 0; i < a.length; i++) {
            // a[i] = a[i] == 0 ? 1 : 0; короткий метод
            if (a[i] == 0) {
                a[i] = 1;
            } else {
                a[i] = 0;
            }

        }
        System.out.println(a[0] + " " + a[1] + " " + a[2] + " " + a[3] + " " + a[4] + " " + a[5]);
    }


    static void createArray() {
        int[] a = new int[8];

        for (int i = 0, j = 0; i < a.length; i++, j += 3) {
            a[i] = j;
            System.out.print(a[i] + " ");
        }
    }

    static void changeArray2() {
        int[] a = { 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 };
        for (int i = 0; i < a.length; i++) {
            if (a[i] <= 6) {
                a[i] = a[i] * 2;
            }
        }
        System.out.println(a[0] + " " + a[1] + " " + a[2] + " " + a[3] + " " + a[4] + " " + a[5]);
    }

    static void createArray2() {
        int length = 4  ; // длина массива

        int[][] arr = new int[length][length];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                arr[i][i] = 1;
                /*if ((i == j) || (i == length - 1 - j)) {
                arr[i][j] = 1;

                }*/
            }
        }

    }


    public static void task(int[] a) {
        if (a.length < 1) {
            return;
        }
        int min = a[0];
        int max = a[0];
        for (int i : a) {
            if (i < min) {
                min = i;
            }
            if (i > max) {
                max = i;
            }
        }
        System.out.printf("Максиальный элемент = %d, минимальный = %d", max, min);

    }

    public static boolean task2(int[] a) {
        for (int i = 0; i < a.length; i++) {
            int sum1 = 0, sum2 = 0;
            for (int j = 0; j < 1; j++) {
                sum1 += a[j];
            }
            for (int j = i; j < a.length; j++) {
                sum2 += a[j];
            }
            if (sum1 == sum2) {
                return true;
            }
        }
        return false;

    }


    public static boolean task2_1(int[] a) {
        int sum = 0;
        for (int i : a) {
            sum += i;
        }
        if (sum % 2 != 0) {
            return false;
        }
        sum /= 2;
        for (int i : a) {
            sum -= i;
            if (sum == 0) {
                return true;
            }
        }
        return false;
    }



}



