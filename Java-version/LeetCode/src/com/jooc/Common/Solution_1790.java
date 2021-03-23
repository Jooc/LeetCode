package com.jooc.Common;

import com.jooc.GazeOffer.Solution;

public class Solution_1790 implements Solution {
    @Override
    public void main() {
        System.out.println(areAlmostEqual("kelb", "kelb"));
    }

    public boolean areAlmostEqual(String s1, String s2) {
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        if(chars1.length != chars2.length) return false;

        int mark = 0;
        int a = -1, b = -1;
        for(int i = 0; i < chars1.length; i++){
            if(chars1[i] != chars2[i]) {
                if (a == -1) a = i;
                else b = i;
                mark++;
            }
            if(mark > 2) return false;
        }
        if(a == -1) return b == -1;
        else return chars1[a] == chars2[b];
    }

}
