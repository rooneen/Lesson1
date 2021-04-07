package ru.geekbrains.Lesson13;

// Теперь давайте заставим потоки что-то делать

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// создадим класс Counter, цель которого - выдавать уникальные номера
class Counter {
    private long count;

    public long getNextId() {
        return count++;
    }

    public long getCount() {
        return count;
    }
}

public class App06 {

    public static void main(String[] args) throws InterruptedException {
        final App06 app = new App06();
        app.work();
    }

    private void work() throws InterruptedException {
        // создадим два потока, которые будут запрашивать айдишники у одного счетчика
        Counter counter = new Counter();
        final Thread thread1 = new Thread(new MyRunnable(counter));
        final Thread thread2 = new Thread(new MyRunnable(counter));

        // запустим потоки
        thread1.start();
        thread2.start();

        // подождем завершения
        thread1.join();
        thread2.join();

        // получим значение счетчика
        System.out.println(counter.getCount());

        // Подобный эффект называется race condition и возникает при одновременном доступе из
        // нескольких потоков к одному ресурсу
        //
        // Чтобы запретить одновременный доступ к одному ресурсу, используется синхронизация
        // Один из типов синхронизации, встроенный в Java называется "монитор"
        // Монитор - это объект, который поток "захватывает". Другие потоки не смогут
        // обратится к этому блоку кода

        // рассмотрим синхронизацию на примере класса Counter

        class SyncCounter1 {
            private long count;
            private final Object monitor; // объект-монитор

            public SyncCounter1() {
                this.monitor = new Object();
            }

            public long getNextId() {
                synchronized (monitor) { // синхронизированный блок
                    return count++;
                }
            }

            // самом деле, необязательно объявлять специальный объект для
            // синхронизации - в качестве монитора может служить инстанс класса
            public long getNextId1() {
                synchronized (this) { // синхронизированный блок
                    return count++;
                }
            }

            // так же можно синхронизировать весь метод
            public synchronized long getNextId2() {
                return count++;
            }

            // есть варианты с использованием специальных видов классов из
            // пакета java.util.concurrency
            public synchronized long getNextId3() {
                Lock lock = new ReentrantLock();
                try {
                    lock.lock();
                    return count++;
                } finally {
                    lock.unlock();
                }
            }

            public long getCount() {
                return count;
            }
        }
    }
}

class MyRunnable implements Runnable {

    private final Counter counter;

    public MyRunnable(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5000; i++) {
            counter.getNextId();
        }
        // поток завершит работу после окончания метода run()
    }
}