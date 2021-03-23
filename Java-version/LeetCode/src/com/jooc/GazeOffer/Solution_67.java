package com.jooc.GazeOffer;

import com.jooc.Solution;

public class Solution_67 implements Solution {
    @Override
    public void main() {
        System.out.println(strToInt("-2147483647"));
    }

    public int strToInt(String str) {
        char[] chars = str.trim().toCharArray();
        if(chars.length == 0) return 0;
        int res = 0, boundary = Integer.MAX_VALUE/10;
        int i = 1, sign = 1;

        if(chars[0] == '-') sign = -1;
        else if(chars[0] != '+') i = 0;

        for(; i < chars.length; i++){
            if(chars[i] < '0' || chars[i] > '9') break;
            if(res > boundary || res == boundary && chars[i] > '7') return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            res = res * 10 + (chars[i] - '0');
        }

        return sign == 1 ? res : -res;
    }
}
