package com.jooc.NewCoder;

import com.jooc.Solution;

import java.util.Arrays;

public class Solution_97 implements Solution {
    @Override
    public void main() {
        System.out.println(Arrays.toString(solve(6, 2, new int[]{1, 2, 3, 4, 5, 6})));
    }

    /**
     * 旋转数组
     *
     * @param n int整型 数组长度
     * @param m int整型 右移距离
     * @param a int整型一维数组 给定数组
     * @return int整型一维数组
     */
    public int[] solve(int n, int m, int[] a) {
        if (m == 0) return a;
        if (m >= n) return solve(n, m % n, a);
        // write code here
        reverse(a, 0, n - 1);
//        System.out.println(Arrays.toString(a));
        reverse(a, 0, m - 1);
//        System.out.println(Arrays.toString(a));
        reverse(a, m, n - 1);

        return a;
    }

    private void reverse(int[] a, int startIndex, int endIndex) {
        for (int i = 0; i <= (endIndex - startIndex) / 2; i++) {
            swap(a, startIndex + i, endIndex - i);
        }
    }

    private void swap(int[] a, int x, int y) {
        int temp = a[x];
        a[x] = a[y];
        a[y] = temp;
    }
}
