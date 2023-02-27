package com.jooc.NewCoder;

import com.jooc.Solution;

import java.util.Arrays;
import java.util.HashMap;

public class Solution_50 implements Solution {
    @Override
    public void main() {
        System.out.println(Arrays.toString(twoSum(new int[]{3, 2, 4}, 6)));
    }

    public int[] twoSum(int[] numbers, int target) {
        // write code here

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(target - numbers[i])) {
                return new int[]{map.get(target - numbers[i]), i+1};
            }
            map.put(numbers[i], i+1);
        }
        return new int[]{-1, -1};
    }
}
