package org.example.misc;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Prog8 {

    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 1, 4, 7, 5, 5, 4, 5, 4, 7, 10};
        Integer result = Arrays.stream(arr)
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .filter(entry -> 1 == entry.getValue())
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(null);
        System.out.println(result);
    }
}
