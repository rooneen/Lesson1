package ru.geekbrains.Lesson13;

// остановка потоков-1
public class App09 {
    // До версии Java 1.2 методы suspend() и resume(), определенные в классе Thread,
    // использовались в программах для приостановки и возобновления потоков исполнения. Тем не
    // менее пользоваться ими не рекомендуется по следующей причине: метод suspend() способен
    // порождать серьезные системные сбои. Допустим, что поток исполнения получил блокировки для
    // очень важных структур данных. Если в этот момент приостановить исполнение данного потока,
    // блокировки не будут сняты. Другие потоки исполнения, ожидающие эти ресурсы, могут оказаться
    // взаимно блокированными.
    // Метод resume() также не рекомендован к употреблению. И хотя его применение не вызовет
    // особых осложнений, тем не менее им нельзя пользоваться без метода suspend(), который
    // его дополняет.
    // Метод stop() также объявлен устаревшим, потому что он может послужить причиной серьезных
    // системных сбоев. Допустим, поток выполняет запись в критически важную структуру данных и
    // успел произвести лишь частичное ее обновление. Если его остановить в этот момент,
    // структура данных может оказаться в поврежденном состоянии

    // Для остановки потока можно использовать тот факт, что поток заканчивает свою работу
    // когда выходит из метода run()

    public static void main(String[] args) {
        System.out.println("Main thread started...");
        MyThread thread = new MyThread();
        new Thread(thread).start();
        try {
            Thread.sleep(1100);
            thread.disable();
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Thread has been interrupted");
        }
        System.out.println("Main thread finished...");
    }
}

class MyThread implements Runnable {

    private boolean active;

    void disable() {
        active = false;
    }

    MyThread() {
        active = true;
    }

    public void run() {

        System.out.printf("%s started... \n", Thread.currentThread().getName());
        int counter = 1; // счетчик циклов
        while (active) {
            System.out.println("Loop " + counter++);
            try {
                Thread.sleep(400);
            } catch (InterruptedException e) {
                System.out.println("Thread has been interrupted");
            }
        }
        System.out.printf("%s finished... \n", Thread.currentThread().getName());
    }
}