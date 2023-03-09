package com.jooc.NewCoder;

import com.jooc.Solution;

import java.util.Arrays;

public class Solution_95 implements Solution {
    @Override
    public void main() {
//        System.out.println(candy(new int[]{1, 1, 2}));
        System.out.println(candy(new int[]{4,4,4}));
    }

    public int candy(int[] arr) {
        // write code here

        int n = arr.length;
        int[] count = new int[n];
        Arrays.fill(count, 1);
        for (int i = 1; i < n; i++) {
            if (arr[i] > arr[i - 1])
                count[i] = count[i - 1] + 1;
        }
        int res = count[n - 1];
        for (int j = n - 2; j >= 0; j--) {
            if (arr[j] > arr[j + 1] && count[j] <= count[j + 1])
                count[j] = count[j + 1] + 1;
            res += count[j];
        }
        return res;
    }
}
