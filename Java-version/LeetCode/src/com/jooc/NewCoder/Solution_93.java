package com.jooc.NewCoder;

import com.jooc.Solution;

public class Solution_93 implements Solution {
    @Override
    public void main() {

    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param height int整型一维数组
     * @return int整型
     */
    public int maxArea(int[] height) {
        // write code here
        int n = height.length;
        if (n < 2) return 0;

        int maxArea = 0;
        int left = 0, right = n-1;

        while (left < right) {
            int area = (right - left) * Math.min(height[left], height[right]);
            maxArea = Math.max(maxArea, area);
            if(height[left] <= height[right])
                left++;
            else
                right--;
        }

        return maxArea;
    }
}
