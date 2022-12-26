package ru.job4j.collection;

import java.util.Comparator;
import java.util.List;

public class LexSort implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        List<String> first = List.of(left.split("\\."));
        List<String> second = List.of(right.split("\\."));
        return Integer.compare(Integer.parseInt(first.get(0)), Integer.parseInt(second.get(0)));
    }
}
