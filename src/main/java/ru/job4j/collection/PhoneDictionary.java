package ru.job4j.collection;

import java.util.ArrayList;

public class PhoneDictionary {

    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);

    }

    public ArrayList<Person> find(String key) {
        ArrayList<Person> result = new ArrayList<>();
        for (int index = 0; index < persons.size(); index++) {
            if (persons.get(index).getName().contains(key) && persons.get(index).getSurname().contains(key)
                    && persons.get(index).getPhone().contains(key) && persons.get(index).getAddress().contains(key)) {
                result.add(persons.get(index));
            }
        }
        return result;
    }
}
