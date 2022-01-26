package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item[] findAll() {
       Item[] finarr = new Item[size];
       int count = 0;
        for (int i = 0; i < size; i++) {
            Item item = items[i];
            if (item != null) {
                finarr[count] = item;
                count++;
            }
        }
        finarr = Arrays.copyOf(finarr, count);
        return finarr;
    }

        public Item[] findByName(String key) {
        Item[] res = new Item[size];
        int count = 0;
            for (int i = 0; i < size; i++) {
                Item item = items[i];
                if (item.getName() == key) {
                    res[count] = item;
                    count++;
                }
            }
            res = Arrays.copyOf(res, count);
            return res;
    }

    public Item findById(int id) {
        Item rsl = null;
        for (int index = 0; index < size; index++) {
            Item item = items[index];
            if (item.getId() == id) {
                rsl = item;
                break;
            }
        }
        return rsl;
    }
}
