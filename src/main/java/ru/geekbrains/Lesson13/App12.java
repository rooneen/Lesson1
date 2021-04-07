package ru.geekbrains.Lesson13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


// интерфейс Callable
public class App12 {
    private static final int SIZE = 10_000_000;
    private static final int PART_SIZE = 1_000_000;
    // Использование классов Thread и интерфейса Runnable не дает возможности
    // вернуть результат работы потока
    // Поэтому в Java 1.5 появился интерфейс Callable

    public static void main(String[] args) throws Exception {
        final CallableThread t = new CallableThread(new int[]{1, 2, 3, 4, 5});
        ExecutorService executor = Executors.newSingleThreadExecutor();
        final Future<Integer> future = executor.submit(t);
        final Integer s = future.get(); // результат вычисления

        // предположим, у нас есть большой массив, и мы хотим посчитать сумму
        // элементов этого массива. Можно разбить массив на несколько кусков и
        // считать сумму в несколько потоков

        long[] a = new long[SIZE];
        final Random rnd = new Random();
        for (int i = 0; i < SIZE; i++) {
            a[i] = rnd.nextInt();
        }

        // Сначала попробуем обойтись одним потоком
        long start = System.currentTimeMillis();
        final long sum = Arrays.stream(a).sum();
        System.out.println(System.currentTimeMillis() - start);

        System.out.println(sum);

        // Теперь посчитаем в несколько потоков
        start = System.currentTimeMillis();
        int len = a.length;
        final ArrayList<ArraySummator> summators = new ArrayList<>();

        for (int i = 0; i < len; i += PART_SIZE) {
            summators.add(new ArraySummator(a, i, Math.min(i + PART_SIZE, len)));
        }
        ExecutorService sumExecutor = Executors.newFixedThreadPool(SIZE / PART_SIZE);
        final List<Future<Long>> futures = sumExecutor.invokeAll(summators);

        final long sum1 = futures.stream().mapToLong(f -> {
            try {
                return f.get();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }).sum();
        System.out.println(System.currentTimeMillis() - start);

        System.out.println(sum1);

        sumExecutor.shutdown();
        executor.shutdown();
    }
}

class ArraySummator implements Callable<Long> {

    private final long[] a;
    private final int start;
    private final int end;

    ArraySummator(long[] a, int start, int end) {
        this.a = a;
        this.start = start;
        this.end = end;
    }

    @Override
    public Long call() throws Exception {
        return Arrays.stream(a).skip(start).limit(end - start).sum();
    }
}

class CallableThread implements Callable<Integer> {

    int[] a;

    public CallableThread(int[] a) {
        this.a = a;
    }

    @Override
    public Integer call() throws Exception {
        return Arrays.stream(a).sum();
    }
}