package com.jooc.Solutions;

public class Solution_63 implements Solution {
    @Override
    public void main() {
        System.out.println(maxProfit(new int[]{7,1,5,3,6,4}));
    }

    public int maxProfit(int[] prices) {
        int dp = 0;
        int minCost = prices[0];

        for(int i = 1; i < prices.length; i++){
            dp = Math.max(dp, prices[i] - minCost);
            minCost = Math.min(minCost, prices[i]);
        }

        return dp;
    }
}
