package org.leetcode;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] entryValue = {3, 2, 4};
        int target = 6;
        TwoSums fetcher = new TwoSums();
        System.out.println(
                "Given: " + Arrays.toString(entryValue) + "... \n" +
                "When target is: " + target + "... \n" +
                "The positions that sums " + target + " are: " + Arrays.toString(fetcher.twoSum(entryValue, target)) + "."
        );
    }
}