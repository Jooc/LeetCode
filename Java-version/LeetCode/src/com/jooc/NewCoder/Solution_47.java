package com.jooc.NewCoder;

import com.jooc.Solution;

import java.nio.channels.Pipe;

public class Solution_47 implements Solution {
    @Override
    public void main() {
        System.out.println(findKth(new int[]{10,10,9,9,8,7,5,6,4,3,4,2}, 12, 3));
    }

    private void swap(int[] a, int x1, int x2) {
        int temp = a[x1];
        a[x1] = a[x2];
        a[x2] = temp;
    }

    private int partition(int[] a, int low, int high) {
        int pivot = a[low];
        while (low < high) {
            while (low < high && a[high] <= pivot) high--;
            swap(a, low, high);
            while (low < high && a[low] >= pivot) low++;
            swap(a, low, high);
        }
        a[low] = pivot;
        return low;
    }

    private int QuickSort(int[] a, int low, int high, int k) {
        int pivot_idx = partition(a, low, high);
        if (k == pivot_idx) return a[pivot_idx];
        else if (k < pivot_idx) return QuickSort(a, low, pivot_idx - 1, k);
        else return QuickSort(a, pivot_idx + 1, high, k);
    }

    public int findKth(int[] a, int n, int K) {
        // write code here
        return QuickSort(a, 0, n - 1, K-1);
    }
}
