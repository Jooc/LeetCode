package com.jooc.GazeOffer;

import java.util.HashMap;

public class Solution_39 {
    public void main(){
        System.out.println(majorityElement(new int[]{1, 2, 3, 2, 2, 2, 5, 4, 2}));
    }

    // 统计
    public int majorityElement_0(int[] nums) {
        HashMap<Integer, Integer> count = new HashMap<>();
        for(int num : nums){
            if(!count.containsKey(num)){
                count.put(num, 1);
            }else{
                count.put(num, count.get(num) + 1);
            }
            if(count.get(num) > nums.length/2)
                return num;
        }

        return -1;
    }

    // 排序
    public int majorityElement_1(int[] nums){
        QuickSort(nums, 0, nums.length - 1);

        return nums[nums.length/2];
    }

    private void QuickSort(int[] nums, int left, int right){
        if(left < right) {
            int index = partition(nums, left, right);
            QuickSort(nums, left, index - 1);
            QuickSort(nums, index + 1, right);
        }
    }

    private int partition(int[] nums, int left, int right){
        int pivot = nums[left];

        while(left < right){
            while(left < right && nums[right] >= pivot) right--;
            nums[left] = nums[right];
            while(left < right && nums[left] <= pivot) left++;
            nums[right] = nums[left];
        }
        nums[left] = pivot;
        return left;
    }

    // 摩尔排序
    public int majorityElement(int[] nums){
        int votes = 0, x = 0;

        for(int num : nums){
            if(votes == 0){
                x = num;
            }
            votes += x == num ? 1 : -1;
        }

        return x;
    }
}
