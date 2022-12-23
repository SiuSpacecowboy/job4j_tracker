package ru.job4j;

import org.junit.Test;
import ru.job4j.tracker.Item;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ItemAscByNameTest {

    @Test
    public void sortNaturalTest() {
        List<Item> items = new ArrayList<>(List.of(
                new Item("Dev"),
                new Item("Fonk"),
                new Item("Arm")
        ));
        items.sort(new ItemAscByName());
        List<Item> exp = new ArrayList<>(List.of(
                new Item("Arm"),
                new Item("Dev"),
                new Item("Fonk")
        ));
        assertThat(items.toString(), is(exp.toString()));
    }
}