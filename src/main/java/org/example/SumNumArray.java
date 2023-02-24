package org.example;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class SumNumArray {

    public static void main(String[] args) {
        int[] input = { 1, 10, 2, 0, 80, 100, 55, 13, 999, 15 };
        SumNumArray app = new SumNumArray();
        int[] result = app.solve(input, 1000);
        log.info("result: [{}, {}]", result[0], result[1]);
    }

    private int[] solve(int[] arr, int target) {
        int[] result = {-1, -1};
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(target - arr[i])) {
                result[0] = map.get(target - arr[i]);
                result[1] = i;
                break;
            } else {
                map.put(arr[i], i);
            }
        }
        return result;
    }
}
