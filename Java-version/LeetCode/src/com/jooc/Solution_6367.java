package com.jooc;

import java.util.Arrays;

public class Solution_6367 implements Solution {
    @Override
    public void main() {
//        System.out.println(maxNumOfMarkedIndices(new int[]{42, 83, 48, 10, 24, 55, 9, 100, 10, 17, 17, 99, 51, 32, 16, 98, 99, 31, 28, 68, 71, 14, 64, 29, 15, 40}));
//        System.out.println(maxNumOfMarkedIndices(new int[]{3,5,2,4}));
        System.out.println(maxNumOfMarkedIndices(new int[]{57, 40, 57, 51, 90, 51, 68, 100, 24, 39, 11, 85, 2, 22, 67, 29, 74, 82, 10, 96, 14, 35, 25, 76, 26, 54, 29, 44, 63, 49, 73, 50, 95, 89, 43, 62, 24, 88, 88, 36, 6, 16, 14, 2, 42, 42, 60, 25, 4, 58, 23, 22, 27, 26, 3, 79, 64, 20, 92}));

    }

    public int maxNumOfMarkedIndices(int[] nums) {
        if (nums.length <= 1) return 0;
        int ans = 0;

        Arrays.sort(nums);
        int left = 0, right = 1;
//        while (right <= nums.length && nums[right] < 2 * nums[left]) {
//            if (right == nums.length - 1) break;
//            right++;
//        }
        right = nums.length / 2;

        while (left < nums.length / 2 && right < nums.length) {
            if (2 * nums[left] <= nums[right]) {
                ans += 2;
                left++;
            }
            right++;
        }
        return ans;
    }
}
