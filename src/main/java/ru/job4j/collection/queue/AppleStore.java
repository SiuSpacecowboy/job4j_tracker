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
        String name = "";
        int startSize = queue.size();
        for (int i = 0; i < startSize; i++) {
            if (i != count - 1) {
                queue.poll();
            } else {
                name = queue.element().name();
                break;
            }
        }
        return name;
    }

    public String getLastUpsetCustomer() {
        String name = "";
        int startSize = queue.size();
        for (int i = 0; i < startSize; i++) {
            if (i < count) {
                queue.poll();
            } else {
                name = queue.element().name();
                break;
            }
        }
        return name;
    }
}

