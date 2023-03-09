package com.jooc.NewCoder;

import com.jooc.Solution;

public class Solution_94 implements Solution {
    @Override
    public void main() {
//        System.out.println(maxWater(new int[]{3, 1, 2, 5, 2, 4}));
        System.out.println(maxWater(new int[]{4, 5, 1, 3, 2}));
    }

    public long maxWater(int[] arr) {
        // write code here
        int n = arr.length;
        if (n < 2) return 0;

        int maxL = 0, maxR = 0;
        int left = 0, right = n - 1;
        int res = 0;
        while (left < right) {
            maxL = Math.max(maxL, arr[left]);
            maxR = Math.max(maxR, arr[right]);

            if (maxL <= maxR) res += maxL - arr[left++];
            else res += maxR - arr[right--];
        }
        return res;
    }
}
