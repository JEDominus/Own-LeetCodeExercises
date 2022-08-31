package org.leetcode;

public class Main {
    public static void main(String[] args) {
        String entryValue = "CMIX";
        RomanToInteger converter = new RomanToInteger();
        System.out.println(
                "Roman expression: " + entryValue + "\n" +
                "Integer equivalent: " + converter.romanToInt(entryValue) + "."
        );
    }
}