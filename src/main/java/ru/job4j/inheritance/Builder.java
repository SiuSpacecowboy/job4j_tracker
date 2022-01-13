package ru.job4j.inheritance;

public class Builder extends Engineer {

    private String tool;

    public Builder(String name, String surname, String education, String birthday) {
        super(name, surname, education, birthday);
    }

    public String getTool() {
        return tool;
    }
}
