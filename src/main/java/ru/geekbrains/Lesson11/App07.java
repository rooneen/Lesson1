package ru.geekbrains.Lesson11;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class App07 {
    // поговорим о wildcard

    public static void main(String[] args) {
        // вспомним пример из начала лекции
        final App07 app07 = new App07();
        final List<Snake> snakes = Arrays.asList(
                new Snake("Каа", 5),
                new Snake("Нагайна", 5)
        );
//        app07.feedAnimals(snakes); // ошибка, т.к. Collection<Animal> != Collection<Snake>
        // что делать в таких случаях?
        // переписать метод...
        app07.feedAnimals(snakes); // теперь все работает
// ? называется wildcard
        // можно создать класс, параметризованный только wildcard
        final Zoo<?> zoo = new Zoo<>();
        // равносильно созданию без параметризации, но безопаснее
//        zoo.encage(new Leon("Mufasa", 10)); // не работает
        // работает, но не безопасно, т.к. можно положить любой объект
        final Zoo zoo1 = new Zoo();
        zoo1.encage(new Leon("Mufasa", 10));

        // можно и сразу создать класс, параметризованный с wildcard
        final Zoo<? extends Animal> extendsZoo = new Zoo<>();
//        extendsZoo.encage(new Elephant("Джимбо", 3)); // не работает, т.к. небезопасно
        // но это будет работать, если создать класс, ограниченный сверху
        Zoo<? super Animal> superZoo = new Zoo<>();
        superZoo.encage(new Elephant("Джимбо", 3)); // все работает
    }

    private void feedAnimals(Collection<? extends Animal> animals) {
        animals.forEach(Animal::feed);
    }

}