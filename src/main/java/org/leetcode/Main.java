package org.leetcode;

public class Main {
    public static void main(String[] args) {
        int entryValue = 123;
        NumberOfSteps reducer = new NumberOfSteps();
        System.out.println(
                "Steps required to reduce: " + entryValue + " to zero is: " + reducer.reduceToZero(entryValue) + " steps."
        );
    }
}