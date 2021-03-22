package com.jooc.Solutions;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;

class Solution_45_0 implements Solution {

    @Override
    public void main() {
//        System.out.println(minNumber(new int[]{3,30,34,5,9}));
        System.out.println(minNumber(new int[]{1,1,1}));
    }

    public String minNumber_0(int[] nums) {
        PriorityQueue<Long> queue = new PriorityQueue<>(new Comparator<Long>() {
            @Override
            public int compare(Long o1, Long o2) {
                long num1 = Long.valueOf(o1.toString() + o2.toString());
                long num2 = Long.valueOf(o2.toString() + o1.toString());
                return (int)(num1 - num2);
            }
        });

        for(long num: nums){
            queue.offer(num);
        }

        StringBuilder res = new StringBuilder();
        while(!queue.isEmpty()){
            res.append(queue.poll());
        }

        return res.toString();
    }

    public String minNumber(int[] nums){
        QuickSort(nums, 0, nums.length - 1);
        StringBuilder stringBuilder = new StringBuilder();
        for(int num : nums){
            stringBuilder.append(num);
        }
        return stringBuilder.toString();
    }

    private void QuickSort(int[] nums, int low, int high){
        if(low < high) {
            int pivotIndex = partition(nums, low, high);

            QuickSort(nums, low, pivotIndex - 1);
            QuickSort(nums, pivotIndex + 1, high);
        }
    }

    private int randomizedPatition(int[] nums, int low, int high){
        int randomIndex = new Random().nextInt(high - low + 1) + low;
        swap(nums, low, randomIndex);
        return partition(nums, low, high);
    }

    private int partition(int[] nums, int low, int high){
        int pivot = nums[low];
        while(low < high){
            while(low < high && compare(nums[high], pivot) >= 0) high--;
            nums[low] = nums[high];
            while(low < high && compare(nums[low], pivot) <= 0) low++;
            nums[high] = nums[low];
        }
        nums[low] = pivot;
        return low;
    }

    private void swap(int[] nums, int x, int y){
        int tmp = nums[x];
        nums[x] = nums[y];
        nums[y] = tmp;
    }

    /**
     * Return 1 if <code>x</code> is larger than <code>y</code> in this comparing rule:
     * If <String>xy</String> is larger than <String>yx</String>, we will see <code>x</code>
     * as the larger one, and put it behind y in the final num sequence.
     *
     * In a short word, x > y if return value is positive.
     */
    private int compare(long x, long y){
        long num1 = Long.valueOf(Long.toString(x) + Long.toString(y));
        long num2 = Long.valueOf(Long.toString(y) + Long.toString(x));

        if(num1 > num2) return 1;
        else if(num1 < num2) return -1;
        else return 0;
    }

}

public class Solution_45 implements Solution {
    @Override
    public void main() {
        System.out.println(minNumber(new int[]{3,30,34,5,9}));
        System.out.println(minNumber(new int[]{1,1,1}));
    }

    public String minNumber(int[] nums){
        int len = nums.length;
        String[] strs = new String[len];
        for(int i = 0; i < len; i++){
            strs[i] = String.valueOf(nums[i]);
        }
        QuickSort(strs, 0, nums.length - 1);
        StringBuilder stringBuilder = new StringBuilder();
        for(String str : strs){
            stringBuilder.append(str);
        }
        return stringBuilder.toString();
    }

    public void QuickSort(String[] strs, int left, int right){
        if(left >= right) return;

        int i = left, j = right;
        String tmp = strs[i];
        while(i < j){
            while(i < j && (strs[j] + strs[left]).compareTo(strs[left] + strs[j]) >= 0) j--;
            while(i < j && (strs[i] + strs[left]).compareTo(strs[left] + strs[i]) <= 0) i++;
            tmp = strs[i];
            strs[i] = strs[j];
            strs[j] = tmp;
        }
        strs[i] = strs[left];
        strs[left] = tmp;
        QuickSort(strs, left, i - 1);
        QuickSort(strs, i + 1, right);
    }
}