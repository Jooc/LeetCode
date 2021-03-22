package com.jooc.GazeOffer;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Solution_41 {

    public void main() {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(3);
        System.out.println(medianFinder.findMedian());
    }


    class MedianFinder_0 {

        ArrayList<Integer> sortedList;

        /**
         * initialize your data structure here.
         */
        public MedianFinder_0() {
            sortedList = new ArrayList<>();
        }

        public void addNum(int num) {
            if (sortedList.size() == 0) {
                sortedList.add(num);
                return;
            }

            int left = 0, right = sortedList.size() - 1;

            while (right - left > 1) {
                int mid = (left + right) / 2;
                if (num > sortedList.get(mid)) {
                    left = mid;
                } else {
                    right = mid;
                }
            }
            if (num >= sortedList.get(right))
                sortedList.add(right + 1, num);
            else if (num >= sortedList.get(left))
                sortedList.add(left + 1, num);
            else
                sortedList.add(left, num);
        }

        public double findMedian() {
            return sortedList.size() % 2 == 0 ?
                    ((double) sortedList.get(sortedList.size() / 2 - 1) + (double) sortedList.get(sortedList.size() / 2)) / 2 :
                    sortedList.get(sortedList.size() / 2);
        }
    }

    class MedianFinder {

        PriorityQueue<Integer> minStack;
        PriorityQueue<Integer> maxStack;

        public MedianFinder() {
            minStack = new PriorityQueue<>();
            maxStack = new PriorityQueue<>((o1, o2) -> (o2-o1));
        }

        public void addNum(int num) {
            if(size() % 2 == 0){
                maxStack.offer(num);
                minStack.offer(maxStack.poll());
            }else{
                minStack.offer(num);
                maxStack.offer(minStack.poll());
            }
        }

        public double findMedian() {
            return size() % 2 == 0 ? ((double)minStack.peek() + (double)maxStack.peek()) / 2 : minStack.peek();
        }

        public int size(){
            return minStack.size() + maxStack.size();
        }
    }
}
