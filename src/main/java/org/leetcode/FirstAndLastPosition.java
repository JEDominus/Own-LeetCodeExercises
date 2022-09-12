package org.leetcode;

public class FirstAndLastPosition {
    public int [] positions = {-1, -1}; // Array result instantiate

    public int [] searchRange(int[] nums, int target){

        for(int i = 0; i < nums.length; i++){//Fetch in the whole  array
            if(validateNum(nums[i], target)){//Validate if the current number is equals to the target
                if(positions[0] == -1){//Validates if the first position of result is already sued
                    positions[0] = i;//If not, put the firs position found in the first value
                }else{
                    positions[1] = i;//Else, put it in the second of the result array
                }
            }
        }

        FixUniqueNum(positions); //Validate if there are only 1 value

        return positions;//Return final result
    }

    private boolean validateNum(int num, int target){ //Validate each number against the target and return if is equal or not
        return num == target;
    }

    private void FixUniqueNum(int [] result){ //If there are 1 one value in target, override the second value
        if(result[0] != -1 && result[1] == -1){
            result[1] = result[0];
        }
    }

}
