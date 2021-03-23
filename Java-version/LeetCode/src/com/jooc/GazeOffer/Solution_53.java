package com.jooc.GazeOffer;

import com.jooc.Solution;

public class Solution_53 implements Solution {
    @Override
    public void main() {
        System.out.println(search(new int[]{1,1}, 1));
    }

    public int search_0(int[] nums, int target) {
        if(nums.length == 0) return 0;

        int left = 0, right = nums.length;
        int mid = 0;
        while(left < right){
            mid = (left + right) / 2;

            if(target == nums[mid]) break;
            else if(target < nums[mid]){
                right = mid - 1;
            }
            else{
                left = mid + 1;
            }
        }

        int res = 0;
        boolean haveMeet = false;
        for(int i = mid; i >= 0; i--){
            if(nums[i] == target) {
                res++;
                haveMeet = true;
            } else{
                if(haveMeet) break;
            }
        }
        haveMeet = false;
        for(int i = mid + 1; i < nums.length; i++){
            if(nums[i] == target) {
                res++;
                haveMeet = true;
            } else{
                if(haveMeet) break;
            }
        }

        return res;
    }

    public int search(int[] nums, int target){
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0] == target ? 1 : 0;
        return findRightBorder(nums, target) - findRightBorder(nums, target - 1);
    }

    private int findRightBorder(int[] nums, int target){
        int i = 0, j = nums.length - 1;
        while(i <= j){
            int mid = (i + j) / 2;
            if(target >= nums[mid]) i = mid + 1;
            else j = mid - 1;
        }
        return i;
    }

    public int missingNumber(int[] nums) {
        int left = 0, right = nums.length - 1;
        while(left <= right){
            int mid = (left + right) / 2;
            if(nums[mid] <= mid) left = mid + 1;
            else right = mid - 1;
        }
        return left;
    }
}
