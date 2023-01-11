package com.jooc.NewCoder;

import com.jooc.Solution;

public class Solution_21 implements Solution {
    @Override
    public void main() {
        System.out.println(minNumberInRotateArray(new int[]{1,0,1,1,1}));
    }

    public int minNumberInRotateArray(int[] array) {
        int left = 0, right = array.length - 1;

        while (left < right) {
            int mid = (left + right) / 2;
            if (array[mid] == array[right])
                right--;
            else if (array[mid] > array[right])
                left = mid + 1;
            else
                right = mid;
        }

        return array[left];
    }
}
