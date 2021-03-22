package com.jooc.GazeOffer;

import java.util.HashSet;
import java.util.Set;

public class Solution_3 {
    /**
     * Time = O(N)
     * Space = O(N)
     */
    public int findRepeatNumber_0(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (Integer i : nums) {
            if (set.contains(i)) {
                return i;
            }
            set.add(i);
        }
        return -1;
    }

    /**
     * Time = O(N)
     * Space = O(1)
     */
    public int findRepeatNumber(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            if (nums[i] == i) {
                i++;
                continue;
            }

            if (nums[nums[i]] == nums[i])
                return nums[i];

            int temp = nums[i];
            nums[i] = nums[temp];
            nums[temp] = temp;
        }

        return -1;
    }
}
