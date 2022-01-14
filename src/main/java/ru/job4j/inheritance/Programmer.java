package ru.job4j.inheritance;

public class Programmer extends Engineer {

    private String comp;

    public Programmer(String name, String surname, String education, String birthday, String device, String comp) {
        super(name, surname, education, birthday, device);
        this.comp = comp;
    }

    public String getComp() {
        return comp;
    }
}
