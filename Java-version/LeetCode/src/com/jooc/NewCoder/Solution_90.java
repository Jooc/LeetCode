package com.jooc.NewCoder;

import com.jooc.Solution;

import java.util.Arrays;
import java.util.HashMap;

public class Solution_90 implements Solution {
    @Override
    public void main() {
//        System.out.println(minWindow("XDOYEZODEYXNZ", "XYZ"));
//        System.out.println(minWindow("abcAbA", "AA"));
        System.out.println(minWindow("a", "b"));
    }

    private boolean checkHash(int[] hash) {
        for (int i : hash) {
            if (i < 0) return false;
        }
        return true;
    }

    public String minWindow(String S, String T) {
        // write code here
        int n1 = S.length(), n2 = T.length();
        if(n2 > n1) return "";

        int left = 0, right = 0;
        int[] hash = new int[58];

        for (Character ch : T.toCharArray()) {
            hash[ch - 'A'] -= 1;
        }

        System.out.println(Arrays.toString(hash));

        int minLen = Integer.MAX_VALUE;
        int[] pos = new int[2];
        while (right < n1) {
            while (right < n1) {
                hash[S.charAt(right++) - 'A'] += 1;
                if (checkHash(hash)) break;
            }
            while (left < right && checkHash(hash)) {
                hash[S.charAt(left++) - 'A'] -= 1;
            }
            int len = right - left + 1;
            if(len < minLen){
                minLen = len;
                pos[0] = left;
                pos[1] = right;
            }
        }

        return (left == 0 && !checkHash(hash)) ? "" : S.substring(pos[0] - 1, pos[1]);
    }
}
