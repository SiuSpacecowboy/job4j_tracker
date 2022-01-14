package ru.job4j.inheritance;

public class Engineer extends Profession {

    private String device;

    public Engineer(String name, String surname, String education, String birthday, String device) {
        super(name, surname, education, birthday);
        this.device = device;
    }

    public String getDevice() {
        return device;
    }
}
