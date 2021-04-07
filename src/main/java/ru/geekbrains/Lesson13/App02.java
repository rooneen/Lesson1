package ru.geekbrains.Lesson13;

// создание потоков
public class App02 {

    // 1) создать класс, унаследованный от Thread и переопределить метод run
    class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("Привет из потока: " + getName());
        }
    }

    private void createThread1() {
        final MyThread myThread1 = new MyThread();
        final MyThread myThread2 = new MyThread();
        final MyThread myThread3 = new MyThread();
        // чтобы запустить поток на параллельное выполнение, надо вызвать метод
        // start() (не run()!!!)
        myThread1.start();
        myThread2.start();
        myThread3.start();
        // обратите внимание, что нет жесткого порядка вывода, т.к. каждый поток
        // выполняется параллельно

        // запустим 10 потоков и убедимся, что их выполнение носит случайный характер
        for (int i = 0; i < 10; i++) {
            new MyThread().start();
        }
        System.out.println(Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        final App02 app = new App02();
        app.createThread1();
    }
}
