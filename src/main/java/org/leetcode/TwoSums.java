package org.leetcode;

public class TwoSums {
    public int[] twoSum(int[] nums, int target){//Conatins the logic implemented, receive an array of int and a target num
        int [] result = new int[2]; //Instantiate the result array to return

        //Solution implemented is sum each element with the rest of them 'till sum was equals to target
        for(int i = 0; i < nums.length ; i++){//Cycle that select the first value to sum with the rest fo the array values
            if(i < nums.length-1){//This condition allow us to ask for sums while i was not the last item
                for(int j = i+1; j < nums.length; j++){//Cycle that pick the rest of the values and sums against i
                    if(nums[i] + nums[j] == target){//If both number sums the target number...
                        result[0] = i;//Add the position number to the first position in result array
                        result[1] = j;//Add the position number to the second position in result array

                        return result;//Array resultant is returned with the positions of the numbers that summed give target
                    }
                }
            }
        }
        return null; //Never used
    }
}
