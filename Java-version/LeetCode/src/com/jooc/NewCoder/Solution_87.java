package com.jooc.NewCoder;

import com.jooc.Solution;

import java.util.Arrays;

public class Solution_87 implements Solution {
    @Override
    public void main() {
//        merge(new int[]{4, 5, 6, 0, 0, 0}, 3, new int[]{1, 2, 3}, 3);
        merge(new int[]{1,0}, 1, new int[]{2}, 1);
    }

    public void merge(int A[], int m, int B[], int n) {
        int left = m - 1, right = n - 1, tail = m + n - 1;
        while (left >= 0 && right >= 0) {
            A[tail--] = A[left] > B[right] ? A[left--] : B[right--];
        }
        while (right >= 0) {
            A[tail--] = B[right--];
        }

        System.out.println(Arrays.toString(A));
    }

}
