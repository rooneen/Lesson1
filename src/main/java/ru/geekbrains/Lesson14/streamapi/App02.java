package ru.geekbrains.Lesson14.streamapi;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

// создание стримов
public class App02 {

    public static void main(String[] args) {
        final List<Integer> integers = Arrays.asList(1, 2, 3, 4);

        // чтобы получить объект Stream у коллекции, надо вызвать метод stream
        final Stream<Integer> integerStream = integers.stream();

        // получение стрима из списка значений
        final Stream<Integer> intStream = Stream.of(1, 5, 6, 7, 8);

        // получение Stream у массива
        final LongStream longStream = Arrays.stream(new int[]{1, 4, 6, 3, 5}).asLongStream();
        final Stream<String> stringStream = Arrays.stream(new String[]{"aa", "bb", "cc"});

        // использование генератора
        final Stream<Double> doubleStream = Stream.generate(Math::random) // список значений будет бесконечным
                .limit(100); // ограничимся 100 первыми числами

        // Использование билдера
        final Stream<String> buildedStream = Stream.<String>builder().add("One").add("Two").add("Three").build();

        // Для числовых типов имеются оптимизированные стримы
        final IntStream range = IntStream.range(1, 10); // список значений от 1 до 9

        // еще один способ получения стрима случайных значений
        final IntStream rndInts = new Random().ints(5, 0, 11);

        final LongStream fibStream = Stream.iterate(
                new long[]{1, 0}, // начальное значение
                f -> new long[]{f[0] + f[1], f[0]} // функция для преобразования
        )
                .mapToLong(f -> f[0])
                .limit(10) // список бесконечный, поэтому возьмем только 10 первых значений
                ;
    }
}