package com.jooc.NewCoder;

import com.jooc.Solution;

public class Solution_67 implements Solution {
    @Override
    public void main() {
        System.out.println(uniquePaths(1, 1));
    }

    public int uniquePaths_0(int m, int n) {
        // write code here

        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        for (int i = 1; i < m; i++) dp[i][0] = 1;
        for (int j = 1; j < n; j++) dp[0][j] = 1;

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    public int uniquePaths(int m, int n) {
        // write code here

        long res = 1;
        for(int i = 1; i < n; i++){
            res = res * (m+i-1) / i;
        }
        return (int) res;
    }

}
