package ru.job4j.stream;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import static org.assertj.core.api.Assertions.assertThat;

public class SchoolTest {

    @Test
    public void whenCollectClassA() {
        List<Student> students = List.of(
                new Student(69, "Vasya"),
                new Student(76, "Nastya"),
                new Student(100, "Nick"),
                new Student(87, "Ilya"),
                new Student(43, "Mariya")
        );
        Predicate<Student> pr = st -> st.getScore() >= 70;
        School school = new School();
        List<Student> res = school.collect(students, pr);
        List<Student> exp = new ArrayList<>();
        exp.add(new Student(76, "Nastya"));
        exp.add(new Student(100, "Nick"));
        exp.add(new Student(87, "Ilya"));
        assertThat(res).containsAll(exp);
    }

    @Test
    public void whenCollectClassB() {
        List<Student> students = List.of(
                new Student(20, "Surname2"),
                new Student(30, "Surname3"),
                new Student(50, "Surname5"),
                new Student(60, "Surname6"),
                new Student(80, "Surname8")
        );
        School sc = new School();
        Predicate<Student> pr = st -> st.getScore() >= 50 && st.getScore() < 70;;
        List<Student> rsl = sc.collect(students, pr);
        List<Student> expected = new ArrayList<>();
        expected.add(new Student(50, "Surname5"));
        expected.add(new Student(60, "Surname6"));
        assertThat(rsl).containsAll(expected);
    }

    @Test
    public void whenCollectClassV() {
        List<Student> students = List.of(
                new Student(10, "Surname1"),
                new Student(30, "Surname3"),
                new Student(40, "Surname4"),
                new Student(60, "Surname6"),
                new Student(90, "Surname9")
        );
        School sc = new School();
        Predicate<Student> pr = st -> st.getScore() < 50;
        List<Student> rsl = sc.collect(students, pr);
        List<Student> expected = new ArrayList<>();
        expected.add(new Student(10, "Surname1"));
        expected.add(new Student(30, "Surname3"));
        expected.add(new Student(40, "Surname4"));
        assertThat(rsl).containsAll(expected);
    }
}