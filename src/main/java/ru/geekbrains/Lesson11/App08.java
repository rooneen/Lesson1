package ru.geekbrains.Lesson11;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class App08 {
    // Рассмотрим стандартный метод в классе Collections, который копирует одну коллекцию
    // в другую. Мы увидим, что в этом методе используется сразу оба ограничения extends и super
    // Collections.copy();
    //     public static <T> void copy(List<? super T> dest, List<? extends T> src) {
    // src - источник (Producer) - выдает данные
    // dest - потребитель (Consumer) - потребляет данные
    // Есть общий принцип, который можно запомнить с помошью мнемонического правила "PECS"
    // PE - Producer Extends (src)
    // CS - Consumer Super (dest)

    // Понятно, что исходная коллекция должна иметь возможность содержать
    // любые классы, унаследованные от базового типа

    // Почему же коллекция в которую мы копируем должна быть super?

    public static void main(String[] args) {

        // Попробуем скопировать из одного списка животных в другой
        List<Animal> src = Arrays.asList(
                new Elephant("Джимбо", 50),
                new Leon("Симба", 1),
                new Snake("Каа", 1)
        );
        List<Animal> dst = Arrays.asList(null, null, null); // контракт метода
        Collections.copy(dst, src);
        // Все работает, и мы можем вызвать метод feed на целевой коллекции
        dst.forEach(Animal::feed);

        // Теперь предположим, мы хотим вызвать наш метод для таких коллекций
        List<Leon> leons = Arrays.asList(new Leon("Simba", 2), new Leon("Mufasa", 5));
        List<Snake> snakes = Arrays.asList(null, null);

//        Collections.copy(snakes, leons); // ошибка! Нельзя скопировать львов в змей

        // Если бы для dest тоже стоял extends, то это привело бы к ошибке,
        // т.к. такой код компилировался бы и мы смогли бы скопировать львов в змей

        // Но это будет работать, для всех классов, которые лежат выше (либо равны)
        // по иерархии наследования, чем Leon
        // Что логично
        List<Leon> leonsDest = Arrays.asList(null, null);
        List<Animal> animalDest = Arrays.asList(null, null);
        List<Object> objDest = Arrays.asList(null, null);
        Collections.copy(leonsDest, leons);
        Collections.copy(animalDest, leons);
        Collections.copy(objDest, leons);
    }

}