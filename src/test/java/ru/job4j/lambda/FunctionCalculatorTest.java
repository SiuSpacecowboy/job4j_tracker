package ru.job4j.lambda;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class FunctionCalculatorTest {

    @Test
    public void whenLineFunc() {
        FunctionCalculator func = new FunctionCalculator();
        List<Double> rsl = func.diapason(3, 7, x -> 3 * x + 5);
        List<Double> exp = List.of(14D, 17D, 20D, 23D);
        assertThat(rsl).containsAll(exp);
    }

    @Test
    public void whenQuadFunc() {
        FunctionCalculator func = new FunctionCalculator();
        List<Double> rsl = func.diapason(1, 4, x -> Math.pow(x, x) + 5 * x + 3);
        List<Double> exp = List.of(9D, 17D, 45D);
        assertThat(rsl).containsAll(exp);
    }

    @Test
    public void whenExpFunc() {
        FunctionCalculator func = new FunctionCalculator();
        List<Double> rsl = func.diapason(3, 7, x -> Math.pow(3, x));
        List<Double> exp = List.of(27D, 81D, 243D, 729D);
        assertThat(rsl).containsAll(exp);
    }
}