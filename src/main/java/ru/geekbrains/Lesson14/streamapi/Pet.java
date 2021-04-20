package ru.geekbrains.Lesson14.streamapi;

import java.util.HashSet;
import java.util.Set;

class Pet {
    private final Breed breed;
    private final String name;
    private final int age;

    public Pet(Breed breed, String name, int age) {
        this.breed = breed;
        this.name = name;
        this.age = age;
    }

    public Breed getBreed() {
        return breed;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "breed=" + breed +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

enum Breed {
    CAT, DOG, RABBIT, RAT
}

enum Zodiac {
    Aries,
    Taurus,
    Gemini,
    Cancer,
    Leo,
    Virgo,
    Libra,
    Scorpio,
    Sagittarius,
    Capricorn,
    Aquarius,
    Pisces
}

class Owner {
    private final String name;
    private final Zodiac zodiac;
    private final Set<Pet> pets;

    public Owner(String name, Zodiac zodiac) {
        this.name = name;
        this.zodiac = zodiac;
        this.pets = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public Set<Pet> getPets() {
        return pets;
    }

    public Zodiac getZodiac() {
        return zodiac;
    }

    public boolean add(Pet pet) {
        return getPets().add(pet);
    }

    @Override
    public String toString() {
        return "Owner{" +
                "name='" + name + '\'' +
                ", zodiac=" + zodiac +
                ", pets=" + pets +
                '}';
    }
}