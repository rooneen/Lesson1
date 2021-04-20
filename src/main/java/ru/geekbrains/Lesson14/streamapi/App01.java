package ru.geekbrains.Lesson14.streamapi;

import java.util.Random;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

// Функциональные интрефейсы и лямбды
public class App01 {
    public static void main(String[] args) {
        final Function<Integer, String> numToDay1 = new Function<Integer, String>() { // функция, принимает один тип, а возвращает другой
            @Override
            public String apply(Integer i) {
                switch (i) {
                    case 1:
                        return "Пн";
                    case 2:
                        return "Вт";
                    case 3:
                        return "Ср";
                    case 4:
                        return "Чт";
                    case 5:
                        return "Пт";
                    case 6:
                        return "Сб";
                    default:
                        return "Вс";
                }
            }
        };

        // то же самое можно записать через лямбду
        // функция, принимает один тип, а возвращает другой
        final Function<Integer, String> numToDay2 = i -> {
            switch (i) {
                case 1:
                    return "Пн";
                case 2:
                    return "Вт";
                case 3:
                    return "Ср";
                case 4:
                    return "Чт";
                case 5:
                    return "Пт";
                case 6:
                    return "Сб";
                default:
                    return "Вс";
            }
        };

        // Также можно создать функцию, принимающую два значения
        final BiFunction<String, String, Integer> biFunction1 = new BiFunction<String, String, Integer>() {
            @Override
            public Integer apply(String s, String s2) {
                return s.length() + s2.length();
            }
        };
        // то же самое, но лямбда
        final BiFunction<String, String, Integer> biFunction2 = (s, s2) -> s.length() + s2.length();

        // Следующий тип функционального интерфейса - предикат - похож на функцию, но всегда возвращает тип boolean
        final Predicate<Integer> isOdd = i -> i % 2 == 0;
        // В стандартной библиотеке Java есть и BiPredicate
        final BiPredicate<Integer, Integer> isSumOdd = (i, j) -> (i + j) % 2 == 0;

        // Supplier - ничего не принимает, но возвращает значение
        final Supplier<Long> rnd = () -> new Random().nextLong();

        // Consumer - принимает значение, но ничего не возвращает
        final Consumer<Integer> printDay = s -> {
            switch (s) {
                case 1:
                    System.out.println("Пн");
                case 2:
                    System.out.println("Вт");
                case 3:
                    System.out.println("Ср");
                case 4:
                    System.out.println("Чт");
                case 5:
                    System.out.println("Пт");
                case 6:
                    System.out.println("Сб");
                default:
                    System.out.println("Вс");
            }
        };

        // или вспомним, что у нас уже есть подходящая функция...
        final Consumer<Integer> printDay2 = s -> System.out.println(numToDay2.apply(s));

        // есть еще много чего - изучите самостоятельно в пакете java.util.function
    }
}