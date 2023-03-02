package com.jooc.NewCoder;

import com.jooc.Solution;

public class Solution_72 implements Solution {
    @Override
    public void main() {
        System.out.println(FindGreatestSumOfSubArray(new int[]{1,-2,3,10,-4,7,2,-5}));
    }

    public int FindGreatestSumOfSubArray(int[] array) {
        int dp = array[0];
        for(int i = 1; i < array.length; i++){
            dp = Math.max(dp + array[i], array[i]);
        }

        return dp;
    }
}
