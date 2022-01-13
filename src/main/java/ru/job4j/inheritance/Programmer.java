package ru.job4j.inheritance;

public class Programmer extends Engineer {

    private String comp;

    public Programmer(String name, String surname, String education, String birthday) {
        super(name, surname, education, birthday);
    }

    public String getComp() {
        return comp;
    }
}
