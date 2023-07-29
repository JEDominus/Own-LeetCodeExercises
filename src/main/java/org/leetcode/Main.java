package org.leetcode;

public class Main {
    public static void main(String[] args) {
        PalindromeNumber palindromeNumber = new PalindromeNumber();
        int[] palindromeTest = {1, 515, -30, 187};

        for(int i = 0; i < palindromeTest.length; i++){
            System.out.println(String.format("Is %s palindrome... %s", palindromeTest[i], palindromeNumber.isPalindrome(palindromeTest[i])));
        }
    }
}