package ru.job4j.collection.dep;

import java.util.*;

public class Departments {

    public static List<String> fillGaps(List<String> deps) {
        sortAsc(deps);
        Set<String> rsl = new LinkedHashSet<>();
        for (String name : deps) {
            String ob = "";
            for (String res : name.split("/")) {
                ob = "".equals(ob) ? res : ob + "/" + res;
                rsl.add(ob);
            }
        }
        return new ArrayList<>(rsl);
    }

    public static void sortAsc(List<String> orgs) {
        orgs.sort(Comparator.naturalOrder());
    }

    public static void sortDesc(List<String> orgs) {
        orgs.sort(new DepDescComp());
    }
}
