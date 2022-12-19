package ru.job4j.collection;

import java.util.Objects;

public class Acc {

    private double balance;
    private String requisite;

    public Acc(String requisite, double balance) {
        this.balance = balance;
        this.requisite = requisite;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getRequisite() {
        return requisite;
    }

    public void setRequisite(String requisite) {
        this.requisite = requisite;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Acc)) {
            return false;
        }
        Acc acc = (Acc) o;
        return Objects.equals(requisite, acc.requisite);
    }

    @Override
    public int hashCode() {
        return Objects.hash(balance, requisite);
    }

    @Override
    public String toString() {
        return "Acc{"
                + "balance='" + balance + '\''
                + ", requisite='" + requisite + '\''
                + '}';
    }
}

