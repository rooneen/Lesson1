package ru.geekbrains.Lesson13;

import java.util.Arrays;

// потоки выполнения
// 1) процессы - фактически отдельное приложение со своим состоянием,
// изолированное от других процессов
// 2) поток (нить) - внутри приложения могут параллельно исполняться несколько потоков, каждый
// может обладать своим внутренним состоянием, но при этом имеет доступ к общим ресурсам
// приложения или к состоянию других потоков
// Параллельность не всегда означает одновременность испольнения. В однопроцессорных системах
// потоки делять процессорное время между собой, а управляет этим планировщик потоков
// В многопроцессорных системах, потоки могут выполняться одновременно на разных процессорах
//

public class App01 {
    // здесь запускается главный поток
    public static void main(String[] args) {
        final App01 app = new App01();
        // информацию о текущем потоке можно получить, если вызвать Thread.currentThread()
        app.printThreadInfo();
    }

    private void printThreadInfo() {
        System.out.println(Thread.currentThread().getName());
        System.out.println(Arrays.toString(Thread.currentThread().getStackTrace()));
    }
}