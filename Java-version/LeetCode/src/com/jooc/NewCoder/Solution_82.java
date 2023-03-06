package com.jooc.NewCoder;

import com.jooc.Solution;

import java.util.Arrays;

public class Solution_82 implements Solution {
    @Override
    public void main() {
        System.out.println(maxProfit(new int[]{8, 9, 3, 5, 1, 3}));
    }

    public int maxProfit(int[] prices) {
        // write code here
        int n = prices.length;
        int[][] dp = new int[n][4];
        Arrays.fill(dp[0], -10000);
        dp[0][0] = -prices[0];

        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], -prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], prices[i] + dp[i - 1][0]);
            dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1] - prices[i]);
            dp[i][3] = Math.max(dp[i - 1][3], prices[i] + dp[i - 1][2]);
        }

        return Math.max(dp[n - 1][1], dp[n - 1][3]);
    }

}
