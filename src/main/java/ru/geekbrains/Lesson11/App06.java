package ru.geekbrains.Lesson11;

public class App06 {
    // как наследоваться от обобщенных классов
}

// 1
class FreeZoo<T> extends Zoo<T> {
    @Override
    public boolean encage(T animal) {
        throw new NotSupportException("Свободу попугаям!");
    }
}

// 2)
class Serpentarium extends Zoo<Snake> {

}

// 3) добавить параметров
class FZoo<A, T extends Animal & Movable> extends AnimalZoo<T> {

}

// 4) если родительский класс непараметризован
// class A<A, B> extends B {}