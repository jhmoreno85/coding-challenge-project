package org.example;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Slf4j
public class FindDuplicatesArray {

    public static void main(String[] args) {
        int[] input = {1, 2, 8, 7, 10, 5, 0, 35, 100, 9, 200, 250, 101, 0, 100};
        FindDuplicatesArray app = new FindDuplicatesArray();
        app.solve(input);
    }

    private void solve(int[] arr) {
        Set<Integer> set = new HashSet<>();
        Arrays.stream(arr)
                .filter(value -> !set.add(value))
                .forEach(value -> log.info("duplicate -> {}", value));
    }
}
