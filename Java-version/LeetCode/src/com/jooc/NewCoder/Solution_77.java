package com.jooc.NewCoder;

import com.jooc.Solution;

import java.util.Stack;

public class Solution_77 implements Solution {
    @Override
    public void main() {
        System.out.println(longestValidParentheses("(()"));
        System.out.println(longestValidParentheses("(())"));
        System.out.println(longestValidParentheses("()()"));
        System.out.println(longestValidParentheses("())"));
        System.out.println(longestValidParentheses(")()(()()((((((())("));
        System.out.println(longestValidParentheses("(()"));
        System.out.println(longestValidParentheses("()(())"));
    }

    public int longestValidParentheses_0(String s) {
        // write code here

        Stack<Integer> stack = new Stack<>();
        int maxLen = 0;
        int beginIndex = -1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') stack.push(i);
            else {
                if (stack.isEmpty()) {
                    beginIndex = i;
                    continue;
                }
                if (s.charAt(stack.peek()) == '(') {
                    stack.pop();
                    if (stack.isEmpty()) {
                        maxLen = Math.max(maxLen, i - beginIndex);
                    } else {
                        maxLen = Math.max(maxLen, i - stack.peek());
                    }
                }
            }
        }
        return maxLen;
    }

    public int longestValidParentheses(String s) {
        // write code here
        int[] dp = new int[s.length()];
        int maxLen = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = i >= 2 ? dp[i - 2] + 2 : 2;
                } else {
                    if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                        dp[i] = (i - dp[i - 1] - 2 >= 0 ? dp[i - dp[i - 1] - 2] : 0) + dp[i-1] + 2;
                    }
                }
                maxLen = Math.max(maxLen, dp[i]);
            }
        }
        return maxLen;
    }
}

