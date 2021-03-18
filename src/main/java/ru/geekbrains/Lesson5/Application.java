package ru.geekbrains.Lesson5;

public class Application {
    public static void main(String[] args) {
        Car c1 = new Car(); // переменная ссылочного типа
        c1.model = "FORD";
        c1.color = "Black";
        c1.fuelConsumption = 2;
        c1.fuelTankCapacity = 40;
        c1.fuelVolume = 6;

        Car c2 = new Car();
        c2.model = "Kia";
        c2.color = "Red";
        c2.fuelConsumption = 1.5;
        c2.fuelTankCapacity = 40;
        c2.fuelVolume = 10;

        System.out.printf("Модель %s, цвет %s, объем бака %f\n", c1.model, c1.color, c1.fuelTankCapacity);
        System.out.printf("Модель %s, цвет %s, объем бака %f\n", c2.model, c2.color, c2.fuelTankCapacity);

    }
}
