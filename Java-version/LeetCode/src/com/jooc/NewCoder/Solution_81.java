package com.jooc.NewCoder;

import com.jooc.Solution;

public class Solution_81 implements Solution {
    @Override
    public void main() {
        System.out.println(maxProfit(new int[]{8, 9, 2, 5, 4, 7, 1}));
    }

    public int maxProfit_0(int[] prices) {
        // write code here

        int n = prices.length;
        int[][] dp = new int[n][2];
        dp[0][1] = -prices[0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], prices[i] + dp[i - 1][1]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[n - 1][0];
    }

    public int maxProfit(int[] prices) {
        // write code here

        int n = prices.length;
        int profit = 0;

        for(int i = 1; i < n; i++){
            if(prices[i] > prices[i-1])
                profit += prices[i] - prices[i-1];
        }


        return profit;
    }
}
