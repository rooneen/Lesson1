package ru.geekbrains.Lesson6.HomeWork2;

public class Add {
    public static void main(String[] args) {
        Animal a = new Cat("MMm");
        Animal c = new Cat("Ccc");
        Animal d = new Dog("Ddd");

        a.run(200);
        a.swim(2);
        c.run(200);
        d.run(200);

        System.out.println(Animal.getCount());
        System.out.println(Cat.getCount());
        System.out.println(Dog.getCount());

    }
}
