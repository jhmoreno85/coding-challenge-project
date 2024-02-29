package org.example.misc;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Prog2 {

    public static void main(String[] args) {
        Prog2 app = new Prog2();
        List<String> result = app.solve(
                List.of("123abc", "2aaa", "34sas"),
                List.of("asdasd", "123abc", "asdasdff", "2aaa", "xyz"),
                List.of("2aaa", "asdasd", "Asdafas"));
        result.forEach(System.out::println);
    }

    private List<String> solve(List<String> origins, List<String> stopovers, List<String> destinations) {
        Set<String> originSet = new HashSet<>(origins);
        Set<String> result = new HashSet<>();
        int max = Math.max(stopovers.size(), destinations.size());
        for (int i = 0; i < max; i++) {
            if (stopovers.size() > i && originSet.contains(stopovers.get(i))) {
                result.add(stopovers.get(i));
            }
            if (destinations.size() > i && originSet.contains(destinations.get(i))) {
                result.add(destinations.get(i));
            }
        }
        return new ArrayList<>(result);
    }
}
