package com.jooc.NewCoder;

import com.jooc.Solution;

public class Solution_79 implements Solution {
    @Override
    public void main() {

    }

    public int rob(int[] nums) {
        // write code here
        int n = nums.length;
        int[] dp = new int[n];
        int res = 0;

        dp[0] = nums[0];
        dp[1] = nums[1];
        for (int i = 2; i < n - 1; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        dp[n-1] = dp[n-2];
        res = dp[n-1];

        dp = new int[n];
        dp[0] = 0;
        dp[1] = nums[1];
        for(int i = 2; i < n; i++){
            dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i]);
        }
        res = Math.max(res, dp[n-1]);

        return res;
    }
}
