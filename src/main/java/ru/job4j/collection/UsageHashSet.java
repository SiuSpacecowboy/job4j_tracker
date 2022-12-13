package ru.job4j.collection;

import java.util.HashSet;
import java.util.Set;

public class UsageHashSet {

    public static void main(String[] args) {
        Set<String> marks = new HashSet<>();
        marks.add("Lada");
        marks.add("BMW");
        marks.add("Volvo");
        marks.add("Toyota");
        for (String names : marks) {
            System.out.println(names);

        }
    }
}
