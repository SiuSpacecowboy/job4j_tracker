package ru.job4j.inheritance;

public class Builder extends Engineer {

    private String tool;

    public Builder(String name, String surname, String education, String birthday, String device, String tool) {
        super(name, surname, education, birthday, device);
        this.tool = tool;
    }

    public String getTool() {
        return tool;
    }
}
