package com.jooc.NewCoder;

import com.jooc.Solution;

public class Solution_64 implements Solution {
    @Override
    public void main() {
        System.out.println(minCostClimbingStairs(new int[]{2, 5, 20}));
    }

    public int minCostClimbingStairs_0(int[] cost) {
        // write code here

        int n = cost.length;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 0;

        for (int i = 2; i <= n; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }

        return dp[n];
    }

    public int minCostClimbingStairs(int[] cost) {
        // write code here

        int n = cost.length;
        int a = 0, b = 0;
        int c = Math.min(cost[0], cost[1]);

        for (int i = 2; i <= n; i++) {
            c = Math.min(a + cost[i - 2], b + cost[i - 1]);
            a = b;
            b = c;
        }

        return c;
    }
}
