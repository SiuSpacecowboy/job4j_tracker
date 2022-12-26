package ru.job4j.collection.sort;

import ru.job4j.Job;

import java.util.Comparator;

public class JobAscByName implements Comparator<Job> {

    @Override
    public int compare(Job o1, Job o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
