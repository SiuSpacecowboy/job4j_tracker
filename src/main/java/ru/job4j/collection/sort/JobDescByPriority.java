package ru.job4j.collection.sort;

import ru.job4j.Job;

import java.util.Comparator;

public class JobDescByPriority implements Comparator<Job> {

    @Override
    public int compare(Job o1, Job o2) {
        return o2.compareTo(o1);
    }
}
