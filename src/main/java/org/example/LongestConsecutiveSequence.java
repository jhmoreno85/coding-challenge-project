package org.example;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {

    public static void main(String[] args) {
        LongestConsecutiveSequence app = new LongestConsecutiveSequence();
        int[] list = {99, 100, 4, 98, 200, 6, 1, 3, 2, 101, 8, 102, 7, 5, 10, 103, 9, 104, 4};
        int result = app.solve(list);
        System.out.println(result);
    }

    private int solve(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int max = 0;
        for (int num : nums) {
            if (!set.contains(num - 1)) {
                int count = 1;
                int i = num + 1;
                while (set.contains(i)) {
                    i++;
                    count++;
                }
                max = Math.max(max, count);
            }
        }
        return max;
    }
}
