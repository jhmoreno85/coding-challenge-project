package org.example.misc;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Prog3 {

    public static void main(String[] args) {
        Prog3 app = new Prog3();
        Map<Character, List<String>> result = app.solve(List.of("Pedro", "pablo", "Juan", "Luis", "Ramon", "Carla", "Carmen"));
        System.out.println(result);
    }

    private Map<Character, List<String>> solve(List<String> list) {
        return list.stream()
                .collect(Collectors.groupingBy(s -> Character.toUpperCase(s.charAt(0))));
    }
}
