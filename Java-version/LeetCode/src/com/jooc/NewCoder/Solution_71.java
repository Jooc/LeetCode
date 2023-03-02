package com.jooc.NewCoder;

import com.jooc.Solution;

import java.util.Arrays;

public class Solution_71 implements Solution {
    @Override
    public void main() {
//        System.out.println(LIS(new int[]{6, 3, 1, 5, 2, 3, 7}));
//        System.out.println(LIS(new int[]{1, 6, 4, 7, 5, 3, 2}));
        System.out.println(LIS(new int[]{0}));
    }

    public int LIS(int[] arr) {
        // write code here
        int n = arr.length;
        if (n <= 1) return n;

        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        int res = Integer.MIN_VALUE;
        for (int i = 1; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] < arr[i]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
            res = Math.max(res, dp[i]);
        }

        return res;
    }
}
