package ru.job4j.inheritance;

public class Dentist extends Doctor {

    private String tooth;

    public Dentist(String name, String surname, String education, String birthday, String grade, String tooth) {
        super(name, surname, education, birthday, grade);
        this.tooth = tooth;
    }

    public String getTooth() {
        return tooth;
    }
}
