package ru.job4j.collection;

import java.util.HashMap;
import java.util.Map;

public class UsageMap {

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("danvitaly14@mail.ru", "Danyukovas Vitaly");
        for (String key : map.keySet()) {
            String val = map.get(key);
            System.out.println(key + " -> " + val);
        }
    }
}
