package org.leetcode;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        SortedArrays processor = new SortedArrays();
        int[] a = {1, 2};
        int[] b = {3, 4};
        System.out.println(
                "Given 2 different arrays: \nArray1: " + Arrays.toString(a) + ". \nArray2: " + Arrays.toString(b) + ".\n" +
                "Median is: " + processor.findMedianSortedArrays(a, b) + "."
        );
    }
}