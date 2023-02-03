package org.example;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.stream.Collectors;

@Slf4j
public class ReverseAnArray {

    public static void main(String[] args) {
        ReverseAnArray app = new ReverseAnArray();
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
        log.info("{}", Arrays.stream(app.solve(arr))
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(", ")));
    }

    public int[] solve(int[] arr) {
        int i = 0;
        while (i < arr.length / 2) {
            int aux = arr[i];
            arr[i] = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = aux;
            i++;
        }
        return arr;
    }
}
