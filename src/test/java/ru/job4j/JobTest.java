package ru.job4j;

import org.junit.Test;
import ru.job4j.Job;
import ru.job4j.collection.sort.JobAscByName;
import ru.job4j.collection.sort.JobAscByPriority;
import ru.job4j.collection.sort.JobDescByName;
import ru.job4j.collection.sort.JobDescByPriority;
import java.util.*;


import static org.assertj.core.api.Assertions.*;

public class JobTest {

    @Test
    public void whenAscByNameTest() {
       List<Job> list = new ArrayList<>(List.of(
                new Job("Fedya", 3),
                new Job("Alla", 2),
                new Job("Feza", 6),
                new Job("Dm", 1)

        ));
        List<Job> exp = new ArrayList<>(List.of(
                new Job("Alla", 2),
                new Job("Dm", 1),
                new Job("Fedya", 3),
                new Job("Feza", 6)
        ));
        list.sort(new JobAscByName());
        assertThat(list).containsSequence(exp);
    }

    @Test
    public void whenDescByNameTest() {
        List<Job> list = new ArrayList<>(List.of(
                new Job("Fedya", 3),
                new Job("Alla", 2),
                new Job("Feza", 6),
                new Job("Dm", 1)

        ));
        List<Job> exp = new ArrayList<>(List.of(
                new Job("Feza", 6),
                new Job("Fedya", 3),
                new Job("Dm", 1),
                new Job("Alla", 2)
        ));
        list.sort(new JobDescByName());
        assertThat(list).containsSequence(exp);
    }

    @Test
    public void whenAscByPriorityTest() {
        List<Job> list = new ArrayList<>(List.of(
                new Job("Fedya", 3),
                new Job("Alla", 2)

        ));
        List<Job> exp = new ArrayList<>(List.of(
                new Job("Alla", 2),
                new Job("Fedya", 3)
        ));
        list.sort(new JobAscByPriority());
        assertThat(list).containsSequence(exp);
    }

    @Test
    public void whenDescByPriorityTest() {
        List<Job> list = new ArrayList<>(List.of(
                new Job("Fedya", 3),
                new Job("Alla", 2)

        ));
        List<Job> exp = new ArrayList<>(List.of(
                new Job("Fedya", 3),
                new Job("Alla", 2)
        ));
        list.sort(new JobDescByPriority());
        assertThat(list).containsSequence(exp);
    }

    @Test
    public void whenComparatorByNameAndPriority() {
        Comparator<Job> cmpNamePriority = new JobDescByName().thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenComparatorByNameAndPriorityAndUsePriority() {
        Comparator<Job> cmpNamePriority = new JobDescByName().thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Fix bug", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl).isGreaterThan(0);
    }

    @Test
    public void whenComparatorByNameAndPriorityAsc() {
        Comparator<Job> cmpNamePriority = new JobAscByName().thenComparing(new JobAscByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl).isGreaterThan(0);
    }

    @Test
    public void whenComparatorByNameAndPriorityAscAndUsePriority() {
        Comparator<Job> cmpNamePriority = new JobAscByName().thenComparing(new JobAscByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Impl task", 1)
        );
        assertThat(rsl).isLessThan(0);
    }

}
