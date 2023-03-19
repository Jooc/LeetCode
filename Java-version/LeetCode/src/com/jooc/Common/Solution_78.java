package com.jooc.Common;

import com.jooc.Solution;

import java.util.ArrayList;
import java.util.List;

public class Solution_78 implements Solution {
    @Override
    public void main() {
        System.out.println(subsets(new int[]{1, 2, 3}));
    }

    public List<List<Integer>> subsets_0(int[] nums) {
        int n = nums.length;
        List<Integer> t = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();

        for (int mask = 0; mask < (1 << n); mask++) {
            t.clear();
            System.out.println(mask);
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) == 0)
                    t.add(nums[i]);
            }
            ans.add(new ArrayList<>(t));
        }

        return ans;
    }

    List<Integer> t = new ArrayList<>();
    List<List<Integer>> ans = new ArrayList<>();

    private void recur(int cur, int[] nums) {
        if (cur == nums.length) {
            ans.add(new ArrayList<>(t));
            return;
        }
        t.add(nums[cur]);
        recur(cur + 1, nums);
        t.remove(t.size() - 1);
        recur(cur + 1, nums);
    }


    public List<List<Integer>> subsets(int[] nums) {
        recur(0, nums);
        return ans;
    }
}
