package ru.geekbrains.Lesson10.HomeWork10;

import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(String[] args) {

        List<String> wordArray = new ArrayList<String>();
        wordArray = ArrayOperation.fillTheArray(wordArray);
        System.out.println(wordArray + "\n");
        ArrayOperation.printUniqueWords(wordArray);
        wordArray.clear();

        Phonebook phonebook = new Phonebook();

        phonebook.add(2304578, "Иванов");
        phonebook.add(5678794, "Иванов");
        phonebook.add(3456783, "Соколов");
        phonebook.add(3456278, "Сидоров");
        phonebook.add(9786053, "Сидоров");
        phonebook.add(6475893, "Соколов");
        phonebook.add(6475893, "Васильев");

        phonebook.get("Иванов");
        phonebook.get("Васильев");
        phonebook.get("Сидоров");
        phonebook.get("Громов");
        phonebook.get("Шпак");
        phonebook.get("Бунша");

    }
}
