package ru.job4j.collection.attestation;

import java.util.*;

public class AnalyzeByMap {

    public static double averageScore(List<Pupil> pupils) {
        double res = 0;
        for (Pupil stud : pupils) {
            double total = 0;
            for (Subject name : stud.subjects()) {
                total += name.score();
            }
            res += total / stud.subjects().size();
        }
        return res / pupils.size();
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> students = new LinkedList<>();
        double res = 0;
        for (Pupil stud : pupils) {
            double total = 0;
            for (Subject name : stud.subjects()) {
                total += name.score();
            }
            students.add(new Label(stud.name(), total / stud.subjects().size()));
        }
        return students;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        Map<String, Integer> rsl = new LinkedHashMap<>();
        List<Label> subj = new ArrayList<>();
        for (Pupil stud : pupils) {
            for (Subject name : stud.subjects()) {
                if (rsl.get(name.name()) == null) {
                    rsl.putIfAbsent(name.name(), name.score());
                } else {
                    rsl.put(name.name(), rsl.get(name.name()) + name.score());
                }
            }
        }
        for (String key : rsl.keySet()) {
            subj.add(new Label(key, (double) rsl.get(key) / pupils.size()));
        }
        return subj;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        List<Label> students = averageScoreByPupil(pupils);
        students.sort(Comparator.naturalOrder());
        return students.get(students.size() - 1);
    }

    public static Label bestSubject(List<Pupil> pupils) {
        List<Label> subjects = averageScoreBySubject(pupils);
        subjects.sort(Comparator.naturalOrder());
        return subjects.get(subjects.size() - 1);
    }
}
