package ru.geekbrains.Lesson11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class App03 {

    // ковариантность и инвариантность
    public static void main(String[] args) {
        // Важной особенностью дженериков является то, что они инвариантны (в отличии от
        // массивов, которые ковариантны

        // Ковариантность массивов
        String[] strings = new String[2];
        Object[] objects = strings;  // valid, String[] is Object[] // массивы ковариантны
        objects[0] = 12; // Ковариантность вызывает проблемы (ошибка времени выполнения)

        // в отличии от массивов дженерики инвариантны
        List<String> stringList = new ArrayList<>(); // дженерики инвариантны
//        List<Object> objectList = stringList;  // ошибка времени компиляции
//        objectList.add(12);
        // То есть, в данном случае полимофизм не работает - мы не можем приравнять
        // коллекцию с наследниками к коллекции с родителями

        // Еще раз проговорим на другом примере
        // Если бы дженерики были инвариантны, то была бы возможна, например, такая запись:
//        List<Animal> animals = new ArrayList<Leon>(); // ошибка времени компиляции (инвариантность)
        // Но это работает с массивами
        Animal[] a = new Leon[5]; // ковариантность

        // Мешает ли нам инвариантность дженериков? Рассмотрим пример - метод,
        // который принимает на вход коллекцию с животными и кормит их
        final App03 app03 = new App03();
        final List<Animal> animals = Arrays.asList(
                new Snake("Каа", 5),
                new Leon("Симба", 3),
                new Elephant("Джимбо", 30)
        ); // эта коллекция параметризована общим предком всех животных - классом Animal
        app03.feedAnimals(animals);

        // Все работает прекрасно, пока мы не захотим создать, например, серпентариум
        final List<Snake> snakes = Arrays.asList(
                new Snake("Каа", 5),
                new Snake("Нагайна", 5)
        );
//        app03.feedAnimals(snakes); // ошибка, т.к. Collection<Animal> != Collection<Snake>

        // Но обращаю ваше внимание, что полиморфизм все также работает на методах,
        // напомню код с зоопарком
        final Zoo<Animal> animalZoo = new Zoo<>();
        animalZoo.encage(new Elephant("Джимбо", 50));
        animalZoo.encage(new Leon("Симба", 1));
        animalZoo.encage(new Snake("Каа", 1));

        // Параметризовывать можно не только классом, но и интерфейсом
        Zoo<Movable> movableZoo = new Zoo<>();
    }

    public void feedAnimals(Collection<Animal> animals) {
        animals.forEach(Animal::feed);
    }

}
