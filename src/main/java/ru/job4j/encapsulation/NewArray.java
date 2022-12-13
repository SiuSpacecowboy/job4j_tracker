package ru.job4j.encapsulation;

import java.util.Arrays;

public final class NewArray implements Mass {

    private static NewArray arr = null;
    private String[] array = new String[1000];
    private int count = 0;

    private NewArray() {
    }

    public static NewArray getArr() {
        if (arr == null) {
            arr = new NewArray();
        }
        return arr;
    }

    @Override
    public String name() {
        return "Создать словарь";
    }

    @Override
    public String[] addWords(String name) {
        for (int index = 0; index < array.length; index++) {
            if (name.equals(array[index])) {
                System.out.println("Такой элемент уже есть.");
                break;
            } else if (array[index] == null) {
                array[index] = name;
                count++;
                break;
            }
        }
        return Arrays.copyOf(array, count);
    }
}
