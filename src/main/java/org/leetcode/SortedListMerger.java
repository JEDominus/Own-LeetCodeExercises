package org.leetcode;

public class SortedListMerger {
    public ListNode mergeKLists(ListNode[] lists){
        if(isValidList(lists)){//1 - Validate input to fast shut down or continue
            int[] valuesRange = collectValuesRange(lists);//2 - Get lowest and upper values in lists to start to sort from lower to upper
            ListNode listMerged = listMerger(lists, valuesRange);//3 - Call the list merger method to move the values into a only list
            return listMerged;
        }else{
            return new ListNode().next;
        }
    }

    private boolean isValidList(ListNode[] lists){ //Method that validate if the provided array is valid
        if(lists.length > 0){ //It must contain at least one linked list
            for(int i = 0; i < lists.length; i++){ //Fetch the whole array, all lists
                ListNode currentNode = lists[i]; //Starting with the current valua as the firs of a list

                if(currentNode != null){ //array is valid when a list contain at least a value
                    return true; //Then return that is a valid array
                }
            }
        }

        return false; //Array is empty or list are empty
    }

    private int[] collectValuesRange(ListNode[] lists){ //This method detects the lowest and upper value fetching all lists
        int[] valuesRange = {0,0}; //As default, we set the lowest and upper value as the firs value of the first list

        for (int i = 0; i < lists.length; i++){ //Let's fetch all list one by one
            ListNode currentNode = lists[i]; //Define the starter node as the first of the current list

            if(currentNode != null){ //Validate that entry valua was not null
                while(currentNode != null){ //This cycle read from first 'till last node in a list
                    if(currentNode.val < valuesRange[0]){ //Current value is lower than current lower
                        valuesRange[0] = currentNode.val; //Override the lowest value with the new one found
                    }else if(currentNode.val > valuesRange[1]){ //Current value is upper than current upper
                        valuesRange[1] = currentNode.val; //Override the upper value with the new one found
                    }
                    currentNode = currentNode.next; //Move forward with the next node in the list
                }
            }
        }

        return valuesRange; //Return the lowest [0] and upper [1] values found in all lists
    }

    private ListNode listMerger(ListNode[] lists, int[] valuesRange){ //This method will fetch each value in the list and sort them in ascending mode
        ListNode firstNode = new ListNode(); //Define the first node added to the final merged and sorted list
        ListNode lastNode = new ListNode(); //Define the last node added to the final merged and sorted list
        boolean firstCreated = false;

            for (int pointer = valuesRange[0] ; pointer < valuesRange[1]+1; pointer++){//Will fetch a value 1 by 1 from the lower to the upper value found in lists
                for(int i = 0; i < lists.length; i++){//Will fetch the whole lists array
                    ListNode currentNode = lists[i];//Set the initial node of a list as the first one

                    if(currentNode != null){ //Validate that entry valua was not null
                        while(currentNode != null){//while the list contains an unevaluated node, will continue
                            if(currentNode.val == pointer){//pointer will increase 1 by 1 from lowest to upper to detect and add node in a ascending mode
                                ListNode newNode = new ListNode(currentNode.val);//If a node is detected as "next" to add in the list, will create a new node

                                if(!firstCreated){//If the first one was not created yet
                                    firstNode = newNode;//Set the new node as the first one
                                    lastNode = firstNode;//And the last as well
                                    firstCreated = true;//Set the flag true to don't entry to this flow again
                                }else{//If the first node was already created
                                    lastNode.next = newNode;//Add the new one to the next value of the last
                                    lastNode = newNode;//Move the last node position to the new one
                                }
                            }
                            currentNode = currentNode.next;//Move forward with the next node
                        }
                    }
                }
            }

        return firstNode;//Return the first node cuz is the first one of the list
    }

    //LOCAL METHODS REGION
    public ListNode[] populateInput(){//Make 3 different lists to test
        ListNode l1n3 = new ListNode(13);
        ListNode l1n2 = new ListNode(12, l1n3);
        ListNode l1n1 = new ListNode(10, l1n2);

        ListNode l2n2 = new ListNode(5);
        ListNode l2n1 = new ListNode(3, l2n2);

        ListNode l3n5 = new ListNode(10);
        ListNode l3n4 = new ListNode(3, l3n5);
        ListNode l3n3 = new ListNode(0, l3n4);
        ListNode l3n2 = new ListNode(-3, l3n3);
        ListNode l3n1 = new ListNode(-5, l3n2);

        ListNode[] lists = {l1n1, l2n1, l3n1};

        return lists;
    }

    public void printFinal(ListNode list){ //Print the list in console
        ListNode currentNode = list;

        while(currentNode != null){
            System.out.print(currentNode.val + " ");
            currentNode = currentNode.next;
        }
    }
}
