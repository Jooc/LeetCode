package com.jooc.Solutions;

import java.util.Arrays;
import java.util.HashSet;

public class Solution_61 implements Solution {
    @Override
    public void main() {
        System.out.println(isStraight(new int[]{0,0,1,2,5}));
    }

    public boolean isStraight_0(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        HashSet<Integer> set = new HashSet<>();
        for(int num: nums){
            if(num == 0) continue;
            if(set.contains(num)){
                return false;
            }
            set.add(num);
            max = Math.max(max, num);
            min = Math.min(min, num);
        }
        return max - min < 5;
    }

    public boolean isStraight(int[] nums){
        Arrays.sort(nums);

        int joker = 0;
        for(int i = 0; i < 4; i++){
            if(nums[i] == 0) joker++;
            else if(nums[i] == nums[i+1]) return false;
        }
        return nums[4] - nums[joker] < 5;
    }


}
