package ru.geekbrains.HomeWork5;

    public class Employee {
        String name;
        String position;
        String email;
        String fonNumber;
        int age;
        String salary;

        public Employee (String name, String position, String email, String fonNumber,int age, String salary) {
            this.name = name;
            this.position = position;
            this.email = email;
            this.fonNumber = fonNumber;
            this.age = age;
            this.salary = salary;

        }

        public int getAge() {
            return age;
        }

        public void printInfo() {
            System.out.printf("ФИО работника: %s, Должность: %s, email %s, номер телефона: %s, возраст: %d, зарплата: %s\n", name, position,
                    email, fonNumber, age, salary);

        }

}
