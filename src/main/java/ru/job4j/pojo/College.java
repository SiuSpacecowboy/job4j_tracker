package ru.job4j.pojo;

public class College {

    public static void main(String[] args) {
        Student student = new Student();
        student.setFio("DVA");
        student.setAdmission("20.20.2020");
        student.setGroup("BIV172");
        System.out.println("Student:" + student.getFio() + " Entered:" + student.getAdmission()
                + " Group:" + student.getGroup());
    }
}
