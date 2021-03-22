package com.jooc.GazeOffer;

public class Solution_13 {
    // DP - 343
    class Solution_DP{
        public int integerBreak(int n){
            int[] dp = new int[n + 1];
            dp[0] = 0; dp[1] = 1;

            for(int i = 2; i <= n; i++){
                int max = 0;
                for(int j = i - 1; j > 0; j--){
                    max = Math.max(max, Math.max(j*(i-j), j*dp[i-j]));
                }
                dp[i] = max;
            }

            return dp[n];
        }
    }
}
