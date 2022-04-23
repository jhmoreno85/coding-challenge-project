package org.example;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.stream.Collectors;

@Slf4j
public class LargestNumberFormedFromString {

    public static void main(String[] args) {
        LargestNumberFormedFromString app = new LargestNumberFormedFromString();
        log.info(app.printLargest(new String[]{"500", "9", "1", "9"}));
    }

    private String printLargest(String[] arr) {
        return Arrays.stream(arr)
                .sorted((a, b) -> { // n log n
                    Integer ab = Integer.parseInt(a + b);
                    Integer ba = Integer.parseInt(b + a);
                    return ba.compareTo(ab);
                })
                .collect(Collectors.joining());
    }
}
