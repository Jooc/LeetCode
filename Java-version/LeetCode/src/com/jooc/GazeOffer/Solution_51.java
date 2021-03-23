package com.jooc.GazeOffer;

import com.jooc.Solution;

import java.util.Arrays;

public class Solution_51 implements Solution {
    @Override
    public void main() {
        System.out.println(reversePairs(new int[]{1,3,2,3,1}));
    }

    int[] temp;
    public int reversePairs(int[] nums) {
        temp = new int[nums.length];
        return mergeSort(nums,0, nums.length-1);
    }

    private int mergeSort(int[] nums, int left, int right){
        if(left < right){
            int mid = (left + right) / 2;
            int res = mergeSort(nums, left, mid) + mergeSort(nums,mid + 1, right);

            int i = left, j = mid + 1;

            for(int k = left; k <= right; k++){
                temp[k] = nums[k];
            }
            int k = left;
            while(i <= mid && j <= right){
                if(temp[i] <= temp[j]){
                    nums[k++] =temp[i++];
                }
                else{
                    nums[k++] = temp[j++];
                    res += mid - i + 1;
                }
            }

            while(j <= right){
                nums[k++] = temp[j++];
            }
            while(i <= mid){
                nums[k++] = temp[i++];
//                res += right - mid;
            }
            System.out.println(left + " " + right + " " + Arrays.toString(nums) + " " + res);
            return res;
        }
        return 0;
    }

}
