package org.leetcode;

public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        String entryNumber = String.valueOf(x); // Convert int in string
        String reversedNumber = ""; // Generate the reverse number

        for(int i = 0; i < entryNumber.length(); i++){ // Go one by one from original
            reversedNumber = entryNumber.charAt(i) + reversedNumber; // Reverse current int every lap
        }

        return reversedNumber.equals(entryNumber); // Return tru if both are equals
    }
}
