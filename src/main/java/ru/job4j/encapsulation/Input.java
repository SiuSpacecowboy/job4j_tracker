package ru.job4j.encapsulation;

import java.util.Scanner;

public class Input {

    private Scanner scanner = new Scanner(System.in);

    public String askStr(String question) {
        System.out.println(question);
        return scanner.nextLine();
    }

    public int askInt(String question) {
        System.out.print(question);
        return Integer.parseInt(scanner.nextLine());
    }

}
