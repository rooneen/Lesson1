package ru.geekbrains.Lesson6.HomeWork2;

public abstract class Animal { // Alt + Ent - быстрое создание класса

    protected String name;
    protected Breed breed;
    protected double runLimit;
    protected double swimLimit;

    private static int count;

    public Animal(String name, Breed breed, double runLimit, double swimLimit) {
        this.name = name;
        this.breed = breed;
        this.runLimit = runLimit;
        this.swimLimit = swimLimit;
        count++;
    }

    public void run(double distance) {

        if (runLimit == 0){
            System.out.printf("%s %s не умеет бегать\n", breed.getBreed(), name);
            return;
        }
        if (distance > runLimit) {
            System.out.printf("%s %s не может бежать больше %f метров\n", breed.getBreed(), name, runLimit);
            return;
        }
        System.out.printf("%s %s бежит %f метров\n", breed.getBreed(), name, distance);
    }

    public void swim(double distance) {
        if (swimLimit == 0){
            System.out.printf("%s %s не умеет плавать\n", breed.getBreed(), name);
            return;
        }
        if (distance > swimLimit) {
            System.out.printf("%s %s не может плыть больше %f метров\n", breed.getBreed(), name, swimLimit);
            return;
        }
        System.out.printf("%s %s плывет %f метров\n", breed.getBreed(), name, distance);

    }

    public static int getCount() {
        return count;
    }
}
