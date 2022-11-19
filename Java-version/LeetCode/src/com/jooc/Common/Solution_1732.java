package com.jooc.Common;

public class Solution_1732 {
    public int largestAltitude(int[] gain) {
        int height = 0, ans = 0;

        for(int x : gain){
            height += x;
            ans = Math.max(height, ans);
        }

        return ans;
    }
}