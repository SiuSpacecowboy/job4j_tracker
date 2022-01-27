package ru.job4j.io;

import javax.swing.*;
import java.util.Random;
import java.util.Scanner;

public class MagicBall {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Я велики Оракул. Что ты хочешь узнать?");
        String res = input.nextLine();
        int ans = new Random().nextInt(3);
        if (ans == 0) {
            System.out.println("Да");
        } else if (ans == 1) {
            System.out.println("Нет");
        } else {
            System.out.println("Может быть");
        }
    }
}
