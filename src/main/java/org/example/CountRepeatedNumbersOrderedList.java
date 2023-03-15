package org.example;

public class CountRepeatedNumbersOrderedList {

    public static void main(String[] args) {
        int[] input = {1, 3, 3, 3, 4, 6, 9, 9, 12, 18};
        // 1 3 4 6 9 12 18 0 0 0
        CountRepeatedNumbersOrderedList app = new CountRepeatedNumbersOrderedList();
        int[] result = app.solve(input);
        for (int i : result) {
            System.out.println(i);
        }
    }

    private int[] solve(int[] input) {
        int[] output = new int[input.length];
        int i = 0;
        int j = 0;
        while (i + 1 < input.length) {
            if (input[i] != input[i + 1]) {
                output[j] = input[i];
                j++;
            }
            i++;
        }
        output[j] = input[i];
        return output;
    }
}
