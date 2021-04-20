package ru.geekbrains.Lesson14.streamapi;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class App06 {
    public static void main(String[] args) {
        final OwnerGenerator ownerGenerator = new OwnerGenerator();
        final List<Owner> owners = ownerGenerator.generate();

        // Преобразование в Map

        // Используем имя в качестве ключа, и знак зодиака в качестве значения
        final Map<String, Zodiac> zodiacByOwnerName = owners.stream().collect(Collectors.toMap(Owner::getName, Owner::getZodiac));
        zodiacByOwnerName.forEach((k, v) -> System.out.println(k + ": " + v));
        System.out.println();

        // можно и в обратную сторону, но возникнет проблема, если ключи дублируются
//        owners.stream().collect(Collectors.toMap(Owner::getZodiac, Owner::getName));
        // к счастью, выход есть - надо добавить функцию, которая объединить повторяющиеся значения
        final Map<Zodiac, String> namesByZodiac = owners.stream().collect(Collectors.toMap(Owner::getZodiac, Owner::getName, (a, b) -> a + "," + b));
        namesByZodiac.forEach((k, v) -> System.out.println(k + ": " + v));
        System.out.println();

        // Группировка
        // Задачу группировки по знаку зодиака можно решить и по другому, используя группировку
        final Map<Zodiac, Set<String>> namesByZodiacGrouping = owners.stream().collect(Collectors.groupingBy(Owner::getZodiac, Collectors.mapping(Owner::getName, Collectors.toSet())));
        namesByZodiacGrouping.forEach((k, v) -> System.out.println(k + ": " + v));
        System.out.println();

        // Сгруппируем питомцев по породам
        final Map<Breed, List<Pet>> petByBreed = owners.stream()
                .flatMap(owner -> owner.getPets().stream())
                .collect(Collectors.groupingBy(Pet::getBreed));
        petByBreed.forEach((k, v) -> System.out.println(k + ": " + v));
        System.out.println();

        // Подсчет количества животных одной породы
        final Map<Breed, Long> breedCount = owners.stream()
                .flatMap(owner -> owner.getPets().stream())
                .collect(Collectors.groupingBy(Pet::getBreed, Collectors.counting()));
        breedCount.forEach((k, v) -> System.out.println(k + ": " + v));
        System.out.println();

        // Подсчет среднего возраста питомцев по породам
        final Map<Breed, Double> breedAvg = owners.stream()
                .flatMap(owner -> owner.getPets().stream())
                .collect(Collectors.groupingBy(Pet::getBreed, Collectors.averagingDouble(Pet::getAge)));
        breedAvg.forEach((k, v) -> System.out.println(k + ": " + v));
        System.out.println();



    }
}