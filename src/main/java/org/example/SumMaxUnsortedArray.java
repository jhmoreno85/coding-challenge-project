package org.example;

public class SumMaxUnsortedArray {

    public static void main(String[] args) {
        int[] input = { 1, 10, 2, 0, 80, 100, 55, 13, 999, 15 };
        SumMaxUnsortedArray app = new SumMaxUnsortedArray();
        int result = app.solve(input);
        System.out.println("max sum: " + result);
    }

    private int solve(int[] arr) {
        int max = Integer.MIN_VALUE;
        int maxIndex = 0;
        for (int i = 1; i < arr.length; i++) {
            int currSum = arr[maxIndex] + arr[i];
            if (currSum > max) {
                max = currSum;
                if (arr[maxIndex] < arr[i]) {
                    maxIndex = i;
                }
            }
        }
        return max;
    }
}
