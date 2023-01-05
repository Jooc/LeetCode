package com.jooc.NewCoder;

import com.jooc.Solution;

public class Solution_17 implements Solution {
    @Override
    public void main() {

    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param nums   int整型一维数组
     * @param target int整型
     * @return int整型
     */
    public int search(int[] nums, int target) {
        // write code here

        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) return mid;
            else if (target < nums[mid]) {
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return -1;
    }
}
