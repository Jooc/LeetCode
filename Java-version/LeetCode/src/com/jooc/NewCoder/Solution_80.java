package com.jooc.NewCoder;

import com.jooc.Solution;

public class Solution_80 implements Solution {

    @Override
    public void main() {
        System.out.println(maxProfit(new int[]{8, 9, 2, 5, 4, 7, 1}));
    }

    public int maxProfit_0(int[] prices) {
        // write code here

        int n = prices.length;
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(prices[i] + dp[i - 1][1], dp[i - 1][0]);
            dp[i][1] = Math.max(-prices[i], dp[i - 1][1]);
        }

        return dp[n - 1][0];
    }

    public int maxProfit(int[] prices) {
        // write code here

        int maxProfit = Integer.MIN_VALUE;
        int minBuyIn = Integer.MAX_VALUE;

        for(int price: prices){
            minBuyIn = Math.min(minBuyIn, price);
            maxProfit = Math.max(maxProfit, price - minBuyIn);
        }
        return maxProfit;
    }
}
