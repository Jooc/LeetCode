package com.jooc.Common;

import com.jooc.Solution;

import java.util.Arrays;

public class Solution_213 implements Solution {
    @Override
    public void main() {

    }

    public int rob_0(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        if (n == 1) return nums[0];

        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = nums[0];
        for (int i = 2; i < n - 1; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        System.out.print(Arrays.toString(dp));

        int res = dp[n - 2];

        dp[0] = 0;
        dp[1] = nums[1];
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        System.out.print(Arrays.toString(dp));

        return Math.max(res, dp[n - 1]);
    }

    private int myRob(int[] nums) {
        int pre = 0, cur = 0, temp;
        for (int num : nums) {
            temp = cur;
            cur = Math.max(pre + num, cur);
            pre = temp;
        }
        return cur;
    }

    public int rob(int[] prices) {
        int n = prices.length;
        if (n == 0) return 0;
        if (n == 1) return prices[0];


        return Math.max(
                myRob(Arrays.copyOfRange(prices, 0, n - 1)),
                myRob(Arrays.copyOfRange(prices, 1, n)));
    }
}
