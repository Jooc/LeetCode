package com.jooc.Solutions;

public class Solution_33 {

    public boolean verifyPostorder(int[] postorder) {
        return isPostOrder(postorder, 0, postorder.length - 1);
    }

    public boolean isPostOrder(int[] order, int begin, int end){
        if(begin >= end) return true;

        int index = begin;
        while (order[index] < order[end]) index++;
        int pivot = index;
        while(order[index] > order[end]) index++;

        return (index == end) && isPostOrder(order, begin, pivot-1) && isPostOrder(order, pivot, end-1);
    }
}
