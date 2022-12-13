package ru.job4j.collection;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FullSearch {

    public static HashSet<String>  extractNumber(List<Tusk> list) {
        HashSet<String> numbers = new HashSet<>();
        for (Tusk nums : list) {
            numbers.add(nums.getNumber());
        }
        return numbers;
    }
}
