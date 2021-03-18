package ru.geekbrains.Lesson6.HomeWork;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double distRun1 = Math.random() * 200;
        double distSwim1 = Math.random() * 0;
        Animals cat = new Cat(distRun1, distSwim1);

        double distRun2 = Math.random() * 500;
        double distSwim2 = Math.random() * 10;
        Animals dog = new Dog(distRun2, distSwim2);

        System.out.println("Кошка сможет пробежать: 200 метров\nСобака сможет пробежать: 500 метров");

        System.out.println("Введите дистанцию для бега:");
        double distance = scanner.nextDouble();

        System.out.println("Кошка пытается пробежать (" + distance + "). Пробегает: " + cat.run(distRun1) + " метров");
        System.out.println("Собака пытается пробежать (" + distance + "). Пробегает: " + dog.run(distRun2) + " метров");
        System.out.println("\n****************\n");

        System.out.println("Кошка сможет проплыть: 0 метров\nСобака сможет проплыть: 10 метров");

        System.out.println("Введите дистанцию плавания для собаки:");
        double distance2 = scanner.nextDouble();

        System.out.println("Собака пытается проплыть (" + distance2 + "). Проплывает: " + dog.swim(distSwim2) + " метров");
    }
}
