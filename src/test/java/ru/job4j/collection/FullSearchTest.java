package ru.job4j.collection;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class FullSearchTest {

    @Test
    public void extractNumberTest() {
        List<Tusk> tusks = Arrays.asList(
                new Tusk("1", "First desc"),
                new Tusk("2", "Second desc"),
                new Tusk("1", "First desc")
        );
        Set<String> expected = new HashSet<>(Arrays.asList("1", "2"));
        HashSet<String> res = FullSearch.extractNumber(tusks);
        assertTrue(res.containsAll(expected));
    }

}