package org.example;

import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;
import java.util.Set;

@Slf4j
public class FindDuplicateArray {

    public static void main(String[] args) {
        int[] input = {1, 2, 8, 7, 10, 5, 0, 35, 100, 9, 200, 250, 101, 0};
        FindDuplicateArray app = new FindDuplicateArray();
        log.info("duplicate number is: {}", app.solve(input));

    }

    private int solve(int[] arr) {
        if (0 == arr.length) {
            return -1;
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            if (set.contains(arr[i])) {
                return arr[i];
            } else {
                set.add(arr[i]);
            }
        }
        return -1;
    }
}
