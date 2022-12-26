package ru.job4j.collection;

import java.util.*;

public class StringCompare implements Comparator<String> {

    public int compare(String left, String right) {
        List<String> first = List.of(left.split(""));
        List<String> second = List.of(right.split(""));
        int size = Math.min(first.size(), second.size());
        for (int i = 0; i < size; i++) {
            if (first.get(i).hashCode() > second.get(i).hashCode()) {
                return 1;
        } else if (first.get(i).hashCode() < second.get(i).hashCode()) {
                return -1;
            } else if (i == size - 1 && first.size() < second.size()) {
                return -1;
            } else if (i == size - 1 && first.size() > second.size()) {
                return 1;
            }
        }
        return 0;
    }
}

