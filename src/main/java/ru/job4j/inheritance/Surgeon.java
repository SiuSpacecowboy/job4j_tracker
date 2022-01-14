package ru.job4j.inheritance;

public class Surgeon extends Doctor {

    private String scalp;

    public Surgeon(String name, String surname, String education, String birthday, String grade, String scalp) {
        super(name, surname, education, birthday, grade);
        this.scalp = scalp;
    }

    public String getScalp() {
        return scalp;
    }
}
