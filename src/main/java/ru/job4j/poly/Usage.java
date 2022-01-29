package ru.job4j.poly;

public class Usage {

    public static void main(String[] args) {
        Vehicle mercedes = new Auto();
        Vehicle boeing = new Plane();
        Vehicle train = new Train();
        Vehicle[] vehicle = new Vehicle[]{mercedes, boeing, train};
        for (Vehicle a : vehicle) {
            a.move();
        }
    }
}
