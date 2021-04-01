package ru.geekbrains.Lesson11.HomeWork11;

import java.util.ArrayList;
import java.util.Arrays;

public class Box<T extends Fruit> {
    private final ArrayList<T> items;

    @SafeVarargs
    public Box(T... items) {
        this.items = new ArrayList<T>(Arrays.asList(items));
    }

    @SafeVarargs
    public final void add(T... items) {
        this.items.addAll(Arrays.asList(items));
    }

    @SafeVarargs
    public final void remove(T... items) {
        for (T item : items) this.items.remove(item);
    }

    public ArrayList<T> getItems() {
        return new ArrayList<T>(items);
    }

    public void clear() {
        items.clear();
    }

    public float getWeight() {
        if (items.size() == 0) return 0;
        float weight = 0;
        for (T item : items) weight += item.getWeight();
        return weight;
    }

    public boolean compare(Box box) {
        return this.getWeight() == box.getWeight();
    }

    public void transfer(Box<? super T> box) {
        box.items.addAll(this.items);
        clear();
    }
}