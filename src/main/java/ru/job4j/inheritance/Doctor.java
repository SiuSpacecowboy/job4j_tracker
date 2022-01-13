package ru.job4j.inheritance;

public class Doctor extends Profession {

    private String grade;

    public Doctor(String name, String surname, String education, String birthday) {
        super(name, surname, education, birthday);
    }

    public String getGrade() {
        return grade;
    }
}
