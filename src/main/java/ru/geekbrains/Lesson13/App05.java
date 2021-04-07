package ru.geekbrains.Lesson13;

// методы потоков
public class App05 {
    public static void main(String[] args) throws InterruptedException {
        final App05 app = new App05();
        app.lookAtThreadMethods();
    }

    private void lookAtThreadMethods() throws InterruptedException {
        final Thread thread = new Thread(() -> {
            System.out.println("Привет из потока: " + Thread.currentThread().getName());
            try {
                Thread.sleep(10); // статический метод, который заставит поток заснуть на заданное количество миллисекунд
                Thread.yield(); // метод, который даст планировщику потоков рекомендацию переключится на другой поток (не факт, что будет выполнено)
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        thread.setName("Useless thread"); // можно задать имя потоку
        thread.start(); // запуск потока на выполнение
        // следует не путать методы run() и start(). Первый описывает то, что должно
        // происходить при запуске потока, а второй - запускает поток на параллельное
        // выполнение
        // Давайте убедимся в этом

        for (int i = 0; i < 5; i++) {
            new Thread(() -> System.out.println("Привет из потока: " + Thread.currentThread().getName())).run();
        }
        // Мы видим, что потоки стартуют последовательно, и имя потока всегда "main". Это значит,
        // что на самом деле, весь код выполняется в одном потоке

        while (thread.isAlive()) {
            System.out.println("Еще работаю");
        }; // можно проверить, что поток еще работает

        // устанавливает приоритет потоков (от 1 до 10). По большому счету, мало на что влияет
        thread.setPriority(1);

        // один поток может подождать завершения другого. В данном случае главный поток ждет
        // завершения потока thread
        thread.join();
        // можно вызвать с кол-вом миллисекунд, которое поток будет ждать завершения
        thread.join(5000);
        thread.join(5000, 100); // и даже наносекунд

        final Thread.State state = thread.getState();// позволяет получить состояние потока
    }

}