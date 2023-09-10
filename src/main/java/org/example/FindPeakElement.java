package org.example;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FindPeakElement {

    public static void main(String[] args) {
        int[] arr = {10, 20, 15, 2, 23, 90, 67, 100, 100, 150, 5};
        FindPeakElement app = new FindPeakElement();
        app.solve(arr);
    }

    private void solve(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (i + 1 < arr.length && arr[i - 1] < arr[i] && arr[i + 1] < arr[i]) {
                log.info("peak found={}", arr[i]);
            }
        }
    }
}
