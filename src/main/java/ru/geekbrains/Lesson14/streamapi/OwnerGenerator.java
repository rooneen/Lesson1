package ru.geekbrains.Lesson14.streamapi;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class OwnerGenerator {
    private final Owner[] OWNERS = {
            new Owner("Rubeus Hagrid", Zodiac.Sagittarius),
            new Owner("Minerva McGonagall", Zodiac.Libra),
            new Owner("Lord Voldemort", Zodiac.Capricorn),
            new Owner("Ron Weasley", Zodiac.Pisces),
            new Owner("Fred Weasley", Zodiac.Aries),
            new Owner("Georg Weasley", Zodiac.Aries),
            new Owner("Albus Dumbledore", Zodiac.Virgo),
            new Owner("Hermione Granger", Zodiac.Virgo),
            new Owner("Severus Snape", Zodiac.Capricorn),
            new Owner("Draco Malfoy", Zodiac.Gemini),
            new Owner("Ginny Weasley", Zodiac.Leo),
            new Owner("Harry Potter", Zodiac.Leo),
            new Owner("Neville Longbottom", Zodiac.Leo),
    };

    private final String[] PET_NAMES = {
            "TREVOR THE TOAD",
            "PYGMY PUFF",
            "SCABBERS",
            "FLUFFY",
            "NAGINI",
            "FANG",
            "CROOKSHANKS",
            "HEDWIG",
            "BUCKBEAK",
            "FAWKES"
    };

    private final Breed[] breeds = Breed.values();

    public List<Owner> generate() {
        final Random rnd = new Random();
        return Arrays.stream(OWNERS)
                .peek(owner -> {
                    for (int i = 0; i < rnd.nextInt(5); i++) {
                        owner.add(new Pet(breeds[rnd.nextInt(breeds.length)],
                                PET_NAMES[rnd.nextInt(PET_NAMES.length)],
                                rnd.nextInt(10) + 1));
                    }
                }) // добавим питомцев
                .sorted(Comparator.comparing(Owner::getName)) // отсортируем по имени
                .collect(Collectors.toList());
    }

}