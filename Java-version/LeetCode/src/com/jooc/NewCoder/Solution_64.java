package com.jooc.NewCoder;

import com.jooc.Main;
import com.jooc.Solution;

import java.util.Arrays;
import java.util.Stack;

class Solution_64_0 implements Solution {
    @Override
    public void main() {
        System.out.println(LCS("1a1a31", "1a231"));
    }

    private final int[][] directions = new int[][]{{-1, -1}, {-1, 0}, {0, -1}};

    private String toString(String s1, String s2, int[][] ds) {
        StringBuilder builder = new StringBuilder();
        int x = s1.length(), y = s2.length();
        while (x > 0 && y > 0) {
            if (ds[x][y] == 0) {
                builder.insert(0, s1.charAt(x - 1));
            }
            int nx = x + directions[ds[x][y]][0];
            int ny = y + directions[ds[x][y]][1];

            x = nx;
            y = ny;
        }
        return builder.toString();
    }

    public String LCS(String s1, String s2) {
        // write code here

        int n1 = s1.length(), n2 = s2.length();
        int[][] dp = new int[n1 + 1][n2 + 1];
        int[][] ds = new int[n1 + 1][n2 + 1];

        for (int i = 0; i < n1; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i < n2; i++) {
            dp[0][i] = 0;
        }

        boolean hasSubString = false;
        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    hasSubString = true;
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    ds[i][j] = 0;
                } else {
                    if (dp[i - 1][j] >= dp[i][j - 1]) {
                        dp[i][j] = dp[i - 1][j];
                        ds[i][j] = 1;
                    } else {
                        dp[i][j] = dp[i][j - 1];
                        ds[i][j] = 2;
                    }
                }
            }
        }

        System.out.println(dp[n1][n2]);

        return hasSubString ? toString(s1, s2, ds) : "-1";
    }
}

public class Solution_64 implements Solution {
    @Override
    public void main() {
        System.out.println(LCS("1a1a31", "1a231"));
    }

    public String LCS(String s1, String s2) {
        // write code here

        int n1 = s1.length(), n2 = s2.length();
        int[][] dp = new int[n1 + 1][n2 + 1];
        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        int x = n1, y = n2;
        Stack<Character> stack = new Stack<>();
        while (dp[x][y] != 0) {
//            if (dp[x][y] > dp[x - 1][y - 1]) {
//                x--;
//                y--;
//                stack.push(s1.charAt(x));
//            } else if (dp[x][y] == dp[x - 1][y]) {
//                x--;
//            } else if (dp[x][y] == dp[x][y - 1]) {
//                y--;
//            }
            if(dp[x][y] == dp[x - 1][y])
                x--;
            else if(dp[x][y] == dp[x][y - 1])
                y--;
            else if(dp[x][y] > dp[x - 1][y - 1]){
                x--;
                y--;
                stack.push(s1.charAt(x));
            }
        }

        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty())
            res.append(stack.pop());

        return res.length() == 0 ? "-1" : res.toString();
    }
}
