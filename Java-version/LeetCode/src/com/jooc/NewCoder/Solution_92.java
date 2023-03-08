package com.jooc.NewCoder;

import com.jooc.Solution;

import java.util.ArrayList;
import java.util.HashMap;

public class Solution_92 implements Solution {
    @Override
    public void main() {
        System.out.println(maxLength(new int[]{2, 3, 4, 5}));
        System.out.println(maxLength(new int[]{9, 9}));
    }

    private boolean check(HashMap<Integer, Integer> counter) {
        for (int val : counter.values()) {
            if (val > 1) return false;
        }
        return true;
    }

    /**
     * @param arr int整型一维数组 the array
     * @return int整型
     */
    public int maxLength_0(int[] arr) {
        // write code here
        HashMap<Integer, Integer> counter = new HashMap<>();
        int n = arr.length;
        int left = 0, right = 0;
        int maxLen = Integer.MIN_VALUE;
//        int resBegin = -1;

        while (right < n) {
            while (right < n && check(counter)) {
                if (!counter.containsKey(arr[right])) {
                    counter.put(arr[right], 1);
                } else {
                    counter.put(arr[right], counter.get(arr[right]) + 1);
                }
                right++;
            }


            while (left <= right && !check(counter)) {
                if (counter.get(arr[left]) == 1)
                    counter.remove(arr[left]);
                else
                    counter.put(arr[left], counter.get(arr[left]) - 1);
                left++;
            }
        }

//        int[] res = new int[maxLen];
//        for (int i = 0; i < maxLen; i++) {
//            res[i] = arr[resBegin + i];
//
//        }
        return maxLen;
    }

    /**
     * @param arr int整型一维数组 the array
     * @return int整型
     */
    public int maxLength(int[] arr) {
        // write code here
        HashMap<Integer, Integer> counter = new HashMap<>();
        int maxLen = 0;

        for (int left = 0, right = 0; right < arr.length; right++) {
            if (!counter.containsKey(arr[right])) counter.put(arr[right], 1);
            else counter.put(arr[right], counter.get(arr[right]) + 1);

            while (counter.get(arr[right]) > 1) {
                counter.put(arr[left], counter.get(arr[left]) - 1);
                left++;
            }
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }

}
