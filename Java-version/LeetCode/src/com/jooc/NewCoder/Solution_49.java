package com.jooc.NewCoder;

import com.jooc.Solution;

import java.util.*;

public class Solution_49 implements Solution {
    @Override
    public void main() {
        System.out.println(solve("3+2*3*4-1"));
        System.out.println(solve("(2*(3-4))*5"));
        System.out.println(solve("1+2"));
        System.out.println(solve("(3+4)*(5+(2-3))-2"));
        System.out.println(solve("((10+2)*10-(100-(10+20*10-(2*3)))*10*1*2)-2"));
    }

//    Map<Character, Integer> priority = new HashMap<Character, Integer>() {{
//        put('-', 1);
//        put('+', 1);
//        put('*', 2);
//    }};

//    Stack<Integer> nums = new Stack<>();
//    Stack<Character> ops = new Stack<>();
//
//    private int calculate() {
//        int num2 = nums.pop(), num1 = nums.pop();
//        char op = ops.pop();
//        if (op == '+') return num1 + num2;
//        else if (op == '-') return num1 - num2;
//        else return num1 * num2;
//    }

//    public int solve(String s) {
//        // write code here
//        char[] cs = s.toCharArray();
//        int n = s.length();
//
//        int i = 0;
//        while (i < n) {
//            char c = cs[i];
//            if ('0' <= c && c <= '9') {
//                int val = 0;
//                while (i < n && '0' <= cs[i] && cs[i] <= '9') {
//                    val = val * 10 + (cs[i++] - '0');
//                }
//                i--;
//                nums.push(val);
//            } else if (c == '(') {
//                ops.push(c);
//            } else if (c == ')') {
//                nums.push(calculate());
//                ops.pop();
//            } else {
//                while (!this.ops.isEmpty() && this.ops.peek() != '(' && this.priority.get(ops.peek()) >= this.priority.get(c)) {
////                    nums.push(0);
//                    nums.push(calculate());
//                }
//                ops.push(c);
//            }
//            i++;
//        }
//        while (nums.size() != 1) {
//            nums.push(calculate());
//        }
//        return nums.pop();
//    }

    public ArrayList<Integer> function(String s, int index) {
        // write code here
        Stack<Integer> stack = new Stack<>();
        int a = ((2));
        char op = '+';
        int num = 0;
        int n = s.length();

        int i;
        for (i = index; i < n; i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + c - '0';
                if (i != s.length() - 1)
                    continue;
            }
            if (c == '(') {
                ArrayList<Integer> res = function(s, i + 1);
                num = res.get(0);
                i = res.get(1);
                if (i != s.length() - 1)
                    continue;
            }
            switch (op) {
                case '+':
                    stack.push(num);
                    break;
                case '-':
                    stack.push(-num);
                    break;
                case '*':
                    int temp = stack.pop();
                    stack.push(temp * num);
                    break;
            }
            num = 0;
            if (c == ')')
                break;
            else
                op = c;
        }
        int sum = 0;
        while (!stack.isEmpty())
            sum += stack.pop();
        ArrayList<Integer> temp = new ArrayList<Integer>();
        temp.add(sum);
        temp.add(i);
        return temp;
    }

    public int solve(String s) {
        ArrayList<Integer> res = function(s, 0);
        return res.get(0);
    }
}
