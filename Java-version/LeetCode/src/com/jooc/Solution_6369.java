package com.jooc;

import java.util.Arrays;

public class Solution_6369 implements Solution {
    @Override
    public void main() {

    }

    public int[] leftRigthDifference(int[] nums) {
        int leftSum = 0, rightSum = Arrays.stream(nums).sum() - nums[0];

        int n = nums.length;
        int[] ans = new int[n];

        for (int i = 0; i < n - 1; i++) {
            ans[i] = Math.abs(leftSum - rightSum);
            leftSum += nums[i];
            rightSum -= nums[i + 1];
        }
        ans[n-1] = leftSum;
        return ans;
    }
}
