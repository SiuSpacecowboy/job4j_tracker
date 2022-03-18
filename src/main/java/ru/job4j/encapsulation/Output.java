package ru.job4j.encapsulation;

public class Output {

    public void out(String[] array) {
        System.out.println("Полученный словарь:");
        for (String el : array) {
            System.out.println(el);
        }
    }
}
