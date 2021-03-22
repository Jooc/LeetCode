package com.jooc.Solutions;

import java.util.*;

public class Solution_40 {

    public void main() {
        System.out.println(Arrays.toString(getLeastNumbers(new int[]{0,0,0,2,0,5}, 3)));
//        System.out.println(Arrays.toString(getLeastNumbers(new int[]{3,2,1}, 2)));
    }

    public int[] getLeastNumbers_0(int[] arr, int k) {
        Arrays.sort(arr);

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = arr[i];
        }

        return res;
    }

    public int[] getLeastNumbers(int[] arr, int k) {
        if(k == 0) return new int[]{};
        return QuickSort(arr, 0, arr.length - 1, k - 1);
    }

    private int[] QuickSort(int[] arr, int low, int high, int k) {
        if (low <= high) {
            int index = randomizedPartition(arr, low, high);
            if (index == k) {
                return Arrays.copyOf(arr, k + 1);
            }else{
                return index < k ?
                        QuickSort(arr, index + 1, high, k):
                        QuickSort(arr, low, index - 1, k);
            }

        }
        return null;
    }

    private int randomizedPartition(int[] arr, int low, int high){
        int randomIndex = new Random().nextInt(high - low + 1) + low;
        int tmp = arr[low];
        arr[low] = arr[randomIndex];
        arr[randomIndex] = tmp;
        return partition(arr, low, high);
    }

    private int partition(int[] arr, int low, int high) {
        int pivot = arr[low];

        while (low < high) {
            while (low < high && arr[high] >= pivot) high--;
            arr[low] = arr[high];
            while (low < high && arr[low] <= pivot) low++;
            arr[high] = arr[low];
        }
        arr[low] = pivot;
        return low;
    }
}
