package ru.job4j.ex;

import org.junit.Test;

import static org.junit.Assert.*;

public class FactTest {

    @Test(expected = IllegalArgumentException.class)
    public void factWhenMinusOne() {
        Fact fact = new Fact();
        fact.calc(-1);
    }
}