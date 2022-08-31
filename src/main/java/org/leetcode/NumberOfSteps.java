package org.leetcode;

public class NumberOfSteps {

    public int steps; //Store the final result, is global cuz is used in many methods

    public int reduceToZero(int number){ //Main public method to access from other classes
        steps = 0; //Initialize the global variable to set as 0 each time that main method was called
        reduceItRecursive(number); //Reduce process is performed recursively
        return steps; //When the recursive method ends, return the final result

    }

    private void reduceItRecursive(int number){ //Reduce the entry value recursively
        if(number > 0){ //Apply 'till the number reach to zero
            if (isPair(number)) { //Boolean flag to decide how the next step will reduce
                number /= 2; //Rule: if is pair, divide between 2
            } else {
                number -= 1; //Rule: if is non, rest by 1
            }
            steps++; //Save the step in the counter variable
            reduceItRecursive(number); //Call itself again
        }//When the number is equals to 0, method ends
    }

    private boolean isPair(int number){ //Method that returns truo if the entry value is pair
        return (number % 2 == 0) ? true : false;
    }

}
