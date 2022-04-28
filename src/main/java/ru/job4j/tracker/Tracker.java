package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Tracker {
    private final List<Item> items = new ArrayList<>();
    //private final Item[] items = new Item[100];
    private int ids = 1;
    //private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items.add(item);
        return item;
    }

    public List<Item> findAll() {
        return items;
    }

        public List<Item> findByName(String key) {
            //Item[] res = new Item[size];
            //int count = 0;
            //for (int i = 0; i < size; i++) {
            //Item item = items.get(i);
            //if (key.equals(item.getName())) {
            //res[count] = item;
            //count++;
            //}
            //}
            List<Item> res = new ArrayList<>();
            for (Item name : items) {
                if (key.equals(name.getName())) {
                    res.add(name);
                }
            }
        return res;
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < items.size(); index++) {
            if (items.get(index).getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items.get(index) : null;
    }

    public boolean replace(int id, Item item) {
        int index = indexOf(id);
        boolean rsl = index != -1;
        if (rsl) {
            item.setId(id);
            items.set(index, item);
        }
        return rsl;
    }

    public boolean delete(int id) {
        int index = indexOf(id);
        boolean rsl = index != -1;
        if (rsl) {
            /*System.arraycopy(items, index + 1, items, index,
                    size - 1 - index);
            items[size - 1] = null;
            size--;
              */
            items.remove(index);
        }
        return rsl;
    }
}

