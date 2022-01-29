package ru.job4j.poly;

public class Bus implements Transport {

    @Override
    public void drive() {
    }

    @Override
    public void passengers(int count) {
        int pass = 15;
    }

    @Override
    public double refuel(double fuel) {
        double luckoil = 12.5;
        double refuel = luckoil * 50;
        return refuel;
    }
}

