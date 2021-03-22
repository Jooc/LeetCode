package com.jooc.Solutions;

import java.util.LinkedList;
import java.util.Stack;

public class Solution_30 {

    class MinStack {
        LinkedList<Integer> stack;
        LinkedList<Integer> minStack;

        /**
         * initialize your data structure here.
         */
        public MinStack() {
            stack = new LinkedList<>();
            minStack = new LinkedList<>();
        }

        public void push(int x) {
            stack.push(x);
            if (minStack.isEmpty() || x <= minStack.peek()) {
                minStack.push(x);
            }
        }

        public void pop() {
            if (minStack.peek().equals(stack.pop())) {
                minStack.pop();
            }
        }

        public int top() {
            return stack.peek();
        }

        public int min() {
            return minStack.peek();
        }
    }


}
