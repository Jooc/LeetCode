package com.jooc.NewCoder;

import com.jooc.Solution;

import java.util.Stack;

public class Solution_44 implements Solution {
    @Override
    public void main() {

    }

    public boolean isValid_0(String s) {
        // write code here
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (stack.isEmpty() || ch == '(' || ch == '{' || ch == '[')
                stack.push(ch);
            else {
                if (ch == ')') {
                    if (stack.peek() != '(')
                        return false;
                    else
                        stack.pop();
                }
                if (ch == '}') {
                    if (stack.peek() != '{')
                        return false;
                    else
                        stack.pop();
                }
                if (ch == ']') {
                    if (stack.peek() != '[')
                        return false;
                    else
                        stack.pop();
                }
            }
        }
        return stack.isEmpty();
    }

    public boolean isValid(String s) {
        // write code here
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(ch == '(')
                stack.push(')');
            else if(ch == '[')
                stack.push(']');
            else if(ch == '{')
                stack.push('}');
            else{
                if (stack.isEmpty() || stack.pop() != ch)
                    return false;
            }
        }
        return stack.isEmpty();
    }
}