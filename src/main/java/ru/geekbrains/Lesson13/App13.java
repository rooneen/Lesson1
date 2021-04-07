package ru.geekbrains.Lesson13;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

// Синхронизированные коллекции
public class App13 {
    public static void main(String[] args) {
        // 1) создание синхронизированной коллекции с помощью методов Collections
        final Collection<Object> synchronizedCollection = Collections.synchronizedCollection(new ArrayList<>());
        // таких методов в Collections довольно много
//        Collections.synch...
        // не очень эфективны (не рекомендуются к использованию)

        final List<String> arrayList = new CopyOnWriteArrayList<>();
        final Set<String> set = new CopyOnWriteArraySet<>();
        final ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();
        final ConcurrentLinkedQueue<String> queue = new ConcurrentLinkedQueue<>();
        // и т.д.
//        new Concurrent...
    }

}