package com.jooc.NewCoder;

import com.jooc.Solution;

import java.util.Arrays;

public class Solution_69 implements Solution {
    @Override
    public void main() {
        System.out.println(solve("72910721221427251718216239162221131917242"));
    }

    public int solve(String nums) {
        // write code here
        int n = nums.length();

        if (n == 0 || nums.equals("0")) return 0;
        if (nums.equals("10") || nums.equals("20")) return 1;
        for(int i = 1; i < n; i++)
            if(nums.charAt(i) == '0' && nums.charAt(i - 1) != '1' && nums.charAt(i-1) != '2')
                return 0;

        int[] dp = new int[n+1];
        Arrays.fill(dp, 1);
        for (int i = 2; i <= nums.length(); i++) {
//            if (nums.charAt(i-1) != '0' && (nums.charAt(i - 2) - '0') * 10 + (nums.charAt(i-1) - '0') <= 26) {
            if ((nums.charAt(i - 2) == '1' && nums.charAt(i - 1) != '0') || (nums.charAt(i - 2) == '2' && nums.charAt(i - 1) > '0' && nums.charAt(i - 1) < '7')) {
                dp[i] = dp[i - 1] + dp[i - 2];
            } else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[n];
    }
}
