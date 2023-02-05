package ru.job4j.collection;

import java.util.LinkedList;

public class PriorityQueue {
    private LinkedList<Task> tasks = new LinkedList<>();

    public void put(Task task) {
        var index = 0;
        for (var element : tasks) {
            if (task.getPriority() < element.getPriority()) {
              break;
            }
            index++;
        }
        this.tasks.add(index, task);
        index = 0;
    }

    public Task take() {
        return tasks.poll();
    }
}