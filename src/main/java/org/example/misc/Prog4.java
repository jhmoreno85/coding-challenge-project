package org.example.misc;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Prog4 {

    public static void main(String[] args) {
        Prog4 app = new Prog4();
        Map<Integer, List<Character>> result = app.solve2(List.of(
                new Person("Paula", 32),
                new Person("Paul", 32),
                new Person("Jack", 37),
                new Person("Jill", 71),
                new Person("Sara", 20),
                new Person("Sara", 22)));
        System.out.println(result);
    }

    private Map<Integer, List<Character>> solve(List<Person> list) {
        return list.stream()
                .collect(Collectors.toMap(
                        Person::getAge,
                        person -> person.getName().chars()
                                .mapToObj(ch -> (char) ch)
                                .map(Character::toUpperCase)
                                .collect(Collectors.toList())));
    }

    private Map<Integer, List<Character>> solve2(List<Person> list) {
        return list.stream()
                .collect(Collectors.toMap(
                        Person::getAge,
                        person -> new ArrayList<>(person.getName().toUpperCase().chars()
                                .mapToObj(ch -> (char) ch)
                                .collect(Collectors.toSet())),
                        (prev, curr) -> {
                            prev.addAll(curr);
                            return prev;
                        }
                       ));
    }

    @Data
    @AllArgsConstructor
    static class Person {
        private String name;
        private Integer age;
    }
}
