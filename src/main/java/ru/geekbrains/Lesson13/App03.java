package ru.geekbrains.Lesson13;

// создание потоков
public class App03 {
    // 1) создать класс, унаследованный от интерфейса Runnable и переопределить метод run
    class MyRunnable implements Runnable {
        @Override
        public void run() {
            System.out.println("Привет из потока: " + Thread.currentThread().getName());
        }
    }

    private void createThread2() {
        // Теперь можно создать объект типа Thread и передать ему наш класс MyRunnable
        // в конструкторе
        final Thread myThread1 = new Thread(new MyRunnable());
        final Thread myThread2 = new Thread(new MyRunnable());
        final Thread myThread3 = new Thread(new MyRunnable());
        // чтобы запустить поток на параллельное выполнение, надо вызвать метод
        // start() (не run()!!!)
        myThread1.start();
        myThread2.start();
        myThread3.start();
        // обратите внимание, что нет жесткого порядка вывода, т.к. каждый поток
        // выполняется параллельно

        // Также можно создать анонимный класс
        Thread myThread4 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Привет из потока: " + Thread.currentThread().getName());
            }
        });

        // Или (начиная с Java 8) сделать это через лямбду
        Thread myThread5 = new Thread(() -> System.out.println("Привет из потока: " + Thread.currentThread().getName()));

        // результат во всех случаях будет одинаковым

    }

    public static void main(String[] args) {
        final App03 app = new App03();
        app.createThread2();
    }

}