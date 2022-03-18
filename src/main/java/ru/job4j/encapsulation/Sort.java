package ru.job4j.encapsulation;

import java.util.Arrays;

public class Sort {

    private String[] farray = {null};

    public String[] sort(Input input, String[] array) {
        for (String el : array) {
            if (el == null) {
                System.out.println("Введен недопустимый массив с null ссылкой или словарь пуст.");
                return farray;
            }
        }
        String ans = input.askStr("Точно хотите отсортировать словарь \"Y\", иначе нажмите введите любую кнопку.").toUpperCase();
        if (ans.equals("Y")) {
            Arrays.sort(array);
        }
        return array;
    }
}
