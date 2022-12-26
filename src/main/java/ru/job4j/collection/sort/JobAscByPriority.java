package ru.job4j.collection.sort;

import java.util.Comparator;

public class JobAscByPriority implements Comparator<Job> {

    @Override
    public int compare(Job o1, Job o2) {
        return o1.compareTo(o2);
    }
}

