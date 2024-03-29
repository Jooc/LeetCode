package com.jooc.NewCoder;

import com.jooc.Solution;

public class Solution_68 implements Solution {
    @Override
    public void main() {

    }

    public int minPathSum(int[][] matrix) {
        // write code here
        int n = matrix.length, m = matrix[0].length;
        int[][] dp = new int[n][m];
        dp[0][0] = matrix[0][0];

        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i - 1][0] + matrix[i][0];
        }
        for (int i = 1; i < m; i++) {
            dp[0][i] = dp[0][i - 1] + matrix[0][i];
        }

        for(int i = 1; i < n; i++){
            for(int j = 1; j < m; j++){
                dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + matrix[i][j];
            }
        }

        return dp[n-1][m-1];
    }
}
