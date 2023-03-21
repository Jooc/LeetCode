package com.jooc.GazeOffer;

public class Solution_42 {

    public void main() {
        System.out.println(maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }

    public int maxSubArray_0(int[] nums) {
        int len = nums.length;
        if (len == 0) return 0;

        int[] dp = new int[len];
        dp[0] = nums[0];

        int max = dp[0];
        for (int i = 1; i < len; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            max = Math.max(max, dp[i]);
        }

        return max;
    }

    public int maxSubArray(int[] nums) {
        int ans = nums[0];

        for (int i = 1; i < nums.length; i++) {
            nums[i] = nums[i] + Math.max(nums[i - 1], 0);
            ans = Math.max(ans, nums[i]);
        }
        return ans;
    }

}
