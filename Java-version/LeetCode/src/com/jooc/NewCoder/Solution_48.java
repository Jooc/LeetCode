package com.jooc.NewCoder;

import com.jooc.Solution;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Solution_48 implements Solution {
    @Override
    public void main() {
        int[] arr = new int[]{5, 2, 3, 4, 1, 6, 7, 0, 8};
        for (int num : arr) {
            Insert(num);
            System.out.println(GetMedian());
        }
    }


    List<Integer> arr = new ArrayList<>();

    public void Insert_0(Integer num) {
        if (arr.isEmpty()) arr.add(num);
        else {
            int i = 0;
            while (i < arr.size() && arr.get(i) < num)
                i++;
            arr.add(i, num);
        }
    }

    public Double GetMedian_0() {
        int n = arr.size();
        if (n % 2 == 0) {
            return ((double) arr.get(n / 2 - 1) + (double) arr.get(n / 2)) / 2;
        } else {
            return (double) arr.get(n / 2);
        }
    }

    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
    PriorityQueue<Integer> minHeap = new PriorityQueue<>(Comparator.naturalOrder());

    public void Insert(Integer num) {
        minHeap.offer(num);
        maxHeap.offer(minHeap.poll());

        if (minHeap.size() < maxHeap.size())
            minHeap.offer(maxHeap.poll());
    }

    public Double GetMedian() {
        if (minHeap.size() > maxHeap.size()) return (double) minHeap.peek();

        assert !minHeap.isEmpty();
        return (double) (minHeap.peek() + maxHeap.peek()) / 2;
    }


}
