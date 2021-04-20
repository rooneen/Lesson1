package ru.geekbrains.Lesson14.streamapi;

import java.util.Optional;

// Optional
public class App05 {
    // рассмотрим пример использования Optional

    public static void main(String[] args) {
        // Предположим, у нас есть объект Car. При этом мы вообще не уверены, что
        // двигатель имеет цилиндр или автомобиль имеет двигатель или инстанс класса
        // Car не равен null.
        final Car car1 = new Car(new Engine(new Cylinder(1.5)));
        final Car car2 = new Car(new Engine(new Cylinder(null)));
        final Car car3 = new Car(new Engine(null));
        final Car car4 = new Car(null);
        final Car car5 = null;

        // Предоположим, нам надо получить диаметр цилиндра у двигателя.
        // Без Optional пришлось бы делать так
        Double diameter;
        if (car1 != null &&
                car1.getEngine() != null &&
                car1.getEngine().getCylinder() != null &&
                car1.getEngine().getCylinder().getDiameter() != null) {
            diameter = car1.getEngine().getCylinder().getDiameter();
        } else {
            diameter = 0d;
        }

        // С Optional будет чуть приятнее
        final Double cylinderDiameter = Optional.ofNullable(car3) // если мы полагаем, что car может быть равен null
                .map(Car::getEngine)
                .map(Engine::getCylinder)
                .map(Cylinder::getDiameter)
                .orElse(0d);
    }

}

class Car {
    private Engine engine;

    public Car(Engine engine) {
        this.engine = engine;
    }

    public Engine getEngine() {
        return engine;
    }
}

class Engine {
    public Engine(Cylinder cylinder) {
        this.cylinder = cylinder;
    }

    private Cylinder cylinder;

    public Cylinder getCylinder() {
        return cylinder;
    }
}

class Cylinder {
    private Double diameter;

    public Cylinder(Double diameter) {
        this.diameter = diameter;
    }

    public Double getDiameter() {
        return diameter;
    }
}