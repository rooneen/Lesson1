package ru.geekbrains.Lesson11;

import java.util.ArrayList;
import java.util.List;

public class App01 {
    // сегодня мы рассмотрим тему "обобщения / дженерики"
    // частично мы уже сталкивались с ними на прошлом занятии по коллекциям
    // напомню, в чем была боль разработчиков до появления дженериков
    public static void main(String[] args) {

        List nums = new ArrayList();
        nums.add(1);
        nums.add(2);

        final Object n = nums.get(0); // необходимо явное приведение типов
        final Integer intN = (Integer) n;

        // программисту необходимо помнить о типе коллекции
        // ничто не ограничивает его случайно заполнить коллекцию другими объектами
        nums.add(1111L);
//        final Integer lngN = (Integer) nums.get(2); // ошибка ClassCastException

        // значит нужны проверки на правильный тип
        final Integer lngN1;
        if (nums.get(2) instanceof Integer) {
            lngN1 = (Integer) nums.get(2);
        } else {
//            ... как-то обработать эту ситуацию
        }

    }

}