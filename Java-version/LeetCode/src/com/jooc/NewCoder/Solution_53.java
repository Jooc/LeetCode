package com.jooc.NewCoder;

import com.jooc.Solution;

import java.util.*;

public class Solution_53 implements Solution {
    @Override
    public void main() {
        System.out.println(minNumberDisappeared(new int[]{1, 0, 2}));
        System.out.println(minNumberDisappeared(new int[]{-2, 3, 4, 1, 5}));
        System.out.println(minNumberDisappeared(new int[]{4, 5, 6, 8, 9}));
        System.out.println(minNumberDisappeared(new int[]{3,2,1}));
    }

    public int minNumberDisappeared_0(int[] nums) {
        // write code here
        Set<Integer> set = new HashSet<>();
        int minusCount = 0;
        for (int num : nums) {
            if (num > 0) {
                set.add(num);
            } else {
                minusCount++;
            }
        }
        System.out.println(set.toString());
        for (int i = 1; i < nums.length; i++) {
            if (!set.contains(i))
                return i;
        }
        return nums.length + 1 - minusCount;
    }

    public int minNumberDisappeared(int[] nums) {
        // write code here
        int n = nums.length;
        int[] mark = new int[n];

        for (int num : nums) {
            if (num > 0 && num <= n) {
                mark[num - 1] = 1;
            }
        }

        for (int i = 0; i < n; i++) {
            if (mark[i] != 1)
                return i + 1;
        }
        return n + 1;
    }
}
