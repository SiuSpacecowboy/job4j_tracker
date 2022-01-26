package ru.job4j.tracker;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class StartUI {

    public static void main(String[] args) {
        Item testToString = new Item();
        System.out.println(testToString);
        Item curentdatetime = new Item();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        LocalDateTime datetime = curentdatetime.getDateTime();
        String rightformatdatetime = datetime.format(formatter);
        System.out.println("Время " + rightformatdatetime);
    }
}
