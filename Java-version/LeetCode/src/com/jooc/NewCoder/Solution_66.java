package com.jooc.NewCoder;

import com.jooc.Solution;

import java.util.Arrays;
import java.util.Stack;

public class Solution_66 implements Solution {
    @Override
    public void main() {
        System.out.println(LCS("1AB2345CD", "12345EF"));
    }

    public String LCS_0(String str1, String str2) {
        // write code here
        int n1 = str1.length(), n2 = str2.length();
        int[][] dp = new int[n1 + 1][n2 + 1];
        int maxCount = 0;
        int[] maxPos = new int[2];

        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                dp[i][j] = str1.charAt(i - 1) == str2.charAt(j - 1) ? dp[i - 1][j - 1] + 1 : 0;
                if (dp[i][j] > maxCount) {
                    maxCount = Math.max(maxCount, dp[i][j]);
                    maxPos[0] = i;
                    maxPos[1] = j;
                }
            }
        }

        System.out.println(maxCount);
        System.out.println(Arrays.deepToString(dp));

        Stack<Character> stack = new Stack<>();
        int x = maxPos[0], y = maxPos[1];
        while (dp[x][y] != 0) {
            stack.push(str1.charAt(x - 1));
            x--;
            y--;
        }

        StringBuilder resBuilder = new StringBuilder();
        while (!stack.isEmpty()) {
            resBuilder.append(stack.pop());
        }
        return resBuilder.toString();
    }

    public String LCS(String str1, String str2) {
        // write code here
        int n1 = str1.length(), n2 = str2.length();
        int[] dp = new int[n2 + 1];
        int maxCount = 0;
        int maxLastIndex = -1;

        for (int i = 0; i < n1; i++) {
            for (int j = n2 - 1; j >= 0; j--) {
                dp[j + 1] = str1.charAt(i) == str2.charAt(j) ? dp[j] + 1 : 0;
                if (dp[j+1] > maxCount) {
                    maxCount = dp[j+1];
                    maxLastIndex = i+1;
                }
            }
        }

        return str1.substring(maxLastIndex - maxCount, maxLastIndex);
    }
}
