package ru.geekbrains.Lesson11;

import java.util.ArrayList;
import java.util.List;

public class App05 {
    public static void main(String[] args) {
        // В текущей реализации мы можем посадить в клетку любой объект
        final Zoo<Integer> integerZoo = new Zoo<>();
        // Хотя зоопарк предназначен для содержания животных
        // хорошо было бы ограничить типы значений, которые может принимать зоопарк
        // Это возможно, для этого служит ключевое слово extends
    }

}

// теперь положить в этот класс можно только класс Animal и его дочерние типы
// ограничивать тип можно и интерфейсом
// можно указать несколько интерфейсов, но тольк один класс
// ограничения работают как "И"
class AnimalZoo<T extends Animal & Movable> {
    private final List<T> animals;

    public AnimalZoo() {
        animals = new ArrayList<>();
    }

    public boolean encage(T animal) {
        return animals.add(animal);
    }

    public T release(T animal) {
        if (animals.contains(animal)) {
            animals.remove(animal);
            return animal;
        }
        return null;
    }

    public static <A extends Animal & Movable> AnimalZoo<A> create() {
        return new AnimalZoo<A>();
    }

    public static <A extends Animal & Movable> boolean encage(AnimalZoo<A> zoo, A animal) {
        return zoo.encage(animal);
    }
}
