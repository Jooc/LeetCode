package com.jooc.NewCoder;

import com.jooc.Solution;

import java.util.Arrays;

public class Solution_75 implements Solution {
    @Override
    public void main() {
        System.out.println(editDistance("nowcoder", "new"));
    }

    public int editDistance(String str1, String str2) {
        // write code here

        int n1 = str1.length(), n2 = str2.length();
        if (n1 < 1 && n2 < 1) return 0;

        int[][] dp = new int[n1 + 1][n2 + 1];

        dp[0][0] = str1.charAt(0) == str2.charAt(0) ? 0 : 1;
        for (int i = 1; i <= n1; i++) {
            dp[i][0] = dp[i - 1][0] + 1;
        }
        for (int i = 1; i <= n2; i++) {
            dp[0][i] = dp[0][i - 1] + 1;
        }

        System.out.println(Arrays.deepToString(dp));
        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                }
            }
        }

        System.out.println(Arrays.deepToString(dp));
        return dp[n1][n2];
    }
}
