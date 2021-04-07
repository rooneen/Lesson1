package ru.geekbrains.Lesson13;

// сравнение double и float
// наследование от Comparable
public class App07 {

    // Поговорим еще о некоторых важных методах, используемых для многопоточного
    // программирования.
    // Эти методы располагаются в классе Object, а значит доступны для любого класса Java

    // void wait() - освобождает монитор и переводит вызывающий поток в состояние ожидания. В
    // результате синхронизированный метод будет поставлен на паузу и будет ждать, пока его
    // не разбудит другой поток, вызвав метод notify() или notifyAll()
    // void notify() - возобновляет работу потока, у которого был вызван метод wait()
    // void notifyAll() - возобновляет работу всех потоков, у которых был вызван wait()

    // Для понимания того, как работают эти методы, рассмотрим простое приложение

    public static void main(String[] args) throws InterruptedException {
        final House house = new House();
        final PizzaDelivery pizzaDelivery = new PizzaDelivery(house);
        final PizzaEater pizzaEater = new PizzaEater(house);

        pizzaEater.start();

        pizzaDelivery.start();

    }
}

class House {
    private boolean pizzaArrived;

    public void arrived() {
        System.out.println("Pizza delivered!");
        pizzaArrived = true;
    }

    public boolean isPizzaArrived() {
        return pizzaArrived;
    }
}

class PizzaDelivery extends Thread {
    private final House house;

    public PizzaDelivery(House house) {
        this.house = house;
    }

    @Override
    public void run() {
        synchronized (house) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            house.arrived();
            house.notifyAll();
        }
    }
}

class PizzaEater extends Thread {
    private final House house;

    public PizzaEater(House house) {
        this.house = house;
    }

    @Override
    public void run() {
        synchronized (house) {
            while (!house.isPizzaArrived()) {
                System.out.println("No pizza at home, we need to wait :(");
                try {
                    house.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Yum-yum...");
        }
    }

}
