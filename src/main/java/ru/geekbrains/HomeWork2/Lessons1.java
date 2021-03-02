package ru.geekbrains.HomeWork2;


public class Lessons1 {

    public static void main(String[] args) {

        int[] a = {1, 0, 1, 0, 0, 1};
        for (int i = 0; i < a.length; i++) {
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
        int length = 4  ; // length of array

        int[][] arr = new int[length][length];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if ((i == j) || (i == length - 1 - j)) {
                    arr[i][j] = 1;
                }
            }
        }

    }

}



