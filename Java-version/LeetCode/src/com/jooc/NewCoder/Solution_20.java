package com.jooc.NewCoder;

import com.jooc.Solution;

import java.util.Arrays;

public class Solution_20 implements Solution {
    @Override
    public void main() {
        System.out.println(InversePairs(new int[]{1,2,3,4,5,6,7,0}));
//        System.out.println(InversePairs(new int[]{}));

//        int a = 1;
//        for (int i = 0; i < 10; i++) {
//            System.out.printf("%d, %d", a++, a);
//            System.out.println();
//        }
    }

    private int res = 0;

    public int InversePairs(int[] array) {
        int left = 0, right = array.length - 1;
        merge_sort(array, left, right);
        return res;
    }

    private void merge_sort(int[] array, int left, int right) {
        if (left >= right)
            return;

        int mid = (left + right) / 2;
        merge_sort(array, left, mid);
        merge_sort(array, mid + 1, right);
        merge(array, left, mid, right);
    }

    private void merge(int[] array, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int idx = 0;
        int l = left, r = mid + 1;
        while (l <= mid && r <= right) {
            if (array[l] > array[r]) {
                res += (mid - l + 1);
                res %= 1000000007;
                temp[idx++] = array[r++];
            } else {
                temp[idx++] = array[l++];
            }
        }
        while (l <= mid)
            temp[idx++] = array[l++];
        while (r <= right)
            temp[idx++] = array[r++];

//        idx = left-1;
//        while (idx < right) {
//            array[++idx] = temp[idx - left];
//        }
        for(int num: temp)
            array[left++] = num;
    }

}
