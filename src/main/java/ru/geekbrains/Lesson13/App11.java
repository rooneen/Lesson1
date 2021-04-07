package ru.geekbrains.Lesson13;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

// Executor services
public class App11 {
    // Создание потока - дорогостоящая операция, поэтому испльзуют разного рода пулы
    // потоков, которые способны заранее создавать потоки, кешировать их и еще как-то
    // управлять ими

    // Существует несколько типов ExecutorService, которые можно создать через класс Executors.

    // newSingleThreadExecutor() создает пул в котором только один рабочий поток, то есть он
    // может одновременно исполнять только одну задачу, но при каждом запуске не будет
    // создавать новых потоков.
    //
    // newFixedThreadPool() создает пул с фиксированным количеством потоков, в примере ниже
    // можно запустить одновременно выполнение не более 10 задач.
    //
    // newCachedThreadPool() создает пул, который может автоматически расширяться, если
    // ему дать задачу и у него будут свободные потоки, пул отдаст задачу одному из таких
    // потоков, если же в пуле свободных потоков нет, он создаст и запустит новый. Минусом
    // такого подхода является то, что у cachedThreadPool нет верхней границы, и при
    // высокой частоте появления новых задач он потенциально может создавать огромное
    // количество потоков, пока не закончатся системные ресурсы

    public static void main(String[] args) {
        ExecutorService executorService1 = Executors.newSingleThreadExecutor();
        ExecutorService executorService2 = Executors.newFixedThreadPool(5);
        ExecutorService executorService3 = Executors.newCachedThreadPool();

        // Для старта потока, следует вызвать метод execute() или submit()
    }

    void userExecutors1() {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        executorService.execute(() -> System.out.println("Асинхронная задача"));
        executorService.shutdown(); // использование экзекутора следует завершить таким образом
    }

    void userExecutors2() throws Exception {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Future<?> future = executorService.submit(() -> System.out.println("Асинхронная задача"));
        future.get();  // вернет null если задача завершилась корректно
        executorService.shutdown();
    }
}
