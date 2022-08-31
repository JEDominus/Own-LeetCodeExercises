package org.leetcode;

public class RomanToInteger {
    public int romanToInt(String romanString){ //Main method, contains the main logic
        //Instantiate variables required
        char[] romanStringStripped = romanString.toCharArray(); //Array that strip the roman string into single values
        int[] romansConverted = new int[romanStringStripped.length]; //Array that save single values converted to int... Same length that entry value
        int result = 0; // Final result

        //Convert process...
        for(int i = 0; i < romanStringStripped.length; i++){
            romansConverted[i] = singleConversion(romanStringStripped[i]); //Each roman string value in array, call method to corresponding convertion
        }

        //Ask if is a rest & Sum values
        for(int i = 0; i < romansConverted.length; i++){ //for each single value in the romansConverted array...
            if(i < romanStringStripped.length-1 && isARest(romansConverted[i], romansConverted[i+1])){ //If is not the last value and is a rest
                result += romansConverted[i+1] - romansConverted[i]; //Take second value and rest the first one
                i++; //Do an additional step cuz are using 2 roman string values
            }else{
                result += romansConverted[i]; //Just increment the result value by last array item or is not a rest
            }
        }

        return result; //FLOW ENDS
    }

    public boolean isARest(int value, int next){ //Detects if a roman string composition is a rest or not passing value and next value
        if(value == 1){ //Applicable for IV and IX
            return (next == 5 || next == 10) ? true : false;
        }else if(value == 10){ //Applicable for XL and XC
            return (next == 50 || next == 100) ? true : false;
        }else if(value == 100){ //Applicable for CD and CM
            return (next == 500 || next == 1000) ? true : false;
        }
        return false;
    }

    public int singleConversion(char entryValue){ //convert a single roman char in a int
        switch(entryValue){ //Entry value is the single roman char
            case 'I': //Char variable is between 'single quotes', string are between "double quotes"
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
        }

        return 0;
    }
}
