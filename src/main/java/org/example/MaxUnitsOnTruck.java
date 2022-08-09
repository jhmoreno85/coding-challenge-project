package org.example;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

@Slf4j
public class MaxUnitsOnTruck {

    public static void main(String[] args) {
        int truckSize = 10; // max num of boxes
        int[][] units = new int[][]{{5, 10}, {2, 5}, {4, 7}, {3, 9}};
        log.info("{}", getMaxUnits(units, truckSize));
    }

    private static int getMaxUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, Collections.reverseOrder(Comparator.comparingInt(o -> o[1])));

        int totalUnits = 0;
        for (int[] boxType : boxTypes) {
            int numOfBoxes = boxType[0];
            int numUnitsPerBox = boxType[1];
            if (truckSize <= numOfBoxes) {
                totalUnits += truckSize * numUnitsPerBox;
                break;
            }
            totalUnits += numOfBoxes * numUnitsPerBox;
            truckSize -= numOfBoxes;
        }
        return totalUnits;
    }
}
