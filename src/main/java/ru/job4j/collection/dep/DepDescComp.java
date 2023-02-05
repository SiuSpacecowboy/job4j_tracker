package ru.job4j.collection.dep;

import ru.job4j.collection.attestation.Label;

import java.util.Comparator;
import java.util.List;

public class DepDescComp implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        List<String> first = List.of(o1.split("/"));
        List<String> second = List.of(o2.split("/"));
        int result = second.get(0).compareTo(first.get(0));
        return result != 0 ? result : o1.compareTo(o2);
    }
}

