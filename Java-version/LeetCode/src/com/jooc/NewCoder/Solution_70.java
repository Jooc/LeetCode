package com.jooc.NewCoder;

import com.jooc.Main;
import com.jooc.Solution;

import java.util.Arrays;
import java.util.Comparator;

public class Solution_70 implements Solution {
    @Override
    public void main() {
        System.out.println(minMoney(new int[]{5, 3}, 2));
    }

    private int recur(int[] arr, int aim, int[] dp) {
        if (aim < 0) return -1;
        if (aim == 0) return 0;
        if (dp[aim - 1] != 0)
            return dp[aim - 1];

        int min = Integer.MAX_VALUE;
        for (int j : arr) {
            int res = recur(arr, aim - j, dp);
            if (res >= 0 && res < min)
                min = res + 1;
        }
        dp[aim - 1] = min == Integer.MAX_VALUE ? -1 : min;
        return dp[aim - 1];
    }

    public int minMoney_0(int[] arr, int aim) {
        // write code here
        if (aim < 1) return 0;
        int[] dp = new int[aim + 1];
        return recur(arr, aim, dp);
    }

    public int minMoney(int[] arr, int aim) {
        // write code here
        if (aim < 1) return 0;
        int[] dp = new int[aim + 1];
        Arrays.fill(dp, aim + 1);
        dp[0] = 0;

        for (int target = 1; target <= aim; target++) {
            for (int money : arr) {
                if (target - money >= 0) {
                    dp[target] = Math.min(dp[target - money] + 1, dp[target]);
                }
            }
        }

        return dp[aim] > aim ? -1 : dp[aim];
    }
}
