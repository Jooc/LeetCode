package com.jooc.NewCoder;

import com.jooc.Solution;

public class Solution_86 implements Solution {
    @Override
    public void main() {
        System.out.println(solve("1", "99"));
        System.out.println(solve("2345", "1234"));
        System.out.println(solve("733064366", "459309139"));
    }

    public String solve_0(String s, String t) {
        // write code here

        int carry = 0;
        int n1 = s.length(), n2 = t.length();
        StringBuilder res = new StringBuilder();

        int i;
        for (i = 1; i <= n1 && i <= n2; i++) {
            int letter1 = s.charAt(n1 - i) - '0';
            int letter2 = t.charAt(n2 - i) - '0';

            res.append((letter1 + letter2 + carry) % 10);
            carry = (letter1 + letter2 + carry) / 10;
        }
        while (i <= n1) {
            int letter = s.charAt(n1 - i++) - '0';
            res.append((letter + carry) % 10);
            carry = (letter + carry) / 10;
        }
        while (i <= n2) {
            int letter = t.charAt(n2 - i++) - '0';
            res.append((letter + carry) % 10);
            carry = (letter + carry) / 10;
        }

        System.out.println(res);
//        while (carry != 0) {
//            if (res.charAt(res.length() - 1) == '9') {
//                res.deleteCharAt(res.length() - 1);
//                res.append(0);
//                carry = 1;
//            } else {
//                int val = res.charAt(res.length() - 1) - '0' + carry;
//                res.deleteCharAt(res.length() - 1);
//                res.append(val);
//                carry = 0;
//            }
//        }
        if (carry != 0) {
            res.append(carry);
        }

        return res.reverse().toString();
    }

    public String solve(String s, String t) {
        // write code here

        int carry = 0;
        int n1 = s.length() - 1, n2 = t.length() - 1;
        StringBuilder res = new StringBuilder();
        while (n1 >= 0 || n2 >= 0 || carry > 0) {
            int num1 = n1 >= 0 ? s.charAt(n1--) - '0' : 0;
            int num2 = n2 >= 0 ? t.charAt(n2--) - '0' : 0;

            int sum = num1 + num2 + carry;
            res.append(sum % 10);
            carry = sum / 10;
        }
        return res.reverse().toString();
    }
}
