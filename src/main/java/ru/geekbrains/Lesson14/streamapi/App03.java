package ru.geekbrains.Lesson14.streamapi;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// Stream API
public class App03 {

    // Простые примеры
    public static void main(String[] args) {

        final List<String> strings = Arrays.asList("1", "2", "5", "25", "17", "3", "5", "11", "-1", "4", "7", "6");
        final Stream<String> weekStream = strings
                .stream() // вызовем метод stream
                .map(s -> Integer.parseInt(s)) // метод map() принимает объект Function и преобразует элементы коллекции в другие объекты
//                .map(Integer::parseInt) // можно упростить запись и записать как method reference (ссылка на метод). Считается, что так код читать легче
                .filter(i -> i < 8 && i > 0) // теперь на вход подаются не строки, а целые числа. Можно их отфильтровать. Методы filter() принимает на вход предикат. Фильтр пройдут только те элементы, которые удовлетворяют условию предиката
                .map(i -> {
                    switch (i) {
                        case 1:
                            return "Пн";
                        case 2:
                            return "Вт";
                        case 3:
                            return "Ср";
                        case 4:
                            return "Чт";
                        case 5:
                            return "Пт";
                        case 6:
                            return "Сб";
                        default:
                            return "Вс";
                    }
                }) // преобразуем обратнов в строки
                // Вы хотите еще методов? Их есть у меня
                .skip(2) // пропустить нужное количество элементов
                .limit(2) // взять только два элемента
                // если требуется что-то сделать с элементами коллекции, но не нужно возвращаемое значение, или нужен какой-то промежуточный вывод на печать, подойдет метод peek() - он принимает Consumer
                .peek(System.out::println)
                .peek(String::toUpperCase) // в данном случае этот вызов ничего не изменит, т.к. строки в Java неизменяемые. Чтобы все заработало, нужен метод map(), который вернет новую строку:
                .map(String::toUpperCase)
                .sorted() // отсортировать (метод также может принимать компаратор)
                .distinct(); // убрать повторения

        // все методы выше были не терминальными - они возвращали Stream. Теперь познакомимся с терминальными операциями
        // - метод collect(...) предназначен для преобразования объекта Stream в другие типы объектов, например коллекцию или Map или что-то еще. В этот метод передается специальный объект - Collector. В классе Collectors есть большое количество уже готовых коллекторов, но никто не мешает создать свой
        final List<String> weekList = weekStream.collect(Collectors.toList()); // вернет List
        System.out.println(weekList);

        // Объект Stream нельзя повторно использовать после применения терминальной операции, поэтому чтобы следующий пример заработал, закомментируйте предыдущую строчку
        final Set<String> weekSet = weekStream.collect(Collectors.toSet()); // вернет Set

        // Можно объединить элементы коллекции, использую joining. Не забываем комментировать строки с терминальными операциями!
        final String weekString = weekStream.collect(Collectors.joining(";"));

        // из стрима можно сделать Map, нужно только передать в него две функции в качестве параметров. Первая - сформирует ключ, вторая - значение. Пусть ключом будет, скажем, сам элемент коллекции, а значением - выходной этот день или рабочий. Не забываем комментировать строки с терминальными операциями!
        final Map<String, String> weekMap = weekStream.collect(Collectors.toMap(Function.identity(), s -> "Вс".equals(s) || "Сб".equals(s) ? "Выходной" : "Рабочий"));

        // еще терминальные операции
        final long count = weekStream.count(); // посчитать количество элементов
        weekStream.max(String::compareTo); // найти максимальный и минимальный элемент
        weekStream.toArray(); // преобразовать в массив
        weekStream.reduce("--", (a, b) -> a + "-" + b); // попробуйте догаться, что здесь происходит
        weekStream.forEach(a -> System.out.println(a)); // ну или можно выполнить какое-то действие над объектами (аналог peek(), но forEach() - терминальная операция)
    }

}