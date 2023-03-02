package com.jooc.Common;

import com.jooc.Solution;

public class Solution_5 implements Solution {
    @Override
    public void main() {
        System.out.println(longestPalindrome("ac"));
    }

    public String longestPalindrome(String s) {
        // write code here
        int len = s.length();
        if (len < 2) return s;

        int maxLen = -1;
        int beginIndex = -1;
        boolean[][] dp = new boolean[len][len];

        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }

        for (int L = 2; L <= len; L++) {
            for (int i = 0; i < len; i++) {
                int j = i + L - 1;
                if (j >= len) break;
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = (L <= 3) || dp[i + 1][j - 1];
                    if (dp[i][j]) {
                        maxLen = Math.max(maxLen, L);
                        beginIndex = i;
                    }
                }
            }
        }

        return beginIndex != -1 ? s.substring(beginIndex, beginIndex + maxLen) : s.substring(0, 1);
    }
}
