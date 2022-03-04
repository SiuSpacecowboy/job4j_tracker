package ru.job4j.tracker;

import org.junit.Test;

import static org.junit.Assert.*;

public class ValidateInputTest {

    @Test
    public void whenInvalidInput() {
        Output out = new StubOutput();
        Input input = new StubInput(
                new String[] {"dsadasdsa", "1"}
        );
        int res = new ValidateInput(input, out).askInt("Right?");
        int exp = 1;
        assertEquals(exp, res);
    }

    @Test
    public void whenInvalidNegativeInput() {
        Output out = new StubOutput();
        Input input = new StubInput(
                new String[] {"-3"}
        );
        int res = new ValidateInput(input, out).askInt("Right?");
        int exp = -3;
        assertEquals(exp, res);
    }

    @Test
    public void whenManyInvalidInput() {
        Output out = new StubOutput();
        Input input = new StubInput(
                new String[] {"1", "2", "3"}
        );
        ValidateInput res = new ValidateInput(input, out);
        int f = res.askInt("one");
        int s = res.askInt("two");
        int th = res.askInt("three");
        assertEquals(1, f);
        assertEquals(2, s);
        assertEquals(3, th);
    }
}
