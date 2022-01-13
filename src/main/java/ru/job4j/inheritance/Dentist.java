package ru.job4j.inheritance;

public class Dentist extends Doctor {

    private String tooth;

    public Dentist(String name, String surname, String education, String birthday) {
        super(name, surname, education, birthday);
    }

    public String getTooth() {
        return tooth;
    }
}
