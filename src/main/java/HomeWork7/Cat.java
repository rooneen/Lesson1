package HomeWork7;

public class Cat {

    private String name;
    private int appetite;
    private int hungerTime;
    private int satiety;

    String getName() {
        return name;
    }

    int getAppetite() {
        return appetite;
    }

    int getSatiety() {
        return satiety;
    }

    void setSatiety(int satiety) {
        this.satiety = satiety;
    }

    Cat(String name, int appetite, int hungerTime) {

        this.name = name;
        this.appetite = appetite;
        this.hungerTime = hungerTime;
        this.satiety = 0;
    }

    void eat(Plate p) {
        p.decreaseFood(appetite);
        satiety += hungerTime;
    }
}
