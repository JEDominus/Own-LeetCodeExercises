package org.leetcode;

public class Main {
    public static void main(String[] args) {
        SortedListMerger sorter = new SortedListMerger();
        ListNode[] lists = sorter.populateInput();
        ListNode result = sorter.mergeKLists(lists);
        System.out.print("Final linked list: ");
        sorter.printFinal(result);
    }
}