package ru.geekbrains.Lesson7.HomeWork2;

public class App {

    public static void main(String[] args) {
        App app = new App();
        app.feedCats();
    }

    public void feedCats() {
        Cat[] cats = {
                new Cat("dfgdfh", 10),
                new Cat("ddf", 7),
                new Cat("fgf", 5),
                new Cat("dftr", 14)
        };

        Plate plate = new Plate(25);
        cats[0].eat(plate);
        for (Cat cat : cats) {
            cat.eat(plate);
        }
    }

}
