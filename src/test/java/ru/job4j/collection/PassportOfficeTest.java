package ru.job4j.collection;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class PassportOfficeTest {

    @Test
    public void whenTestAddMethod() {
        Citizen citizen = new Citizen("2f44a", "Petr Arsentev");
        PassportOffice office = new PassportOffice();
        office.add(citizen);
        Citizen exp = citizen;
        Citizen res = office.get(citizen.getPassport());
        assertThat(res, is(exp));
    }

    @Test
    public void whenTestAddFalse() {
        Citizen citizen = new Citizen("2f44a", "Petr Arsentev");
        PassportOffice office = new PassportOffice();
        office.add(citizen);
        assertFalse(office.add(citizen));
    }
}