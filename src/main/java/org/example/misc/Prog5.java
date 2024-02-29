package org.example.misc;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Prog5 {

    public static void main(String[] args) {
        Prog5 app = new Prog5();
        Map<Integer, List<String>> result = app.solve(List.of(
                new Person("Paula", 32),
                new Person("Paul", 31),
                new Person("Jack", 42),
                new Person("Jill", 71),
                new Person("Sara", 20),
                new Person("George", 47),
                new Person("Lili", 22),
                new Person("Yong", 13)));
        System.out.println(result);
    }

    private Map<Integer, List<String>> solve(List<Person> list) {
        return list.stream()
                .filter(person -> person.getAge() >= 18)
                .sorted(Comparator.comparing(Person::getName))
                .collect(Collectors.groupingBy(
                        person -> person.getAge() / 10 * 10,
                        Collectors.mapping(Person::getName, Collectors.toList())));
    }

    @Data
    @AllArgsConstructor
    static class Person {
        private String name;
        private Integer age;
    }
}
