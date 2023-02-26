package com.jooc.NewCoder;

import com.jooc.Solution;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_45 implements Solution {
    @Override
    public void main() {
        System.out.println(maxInWindows(new int[]{2, 3, 4, 2, 6, 2, 5, 1}, 3));
    }

    public ArrayList<Integer> maxInWindows(int[] num, int size) {
        ArrayList<Integer> res = new ArrayList<>();
        if (num.length < size || size == 0) return res;

        Deque<Integer> queue = new LinkedList<>();
        for (int i = 0; i < num.length; i++) {
            while (!queue.isEmpty() && num[i] > num[queue.getLast()]) {
                queue.removeLast();
            }
            queue.offer(i);
            if (i - queue.getFirst() >= size) {
                queue.removeFirst();
            }
            if (i >= size - 1) {
                res.add(num[queue.getFirst()]);
            }
        }
        return res;
    }
}
