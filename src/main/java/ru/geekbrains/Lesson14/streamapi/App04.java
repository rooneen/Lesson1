package ru.geekbrains.Lesson14.streamapi;

import java.util.List;
import java.util.OptionalDouble;
import java.util.Set;
import java.util.stream.Collectors;

// flatMap()
public class App04 {

    public static void main(String[] args) {
        final App04 app = new App04();
        final OwnerGenerator ownerGenerator = new OwnerGenerator();
        final List<Owner> owners = ownerGenerator.generate();
        owners.forEach(System.out::println);
        app.work(owners);
    }

    public void work(List<Owner> owners) {
        // попробуем получить всех питомцев
        final List<Set<Pet>> petsList = owners.stream()
                .map(Owner::getPets) // если сделать так, то получим не совсем то, что ожидаем
                .collect(Collectors.toList());

        // Если требуется получить "плоский" список, то используем метод flatMap()
        final List<Pet> pets = owners.stream()
                .flatMap(owner -> owner.getPets().stream()) // нужен стрим
                .collect(Collectors.toList());// снова соберем и убедимся, что все ок

        // посчитаем средний возраст всех питомцев
        final OptionalDouble averagePetAge = owners.stream()
                .flatMap(owner -> owner.getPets().stream()) // нужен стрим
                .mapToDouble(Pet::getAge)
                .average(); // этот метод возвращает Optional. Если ни у одного владельца нет питомцев, то внутри будет "пустое" значение
        System.out.println(averagePetAge.getAsDouble()); // так использовать Optional опасно. Если попытатся взять значение на "пустом" объекте, то возникнет исключение
        // Безопасные способы использования
        if (averagePetAge.isPresent()) { // нефункционально
            double avg = averagePetAge.getAsDouble();
        }

        final double avg = averagePetAge.orElse(0); // уже лучше
        final double avg2 = averagePetAge.orElseThrow(() -> new RuntimeException("Нет питомцев")); // иногда бизнес-логика требует бросить исключение

    }

}