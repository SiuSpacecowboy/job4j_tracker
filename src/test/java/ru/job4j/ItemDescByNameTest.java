package ru.job4j;

import org.junit.Assert;
import org.junit.Test;
import ru.job4j.tracker.Item;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ItemDescByNameTest {

    @Test
    public void sortReverseTest() {
        List<Item> items = new ArrayList<>(List.of(
                new Item("Arm"),
                new Item("Dev"),
                new Item("Fonk")
        ));
        items.sort(new ItemDescByName());
        List<Item> exp = new ArrayList<>(List.of(
                new Item("Fonk"),
                new Item("Dev"),
                new Item("Arm")
        ));
        assertThat(items.toString(), is(exp.toString()));
    }
}