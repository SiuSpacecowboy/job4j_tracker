package ru.job4j.collection.dep;

import ru.job4j.collection.attestation.Label;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        String[] first = o1.split("/");
        String[] second = o2.split("/");
        int result = second[0].compareTo(first[0]);
        return result != 0 ? result : o1.compareTo(o2);
    }
}

