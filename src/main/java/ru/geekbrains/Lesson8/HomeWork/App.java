package ru.geekbrains.Lesson8.HomeWork;

public class App {
    public static void main (String[] args) {

        JumpRun[] members = {
                new Human("Жора",1000 ,2),
                new Cat("Пузяка", 500, 5),
                new Robot("Wallу", 2000, 10),
        };

        Test[] obstacles = {
                new Road(1000),
                new Wall(2),
        };

        for (JumpRun member : members) {
            System.out.println("К испытанию приступает " + member);
            boolean winner = true;
            for (Test obstacle : obstacles) {
                System.out.println(member + " пробует пройти " + obstacle);
                if (obstacle.toJump(member.getMaxJump()) ||
                        obstacle.toRun(member.getMaxRun())) {
                    System.out.println("И справляется с задачей!");
                } else {
                    winner = false;
                    System.out.println("И не справляется с задачей.");
                    break;
                }
            }

            if(winner) {
                System.out.println(member + " прошёл испытание!");
            } else {
                System.out.println(member + " не прошёл испытание.");
            }
            System.out.println();
        }

    }
}
