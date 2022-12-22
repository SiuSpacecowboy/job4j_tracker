package ru.job4j.collection.queue;

import java.util.Queue;

public class AppleStore {

    private final Queue<Customer> queue;
    private final int count;

    public AppleStore(Queue<Customer> queue, int count) {
        this.queue = queue;
        this.count = count;
    }

    public String getLastHappyCustomer() {
        int startSize = queue.size();
        for (int i = 0; i < count - 1; i++) {
            queue.poll();
        }
        return queue.element().name();
    }

    public String getLastUpsetCustomer() {
        for (int i = 0; i < count; i++) {
            queue.poll();
        }
        return queue.element().name();
    }
}

