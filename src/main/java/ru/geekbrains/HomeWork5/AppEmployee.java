package ru.geekbrains.HomeWork5;

public class AppEmployee {
    public static void main(String[] args) {
        Employee[] Employee = new Employee[5];
        Employee[0] = new Employee("Иванов ИИ", "Директор", "geek@mail.ru", "929-622-33-81", 56, "190000");
        Employee[1] = new Employee("Петров ПП", "Инженер", "geek@mail.ru", "929-622-33-82", 46, "90000");
        Employee[2] = new Employee("Сизов ИИ", "Технолог", "geek@mail.ru", "929-622-33-83", 36, "80000");
        Employee[3] = new Employee("Сидоров СИ ", "Бухгалтер", "geek@mail.ru", "929-622-33-84", 35, "90000");
        Employee[4] = new Employee("Соколов АИ", "Охранник", "geek@mail.ru", "929-622-33-85", 26, "40000");
        for (int i = 0; i < Employee.length; i++) {
            if(Employee[i].getAge() > 40){
                Employee[i].printInfo();
            }
        }
    }
}
