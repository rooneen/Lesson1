package ru.geekbrains.Lesson8.builder;

public class App {

    public static void main(String[] args) {
        Employee employee = new Employee.Builder()
                .addressCity("NiNo")
                .inn(12366555L)
                .email("aaa@ssss.ru")
                .department(Department.IT)
                .build();
    }
}