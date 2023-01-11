package ru.job4j.collection.dep;

import java.util.*;

public class Departments {

  /*  public static List<String> fillGaps(List<String> deps) {
        sortAsc(deps);
        Set<String> rsl = new LinkedHashSet<>();
        StringBuilder res = new StringBuilder();
        for (String word : deps) {
            String[] spl = word.split("");
            for (int i = 0; i < spl.length; i++) {
                if (spl[i].equals("/")) {
                    for (int j = 0; j < i; j++) {
                        res.append(spl[j]);
                    }
                } else if (i == spl.length - 1) {
                        for (int j = 0; j <= i; j++) {
                            res.append(spl[j]);
                        }
                    }
                    rsl.add(res.toString());
                    res.delete(0, res.length());
            }
        }
        return new ArrayList<>(rsl);
    }*/

    public static void sortAsc(List<String> orgs) {
        orgs.sort(Comparator.naturalOrder());
    }

    public static void sortDesc(List<String> orgs) {
        orgs.sort(new DepDescComp());
    }

    public static List<String> fillGaps(List<String> deps) {
        sortAsc(deps);
        Set<String> rsl = new LinkedHashSet<>();
        for (String name : deps) {
            String ob = "";
            for (String res : name.split("/")) {
                ob = ob.equals("") ? res : ob + "/" + res;
                rsl.add(ob);
            }
            ob = "";
        }
        return new ArrayList<>(rsl);
    }
}
