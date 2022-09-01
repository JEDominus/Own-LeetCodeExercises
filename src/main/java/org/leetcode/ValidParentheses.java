package org.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ValidParentheses {
    List<String> openParenthesisList; //Dynamic list that add and remove the open parenthesis... Let us know what kind of it was the las opened

    public boolean isValid(String entryValue) { //Main method that allow the whole logic
        String[] entryValueAsArray = entryValue.split(""); //Split the entry string into characters and add them to a String array
        List<String> parenthesisStringList = Arrays.asList(entryValueAsArray); //Convert the String array in a String list
        openParenthesisList = new ArrayList<>(); //Instantiate the open parenthesis list

        if(validInitialList(parenthesisStringList.size())){//Filter 1: Entry string must have pair size... if not, return false
            for(int i = 0; i < parenthesisStringList.size(); i++){//Cycle that travel the whole parenthesis string
                if(candidateValidation(parenthesisStringList.get(i))){//Filter 2: if the current list value ios a candidate to continue with the cycle
                    popIfIsCloseValue(parenthesisStringList.get(i));//Manage the action according if is open or close parenthesis
                }else{ //If candidate broke the type open-close rules... is an invalid string, then return false
                    return false; //Entry string is not valid
                }
            }
            return openParenthesisList.size() == 0; //Last open parenthesis was closed successfully
        }
        return false;//Entry string was not pair size
    }

    private boolean validInitialList(int size){//Evaluate the size of the entry string
        return size % 2 == 0;//If size is pair, return true
    }

    private boolean candidateValidation(String candidate){//Evaluates if the current string value can break the type open/close rule
        switch(candidate){//If value evaluated is a close kind, it must be of the same type that the last open one
            case ")": //If is normal close
                return openParenthesisList.size() > 0 && openParenthesisList.get(openParenthesisList.size()-1).equals("(");//last one opened must be normal open
            case "]"://If is bracket close
                return openParenthesisList.size() > 0 && openParenthesisList.get(openParenthesisList.size()-1).equals("[");//last one opened must be bracket open
            case "}"://If is curly bracket close
                return openParenthesisList.size() > 0 && openParenthesisList.get(openParenthesisList.size()-1).equals("{");//last one opened must be curly bracket open
            default: //If is open (any kind)
                openParenthesisList.add(candidate);//Add it to the open list and continue
                return true;
        }
    }

    private void popIfIsCloseValue(String value){//remove the last one opened if the entry value is any kind of closed parenthesis
        switch(value){
            case ")":
            case "]":
            case "}":
                openParenthesisList.remove(openParenthesisList.size()-1);//remove the last opened to leave the last position to the before opened one
                break;
        }
    }
}
