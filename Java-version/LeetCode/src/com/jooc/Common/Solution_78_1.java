package com.jooc.Common;

import com.jooc.Solution;

import java.util.ArrayList;
import java.util.List;

public class Solution_78_1 implements Solution {
    @Override
    public void main() {
        System.out.println(subsets(new int[]{1, 2, 3}));
        System.out.println(subsets(new int[]{0}));
    }


    public List<List<Integer>> subsets_0(int[] nums) {
        int n = nums.length;
        int mask = 0;

        List<List<Integer>> res = new ArrayList<>();
        while (mask < Math.pow(2, n)) {
            int i = 0;
            List<Integer> temp = new ArrayList<>();
            while (mask >> i != 0) {
                if (((mask >> i) & 1) == 1)
                    temp.add(nums[i]);
                i++;
            }
            res.add(new ArrayList<>(temp));
            mask++;
        }
        return res;
    }

    List<List<Integer>> res = new ArrayList<>();

    private void dfs(List<Integer> temp, int[] nums, int index){

    }

    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> temp = new ArrayList<>();
        res.add(new ArrayList<>(temp));

        dfs(temp, nums, 0);

        return res;
    }
}
