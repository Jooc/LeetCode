package com.jooc.NewCoder;

import com.jooc.Solution;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution_46 implements Solution {
    @Override
    public void main() {
        System.out.println(GetLeastNumbers_Solution(new int[]{234,233,233,233,233,233,233,233,233,233,233,233,233,233,233,233,233,233,233,233}, 10));
    }


    //    普通快排超时
//    T=O(nlogn) > O(nlogk)
    private int Partition(int[] nums, int left, int right) {
        int pivot = nums[left];
        while (left < right) {
            while (left < right && nums[right] >= pivot) right--;
            nums[left] = nums[right];
            while (left < right && nums[left] <= pivot) left++;
            nums[right] = nums[left];
        }
        nums[left] = pivot;
        return left;
    }

    private void QuickSort(int[] nums, int left, int right, int k) {
        if (left < right) {
            int pivotIdx = Partition(nums, left, right);
            if (pivotIdx + 1 == k) {
                return;
            } else if (pivotIdx + 1 < k) {
                QuickSort(nums, pivotIdx + 1, right, k);
            } else {
                QuickSort(nums, left, pivotIdx, k);
            }
        }
    }

    //    优化快排 T = O(nlogk)
    public ArrayList<Integer> GetLeastNumbers_Solution_optimizedQuick(int[] input, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        // if(k==0 || k > input.length) return res;

        QuickSort(input, 0, input.length - 1, k);

        for (int i = 0; i < k; i++) {
            res.add(input[i]);
        }

        return res;
    }

    public ArrayList<Integer> GetLeastNumbers_Solution_PriorityQueue(int[] input, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        if (k == 0) return res;

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        for (int i = 0; i < k; i++) {
            priorityQueue.offer(input[i]);
        }
        for (int i = k; i < input.length; i++) {
            if (priorityQueue.peek() > input[i]) {
                priorityQueue.poll();
                priorityQueue.offer(input[i]);
            }
        }
        for (int i = 0; i < k; i++) {
            res.add(priorityQueue.poll());
        }
        return res;
    }

    private void adjustDown(int[] A, int k, int len) {
        A[0] = A[k];
        for (int i = 2 * k; i <= len; i *= 2) {
            if (i < len && A[i] < A[i + 1])
                i++;
            if (A[0] > A[i])
                break;
            else {
                A[k] = A[i];
                k = i;
            }
        }//for
        A[k] = A[0];
    }

    private void buildMaxHeap(int[] arr, int len) {
        if (arr == null || arr.length <= 1)
            return;
        for (int i = len / 2; i > 0; i--) {
            adjustDown(arr, i, len);
        }
    }

    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        if (input.length == 0 || k == 0 || k > input.length)
            return res;

        int[] arr = new int[k + 1];

        for (int i = 1; i <= k; i++) {
            arr[i] = input[i - 1];
        }

        buildMaxHeap(arr, k);

        for (int i = k; i < input.length; i++) {
            if (input[i] < arr[1]) {
                arr[1] = input[i];
                adjustDown(arr, 1, k);
            }
        }

        for (int i = 1; i <= k; i++) {
            res.add(arr[i]);
        }
        return res;
    }

}
