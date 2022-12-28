package ru.job4j.collection.sort.queue;

import org.junit.Test;
import ru.job4j.collection.queue.AppleStore;
import ru.job4j.collection.queue.Customer;

import java.util.LinkedList;
import java.util.Queue;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class AppleStoreTest {

    @Test
    public void whenGetLast() {
        Queue<Customer> customers = new LinkedList<>();
        customers.add(new Customer("Petr", 1000));
        customers.add(new Customer("Stas", 1500));
        customers.add(new Customer("Andrey", 850));
        customers.add(new Customer("Alexei", 900));
        customers.add(new Customer("Iryna", 1250));
        customers.add(new Customer("Elena", 750));
        customers.add(new Customer("Rail", 950));
        int count = 4;
        AppleStore appleStore = new AppleStore(customers, count);
        String customer = appleStore.getLastHappyCustomer();
        assertThat(customer, is("Alexei"));
    }

    @Test
    public void whenGetFirst() {
        Queue<Customer> customers = new LinkedList<>();
        customers.add(new Customer("Petr", 1000));
        customers.add(new Customer("Stas", 1500));
        customers.add(new Customer("Andrey", 850));
        customers.add(new Customer("Alexei", 900));
        customers.add(new Customer("Iryna", 1250));
        customers.add(new Customer("Elena", 750));
        customers.add(new Customer("Rail", 950));
        int count = 4;
        AppleStore appleStore = new AppleStore(customers, count);
        String customer = appleStore.getLastUpsetCustomer();
        assertThat(customer, is("Iryna"));
    }
}
