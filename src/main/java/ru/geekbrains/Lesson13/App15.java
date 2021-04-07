package ru.geekbrains.Lesson13;

import java.util.concurrent.atomic.AtomicInteger;

// Атомарные типы
public class App15 {

    public static void main(String[] args) {
        final AtomicInteger aInteger = new AtomicInteger(42);
//        final int i = aInteger.incrementAndGet();
        final int i1 = aInteger.accumulateAndGet(3, (x, y) -> x * y);
        System.out.println(i1);
    }

}