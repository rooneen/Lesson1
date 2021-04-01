package ru.geekbrains.Lesson11.Lesson;

public class BoxDemoApp {

    public static void main(String[] args) {
        SimpleBox intBox1 = new SimpleBox(20);
        SimpleBox intBox2 = new SimpleBox(30);

        if (intBox1.getObj() instanceof Integer && intBox2.getObj() instanceof Integer) {
            int sum = (Integer)intBox1.getObj() + (Integer)intBox2.getObj();
            System.out.println("sum = " + sum);
        } else {
            System.out.println("Содержимое коробок отличается по типу");
        }

        // вызвали какой-нибудь метод, которому отдали intBox1
        // и этот метод кладет в коробку String
        intBox1.setObj("Java");

        // продолжаем наш код, и при выполнении получим ClassCastException
        int secondSum = (Integer)intBox1.getObj() + (Integer)intBox2.getObj();
    }

}
