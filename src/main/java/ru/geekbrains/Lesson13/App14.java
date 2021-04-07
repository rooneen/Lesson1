package ru.geekbrains.Lesson13;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

// Синхронайзеры
public class App14 {

    public static void main(String[] args) {
        // Семафор - используется для ограничения потоками доступа к ресурсам
        final Semaphore semaphore = new Semaphore(2);
        // Вырожденный случай семафора - монитор, там количество permits == 1
        // Для получения доступа используется метод acquire(), для освобождения – release()
        // пример приведен в методичке

        // CountDownLatch позволяет потоку ожидать завершения операций, выполняющихся в
        // других потоках. Режим ожидания запускается методом await(). При создании
        // объекта определяется количество требуемых операций, после чего уменьшается при
        // вызове метода countDown(). Как только счетчик доходит до нуля, с ожидающего
        // потока снимается блокировка.
        final CountDownLatch countDownLatch = new CountDownLatch(5);

        // CyclicBarrier выполняет синхронизацию заданного количества потоков в одной точке.
        // Как только заданное количество потоков заблокировалось (вызовами метода await()),
        // с них одновременно снимается блокировка
        final CyclicBarrier cyclicBarrier = new CyclicBarrier(3);


    }

}