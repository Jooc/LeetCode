package com.jooc.Solutions;

import java.util.LinkedList;

public class Solution_31 {

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        LinkedList<Integer> stack = new LinkedList<>();
        int i = 0;
        for(int num : pushed){
            stack.push(num);
            while(stack.peek().equals(popped[i])){
                stack.pop();
                i++;
            }
        }
        return stack.isEmpty();
    }
}
