package ru.job4j.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FilterNegativeNumbers {

    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, -1, 0, 10, -2, -3);
        List<Integer> positive = numbers.stream().filter(num -> num > 0).collect(Collectors.toList());
        positive.forEach(System.out::println);
    }
}
