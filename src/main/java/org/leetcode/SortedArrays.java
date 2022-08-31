package org.leetcode;

import java.util.Arrays;

public class SortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) { //Contains the main logic and the calls to other methods
        //Instantiate variables required
        int[] mergedNums = new int[nums1.length + nums2.length];//Merged array where both entry values will be inserted
        double[] convertedNums = new double[mergedNums.length];//Shell catcher when merged array will be converted from int to double

        mergedNums = arrayMerger(mergedNums, nums1, nums2);//Call internal method to merge arrays... Contains the merged and sorted array
        convertedNums = arrayConverter(convertedNums, mergedNums);//Call internal method, contains array converted

        return medianSolver(convertedNums);// Return the final result calling an internal method to solve the median
    }

    private int[] arrayMerger(int[] target, int[] array1, int[] array2){//Method that merge 2 arrays into one and sort values
        System.arraycopy(array1, 0 , target, 0 , array1.length);//Copy first array from position 0 to target from position 0 'till array1 length position
        System.arraycopy(array2, 0 , target, array1.length , array2.length);//Copy second array from position 0 to target from last position 'till array2 length position
        Arrays.sort(target);//Sort array values from lower to upper

        return target; //Return the merged amd sported array
    }

    private double[] arrayConverter(double[] target, int[] source){//Converts each int value in merged array to double value and insert them into double array
        for (int i = 0; i < source.length; i++){//For each merged array value
            target[i] = Double.valueOf(source[i]);//Convert it from int to double and insert it in double
        }

        return target; //Return the converted array
    }

    private double medianSolver(double[] source){//Calculate media of an array
        double median;//Final result

        //ask if array length is pair o non to implement corresponding logic
        if(isPair(source)){//If is pair
            //Take the "median" value and one before of that, sum them and divide between 2 (Returns decimals values)
            median = (source[source.length/2] + source[(source.length/2)-1])/2;
        }else{
            //Take the "median" value assign it to return (Returns entire values)
            median = Math.ceil(source[source.length/2]);
        }

        return median; //return final value
    }

    private boolean isPair(double[] array){//Detects if an array has length pair or non
        return array.length % 2 == 0;
    }
}
