package ru.geekbrains.Lesson13;

// Дедлоки
public class App08 {
    // Рассмотрим, вероятный сценарий появления дедлока
    // - предположим есть два потока (их может быть и больше)
    // - поток 1 захватывает монитор А
    // - поток 2 захватывает монитор В
    // - потоку 1 требуется монитор В, а потоку 2 требуется монитор А, в результате
    // возникает взаимная блокировка потоков и каждый ждет освобождения монитора

    public static void main(String[] args) {
        Object a = new Object();
        Object b = new Object();

        Thread1 t1 = new Thread1(a, b);
        Thread2 t2 = new Thread2(a, b);

        t1.start();
        t2.start();
    }

}

class Thread1 extends Thread {
    private final Object a;
    private final Object b;

    Thread1(Object a, Object b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public void run() {
        synchronized (a) {
            System.out.println("Монитор А занят потоком 1");
            try {
                Thread.sleep(1000);
//                a.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            synchronized (b) {
                System.out.println("Монитор B занят потоком 1");
            }
        }
    }
}

class Thread2 extends Thread {
    private final Object a;
    private final Object b;

    Thread2(Object a, Object b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public void run() {
        synchronized (b) {
            System.out.println("Монитор B занят потоком 2");
            try {
                Thread.sleep(1000);
//                b.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (a) {
                System.out.println("Монитор A занят потоком 2");
            }
        }
    }
}