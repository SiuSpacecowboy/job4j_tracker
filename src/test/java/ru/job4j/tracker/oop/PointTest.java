package ru.job4j.tracker.oop;

import org.junit.Assert;
import org.junit.Test;

public class PointTest {

    @Test
    public void distance() {
        Point a = new Point(0, 2);
        Point b = new Point(0, 0);
        double res = a.distance(b);
        double exp = 2;
        Assert.assertEquals(exp, res, 0.001);
    }

    @Test
    public void distance3d() {
        Point a = new Point(0, 2, 0);
        Point b = new Point(0, 0, 0);
        double res = a.distance3d(b);
        double exp = 2;
        Assert.assertEquals(exp, res, 0.001);
    }
}