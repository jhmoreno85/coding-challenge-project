package org.example;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.stream.Collectors;

@Slf4j
public class MergeArrays {

    public static void main(String[] args) {
        int[] a = {1, 3, 5, 7, 9};
        int[] b = {0, 2, 4, 6, 8, 10, 11};
        MergeArrays app = new MergeArrays();
        log.info("{}", Arrays.stream(app.solve(a, b))
                .mapToObj(value -> String.valueOf(value))
                .collect(Collectors.joining(", ")));
    }

    private int[] solve(int[] a, int[] b) {
        int[] result = new int[a.length + b.length];
        int idxR = 0;
        int idxA = 0;
        int idxB = 0;
        while (idxR < result.length) {
            if (idxA < a.length && idxB < b.length) {
                if (a[idxA] <= b[idxB]) {
                    result[idxR] = a[idxA];
                    idxA++;
                } else {
                    result[idxR] = b[idxB];
                    idxB++;
                }
            } else if (idxA < a.length) {
                result[idxR] = a[idxA];
                idxA++;
            } else {
                result[idxR] = b[idxB];
                idxB++;
            }
            idxR++;
        }
        return result;
    }
}
