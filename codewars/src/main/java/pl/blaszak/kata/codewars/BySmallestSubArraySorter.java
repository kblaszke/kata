package pl.blaszak.kata.codewars;

import java.util.Arrays;

public class BySmallestSubArraySorter {

    public static int[] getIndexes(final int[] arr) {
        int[] ascArr = arr.clone();
        Arrays.sort(ascArr);
        int[] ascResults = findIndexes(arr, ascArr);
        int[] descResults = findIndexes(arr, reverseArr(ascArr));
        return indexLength(ascResults) < indexLength(descResults) ? ascResults : descResults;
    }

    private static int indexLength(int[] indexes) {
        return indexes[1] - indexes[0];
    }

    private static int[] reverseArr(int[] arr) {
        int[] reversedArr = arr.clone();
        for (int i = 0; i < arr.length; i++) {
            reversedArr[arr.length - i - 1] = arr[i];
        }
        return reversedArr;
    }

    private static int[] findIndexes(int[] arr, int[] sortedArr) {
        int[] results = new int[2];
        boolean existFirstIndex = false;
        for (int i = 0; i < arr.length; i++){
            if (arr[i] - sortedArr[i] != 0) {
                if (!existFirstIndex) {
                    results[0] = i;
                    existFirstIndex = true;
                }
                results[1] = i;
            }
        }
        return results;
    }
}
