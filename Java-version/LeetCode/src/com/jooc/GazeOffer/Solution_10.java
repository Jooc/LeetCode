package com.jooc.GazeOffer;

import com.jooc.Solution;

import java.util.HashMap;

public class Solution_10 implements Solution {
    @Override
    public void main() {
        System.out.println(subarraySum(new int[]{1, 1, 1}, 2));
    }

    public int subarraySum_0(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int n = nums.length;
        int[] prefix = new int[n + 1];

        int res = 0;
        for (int i = 1; i <= n; i++) {
            prefix[i] = prefix[i - 1] + nums[i - 1];
            if (map.containsKey(prefix[i] - k))
                res += map.get(prefix[i] - k);

            if (map.containsKey(prefix[i]))
                map.put(prefix[i], map.get(prefix[i]) + 1);
            else
                map.put(prefix[i], 1);
        }
        return res;
    }

    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int prefix = 0, res = 0;
        for (int num: nums) {
            prefix+=num;
            if(map.containsKey(prefix-k))
                res+=map.get(prefix-k);
            if(map.containsKey(prefix))
                map.put(prefix, map.get(prefix)+1);
            else
                map.put(prefix, 1);
        }
        return res;
    }
}
