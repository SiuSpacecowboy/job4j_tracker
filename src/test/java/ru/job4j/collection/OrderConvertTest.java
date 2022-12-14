package ru.job4j.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class OrderConvertTest {

    @Test
    public void whenSingleOrder() {
        List<Order> orders = new ArrayList<>();
        orders.add(new Order("3sfe", "Dress"));
        HashMap<String, Order> map = OrderConvert.process(orders);
        Order expected = new Order("3sfe", "Dress");
        Order res = map.get("3sfe");
        assertThat(res, is(expected));
    }

    @Test
    public void whenDuplicateOrders() {
        List<Order> orders = new ArrayList<>();
        orders.add(new Order("3sfe", "Dress"));
        orders.add(new Order("3sfe", "Shoes"));
        orders.add(new Order("3sfe", "Phone"));
        HashMap<String, Order> map = OrderConvert.process(orders);
        int res = map.size();
        assertThat(res, is(1));
    }
}
