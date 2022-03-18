package ru.job4j.encapsulation;

import java.util.Arrays;

public class AddArray implements Mass {

    private final Getter add;
    private String[] array;

    public AddArray(Getter add, String[] array) {
        this.add = add;
        this.array = array;
    }

    @Override
    public String name() {
        return "Добавить словарь";
    }

    @Override
    public String[] addWords(String name) {
        for (int index = 0; index < array.length; index++) {
            if (array[index] == null) {
                throw new NullPointerException("Некорректный массив с null ссылками.");
            } else if ((name.equals(array[index]))) {
                System.out.println("Такой элемент уже есть.");
                break;
            } else if (index == array.length - 1) {
                array = Arrays.copyOf(array, array.length + 1);
                array[index + 1] = name;
                break;
            }
        }
        return array;
    }
 }
