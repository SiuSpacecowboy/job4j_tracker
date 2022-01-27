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
                if (key.equals(item.getName())) {
                    res[count] = item;
                    count++;
                }
            }
            res = Arrays.copyOf(res, count);
            return res;
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < size; index++) {
            if (items[index].getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items[index] : null;
    }

    public boolean replace(int id, Item item) {
        int index = indexOf(id);
        boolean rsl = index != -1;
        if (rsl) {
            item.setId(id);
            items[index] = item;
        }
        return rsl;
    }

    public boolean delete(int id) {
        int index = indexOf(id);
        boolean rsl = index != -1;
        if (rsl) {
            System.arraycopy(items, index + 1, items, index,
                    size - 1 - index);
            items[size - 1] = null;
            size--;
        }
        return rsl;
    }
}
