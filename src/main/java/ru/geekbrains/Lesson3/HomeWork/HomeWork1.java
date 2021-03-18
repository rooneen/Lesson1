package ru.geekbrains.Lesson3.HomeWork;

import java.util.Random;
import java.util.Scanner;

public class HomeWork1 {
    /*public static void main(String[] args) throws IOException {
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
    }*/

    public static final String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot",
            "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea",
            "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};

    public static void main(String[] args) {
        startGame();
    }

    private static void startGame() {
       do {
           play();
       } while (playAgain());
    }

    private static void play() {
        char[] template = "#############".toCharArray();
        Random rnd = new Random();
        String quessWord = words[rnd.nextInt(words.length)];
        Scanner sc = new Scanner(System.in);
        String userWord;

        do {
            System.out.printf("Введите слово (подсказка '%s'): ", String.valueOf(template));
            userWord = sc.nextLine();
            int min = Math.min(userWord.length(), quessWord.length());
            for (int i = 0; i < min; i++) {
                if (quessWord.charAt(i) == userWord.charAt(i)) {
                    template[i] = quessWord.charAt(i);
                } else {
                    template[i] = '#';
                }
                
            }
        } while (!quessWord.equals(userWord));
        System.out.println("Поздравляю Вы выиграли!");

    }

    private static boolean playAgain() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Хотите сыграть еще?");
        int answer = sc.nextInt();
        return answer == 1;

    }


}



