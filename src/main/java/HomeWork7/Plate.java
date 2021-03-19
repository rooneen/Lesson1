package HomeWork7;

public class Plate {

    private int food;
    private int setFood = 400; // Кол-во добавляемой еды

    int getFood() {
        return food;
    }

    Plate(int food) {
        this.food = food;
    }

    void decreaseFood(int n) {
        food -= n;
    }

    void increaseFood() {
        this.food += setFood;
        System.out.println("В миску добавили " + setFood + " грамм корма.");
    }

    boolean checkFood(int n) {
        return (food - n) >= 0;
    }
}
