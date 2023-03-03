package com.jooc.NewCoder;

import com.jooc.Solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

public class Solution_83 implements Solution {
    @Override
    public void main() {
        System.out.println(trans("This is a sample", 16));
    }

//    private String ReverseCap(String s) {
//        StringBuilder builder = new StringBuilder();
//        for (int i = 0; i < s.length(); i++) {
//            builder.append((char)(s.charAt(i) >= 'a' ? s.charAt(i)-32 : s.charAt(i)+32));
//        }
//        return builder.toString();
//    }
//
//    public String trans(String s, int n) {
//        // write code here
//
//        String[] list = s.split(" ");
//
//        StringBuilder res = new StringBuilder();
//        for (int i = list.length - 1; i >= 0; i--) {
//            res.append(ReverseCap(list[i]));
//            res.append(' ');
//        }
//        return res.toString();
//    }

    public String trans(String s, int n) {
        // write code here
        if (n == 0) return s;
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == ' ') res.append(' ');
            else {
                res.append((char) (s.charAt(i) >= 'a' ? s.charAt(i) - 32 : s.charAt(i) + 32));
            }
        }

        res = res.reverse();
        for(int i = 0; i < n; i++){
            int j = i;
            while(j < n && res.charAt(j) != ' ')
                j++;
            String temp = res.substring(i, j);
            StringBuilder buffer = new StringBuilder(temp);
            temp = buffer.reverse().toString();
            res.replace(i, j, temp);
            i = j;
        }

        return res.toString();
    }
}
