package com.jooc.GazeOffer;

import java.util.Arrays;

public class Solution_66 implements Solution {
    @Override
    public void main() {
        System.out.println(Arrays.toString(constructArr(new int[]{1,2,3,4,5})));
    }

    public int[] constructArr(int[] a) {
        int len = a.length;
        int[] dp = new int[len];


        dp[0] = 1;
        for(int i = 1; i < len; i++){
            dp[i] = dp[i-1] * a[i-1];
        }

        int num = 1;
        for(int i = len-2; i >= 0; i--){
            num *= a[i+1];
            dp[i] = dp[i] * num;
        }

        return dp;
    }
}
