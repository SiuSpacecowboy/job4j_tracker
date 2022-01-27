package ru.job4j.io;

import java.util.Scanner;

public class Matches {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Игра началась");
        int count = 11;
        boolean turn = true;
        while (count > 0) {
            String player = turn ? "Игрок1" : "Игрок2";
            System.out.println(player + " Возьмите от 1 до 3 спичек");
            Integer select = Integer.parseInt(input.nextLine());
            if (select < 1 || select > 3 || select > count) {
                System.out.println("Вы взяли недопустимое количество спичек, возьмите меньше");
            } else {
                count = count - select;
                turn = !turn;
            }
        }
        if (!turn) {
            System.out.println("Выйграл Игрок1");
        } else {
            System.out.println("Выйграл Игрок2");
        }
    }
}
