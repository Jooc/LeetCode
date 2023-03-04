package com.jooc.NewCoder;

import com.jooc.Solution;

public class Solution_76 implements Solution {
    @Override
    public void main() {
        System.out.println(match("aaa", "a*a"));
        System.out.println(match("aaab", "a*a*a*c"));
        System.out.println(match("a", "ab*a"));
        System.out.println(match("aaa", "aa*"));
    }

    public boolean match(String str, String pattern) {
        // write code here
        int n1 = str.length(), n2 = pattern.length();
        boolean[][] dp = new boolean[n1 + 1][n2 + 1];

        dp[0][0] = true;
        for (int i = 1; i <= n2; i++) {
            dp[0][i] = pattern.charAt(i - 1) == '*' && dp[0][i - 2];
        }
//        for(int i = 1; i <= n1; i++){
//            dp[i][0] = false;
//        }
//        System.out.println(Arrays.deepToString(dp));

        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                if (pattern.charAt(j - 1) != '*') {
                    dp[i][j] = (str.charAt(i - 1) == pattern.charAt(j - 1) || pattern.charAt(j - 1) == '.') && dp[i - 1][j - 1];
                } else {
                    if (pattern.charAt(j - 2) == '.' || pattern.charAt(j - 2) == str.charAt(i - 1)) {
                        dp[i][j] = dp[i - 1][j];
                    }
                    dp[i][j] |= dp[i][j - 2];
                }
            }
        }

//        System.out.println(Arrays.deepToString(dp));

        return dp[n1][n2];
    }
}
