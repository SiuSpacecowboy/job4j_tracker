package ru.job4j.stream.fin;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Analyze {

    public static double averageScore(Stream<Pupil> stream) {
        return stream
                .flatMap(val -> val.subjects().stream())
                .mapToInt(Subject::score)
                .average()
                .orElse(0);
    }

    public static List<Tuple> averageScoreByPupil(Stream<Pupil> stream) {
        return stream
                .map(val -> new Tuple(val.name(), val.subjects().stream()
                        .mapToInt(Subject::score)
                        .average()
                        .orElse(0)))
                .toList();
    }

    public static List<Tuple> averageScoreBySubject(Stream<Pupil> stream) {
        Map<String, Double> res = stream
                .flatMap(val -> val.subjects().stream())
                .collect(Collectors.groupingBy(
                        Subject::name,
                        Collectors.averagingDouble(Subject::score)
                ));
        return res.entrySet().stream()
                .map(val -> new Tuple(val.getKey(), val.getValue()))
                .toList();
    }

    public static Tuple bestStudent(Stream<Pupil> stream) {
        return stream
                .map(val -> new Tuple(val.name(), val.subjects().stream()
                        .mapToInt(Subject::score)
                        .sum()))
                .max(Comparator.comparingDouble(Tuple::score))
                .orElse(null);
    }

    public static Tuple bestSubject(Stream<Pupil> stream) {
        Map<String, Double> res = stream
                .flatMap(val -> val.subjects().stream())
                .collect(Collectors.groupingBy(
                        Subject::name,
                        Collectors.summingDouble(Subject::score)
                ));
        return res.entrySet().stream()
                .map(val -> new Tuple(val.getKey(), val.getValue()))
                .max(Comparator.comparingDouble(Tuple::score))
                .orElse(null);
    }
}