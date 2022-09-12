package org.leetcode;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        FirstAndLastPosition fetcher = new FirstAndLastPosition();
        int [] nums = {1};
        int target = 1;
        System.out.println(
                "Positions for " + target + " are " + Arrays.toString(fetcher.searchRange(nums, target))
        );
    }
}