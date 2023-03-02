package com.jooc.NewCoder;

import com.jooc.Solution;

import java.util.Arrays;

public class Solution_73 implements Solution {
    @Override
    public void main() {
        System.out.println(getLongestPalindrome_0("babcaaccabab"));
    }

    private int getLen(String str, int left, int right) {
        while (left >= 0 && right < str.length() && str.charAt(left) == str.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }

    public int getLongestPalindrome_0(String A) {
        int maxLen = 1;
        for (int i = 0; i < A.length(); i++) {
            maxLen = Math.max(maxLen, Math.max(getLen(A, i, i), getLen(A, i, i + 1)));
        }
        return maxLen;
    }


    public int getLongestPalindrome(String A) {
        // write code here
        int len = A.length();
        if (len < 2) return len;

        int maxLen = 1;
        boolean[][] dp = new boolean[len][len];

        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }

        for (int L = 2; L <= len; L++) {
            for (int i = 0; i < len; i++) {
                int j = i + L - 1;
                if (j >= len) break;
                if (A.charAt(i) == A.charAt(j)) {
                    dp[i][j] = (L <= 3) || dp[i + 1][j - 1];
                    if (dp[i][j]) maxLen = Math.max(maxLen, L);
                }
            }
        }
        return maxLen;
    }
}
