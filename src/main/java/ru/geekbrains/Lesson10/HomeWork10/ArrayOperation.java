package ru.geekbrains.Lesson10.HomeWork10;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class ArrayOperation {

    public static List<String> fillTheArray(List<String> array) {
        array.add("яблоко");
        array.add("яблоко");
        array.add("машина");
        array.add("кот");
        array.add("весна");
        array.add("весна");
        array.add("привет");
        array.add("дом");
        array.add("дом");
        array.add("собака");
        array.add("хомяк");
        array.add("хомяк");
        array.add("роза");
        array.add("собака");
        array.add("роза");
        array.add("роза");

        return array;
    }

    public static void printUniqueWords(List<String> array) {
        Set<String> tempArray = new LinkedHashSet<>();
        for (String arr : array) {
            String a = arr.toLowerCase();
            tempArray.add(a);
        }
        for (String tempArr : tempArray) {
            int count = 0;
            for (String arr : array) {
                String a = arr.toLowerCase();
                if(tempArr.equals(a)) count++;
            }
            System.out.println("\"" + tempArr + "\"" + " повторяется в списке = " + count + " раз(а)");
        }
        System.out.println();
    }
}
