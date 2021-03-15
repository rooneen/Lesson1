package ru.geekbrains.Lesson6.HomeWork;

public class Animals implements AnimalProperties {

    private final double animalDistRun;
    private final double animalDistSwim;

    Animals(double animalDistRun, double animalDistSwim){
        this.animalDistRun = animalDistRun;
        this.animalDistSwim = animalDistSwim;
    }


    @Override
    public double run(double value) {
        return animalDistRun;
    }

    @Override
    public double swim(double value) {
        return animalDistSwim;
    }

    public double getAnimalDistRun() {
        return animalDistRun;
    }

    public double getAnimalDistSwim() {
        return animalDistSwim;
    }
}
