package com.jooc.NewCoder;

import com.jooc.Solution;

import java.util.Arrays;

public class Solution_78 implements Solution {
    @Override
    public void main() {
        System.out.println(rob(new int[]{1, 2, 3, 4}));
    }

    //    Terrible Mistake: we may give up two consecutive num
    public int rob_error(int[] nums) {
        // write code here
        int n = nums.length;
        if (n < 1) return 0;

        int sum1 = 0, sum2 = 0;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) sum1 += nums[i];
            else sum2 += nums[i];
        }
        return Math.max(sum1, sum2);
    }

    public int rob_0(int[] nums) {
        // write code here
        int n = nums.length;
        if (n <= 1) return nums[0];
        if (n == 2) return Math.max(nums[0], nums[1]);

        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = nums[0];
        dp[1][0] = dp[0][1];
        dp[1][1] = nums[1];


        for (int i = 2; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            dp[i][1] = Math.max(dp[i - 1][0] + nums[i], dp[i - 2][1] + nums[i]);
        }

        System.out.println(Arrays.deepToString(dp));

        return Math.max(dp[n - 1][0], dp[n - 1][1]);
    }

    public int rob(int[] nums) {
        // write code here
        int n = nums.length;
        int[] dp = new int[n + 1];
        dp[1] = nums[0];

        for (int i = 2; i <= n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
        }

        System.out.println(Arrays.toString(dp));

        return dp[n];
    }
}
