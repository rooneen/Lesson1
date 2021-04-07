package ru.geekbrains.Lesson13;

public class App04 {

    public static void main(String[] args) {
        final App04 app = new App04();
        app.random();
    }

    private void random() {
        final Runnable runnable = () -> {
            final String name = Thread.currentThread().getName();
            System.out.printf("Поток %s начал работу\n", name);
            double sum = 0;
            for (int i = 0; i < 100; i++) {
                sum += Math.random() * 5;
            }
            System.out.printf("Поток %s закончил работу, sum = %f\n", name, sum);
        };

        for (int i = 0; i < 5; i++) {
            new Thread(runnable).start();
        }

        // Как видим, порядок завершения потоков не соответствует порядку начала их работы. Это
        // происходит потому, что JVM может произвольно переключать потоки - останавливать одни
        // и передавать процессорное время другим потокам. Если у нас один процессор, то время
        // будет распределено между потоками (можем считать, что это распределение носит
        // случайный характер).
        // Для многопроцессорных систем, логика будет той же - то есть создавая 5 потоков в
        // 2-х процессорной системе, мы распределяем процессорное время между этими потоками
    }

}