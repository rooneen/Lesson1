package ru.geekbrains.Lesson13;

// остановка потоков-2
public class App10 {
    // Еще один способ вызова завершения или прерывания потока представляет метод interrupt().
    // Вызов этого метода устанавливает у потока статус, что он прерван. Сам метод возвращает
    // true, если поток может быть прерван, в ином случае возвращается false.
    //
    // При этом сам вызов этого метода НЕ завершает поток, он только устанавливает статус:
    // в частности, метод isInterrupted() класса Thread будет возвращать значение true.
    // Мы можем проверить значение возвращаемое данным методом и прозвести некоторые действия.
    public static void main(String[] args) {
        System.out.println("Main thread started...");
        InterruptedThread t = new InterruptedThread("InterruptedThread");
        t.start();
        try {
            Thread.sleep(50);
            t.interrupt();
            Thread.sleep(50);
        } catch (InterruptedException e) {
            System.out.println("Thread has been interrupted");
        }
        System.out.println("Main thread finished...");
    }


}

class InterruptedThread extends Thread {

    InterruptedThread(String name) {
        super(name);
    }

    public void run() {

        System.out.printf("%s started... \n", Thread.currentThread().getName());
        int counter = 1; // счетчик циклов
        while (!isInterrupted()) {
            System.out.println("Loop " + counter++);
        }
        System.out.printf("%s finished... \n", Thread.currentThread().getName());
    }
}
