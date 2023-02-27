package com.jooc.NewCoder;

import com.jooc.Solution;

import java.util.Stack;

public class Solution_43 implements Solution {
    @Override
    public void main() {
        push(9);
        push(1);
        push(6);
        System.out.println(min());
        pop();
        pop();
        System.out.println(min());
    }
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    public void push(int node) {
        stack1.push(node);
        if (stack2.isEmpty()) {
            stack2.push(node);
        } else{
            stack2.push(Math.min(node, stack2.peek()));
        }
    }

    public void pop() {
        stack1.pop();
        stack2.pop();
    }

    public int top() {
        return stack1.peek();
    }

    public int min() {
        return stack2.peek();
    }
}