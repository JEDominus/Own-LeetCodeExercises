package org.leetcode;

public class Main {
    public static void main(String[] args) {
        String string = "()[]{}";
        ValidParentheses validator = new ValidParentheses();
        System.out.println(
                "String: '" + string + "' on validation process... \n" +
                "Valid string?: " + validator.isValid(string)
        );
    }
}