package org.example.sort;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {101, 2, 5, 1, 10, 8, 100, 7, 15, 0, 9, 6};
        Arrays.stream(arr)
                .forEach(num -> System.out.print(num + " "));
        System.out.println("");
        QuickSort app = new QuickSort();
        app.quickSort(arr);
        Arrays.stream(arr)
                .forEach(num -> System.out.print(num + " "));
    }

    private void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private void quickSort(int[] arr, int low, int high) {
        if (low > high) {
            return;
        }
        int i = low;
        int j = high;
        int threshold = arr[low];
        while (i < j) {
            while (i < j && arr[j] > threshold) {
                j--;
            }
            if (i < j) {
                arr[i++] = arr[j];
            }
            while (i < j && arr[i] <= threshold) {
                i++;
            }
            if (i < j) {
                arr[j--] = arr[i];
            }
        }
        arr[i] = threshold;
        quickSort(arr, low, i - 1);
        quickSort(arr, i + 1, high);
    }
}
