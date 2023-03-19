package com.jooc.Competition;

import com.jooc.Solution;
import com.jooc.components.TreeNode;

import java.lang.reflect.Array;
import java.util.*;

public class WeeklyCompetition_337 implements Solution {
    @Override
    public void main() {
//        System.out.println(checkValidGrid(new int[][]{{24, 11, 22, 17, 4}, {21, 16, 5, 12, 9}, {6, 23, 10, 3, 18}, {15, 20, 1, 8, 13}, {0, 7, 14, 19, 2}}));
//        System.out.println(beautifulSubsets(new int[]{2, 4, 6}, 2));
        System.out.println(beautifulSubsets(new int[]{4, 2, 5, 9, 10, 3}, 1));

    }

    public int[] evenOddBit(int n) {
        int odd = 0, even = 0;

        int bit = 0;
        while (n != 0) {
            if ((n & 1) == 1) {
                if (bit % 2 == 0) even++;
                else odd++;
            }
            n >>= 1;
            bit++;
        }
        return new int[]{even, odd};
    }


    int[][] directions = new int[][]{{-2, -1}, {-2, 1}, {-1, -2}, {-1, 2}, {1, -2}, {1, 2}, {2, -1}, {2, 1}};

    private boolean checkValidPos(int x0, int y0, int x1, int y1) {
        int diffX = x1 - x0;
        int diffY = y1 - y0;

        for (int[] direction : directions) {
            if (Arrays.equals(direction, new int[]{diffX, diffY}))
                return true;
        }

        return false;
    }

    public boolean checkValidGrid(int[][] grid) {
        int n = grid.length;
        if (grid[0][0] != 0) return false;

        HashMap<Integer, ArrayList<Integer>> myMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ArrayList<Integer> pos = new ArrayList<>();
                pos.add(i);
                pos.add(j);
                myMap.put(grid[i][j], pos);
            }
        }

        for (int step = 1; step < n * n; step++) {
            ArrayList<Integer> pos0 = myMap.get(step - 1);
            ArrayList<Integer> pos1 = myMap.get(step);
            if (!checkValidPos(pos0.get(0), pos0.get(1), pos1.get(0), pos1.get(1))) {
                return false;
            }
            System.out.println(step);
            System.out.println("" + pos0.get(0) + " " + pos0.get(1) + " " + pos1.get(0) + " " + pos1.get(1));
        }
        return true;
    }


//    private int count = 0;
//
//    public int beautifulSubsets(int[] nums, int k) {
//        int n = nums.length;
//        boolean[] chosen = new boolean[n];
//        Arrays.fill(chosen, false);
//        backtrack(0, nums, k, chosen);
//
//        return count;
//    }
//
//    private void backtrack(int pos, int[] nums, int k, boolean[] chosen) {
//        if (pos == nums.length) {
//            if (isBeautiful(chosen, nums, k)) {
//                System.out.println(Arrays.toString(chosen));
//                count++;
//            }
//            return;
//        }
//
//        chosen[pos] = true;
//        backtrack(pos + 1, nums, k, chosen);
//        chosen[pos] = false;
//        backtrack(pos + 1, nums, k, chosen);
//    }
//
//    private boolean isBeautiful(boolean[] chosen, int[] nums, int k) {
//        boolean allFalse = true;
//
//        for (int i = 0; i < chosen.length; i++) {
//            if (chosen[i]) {
//                allFalse = false;
//                for (int j = i + 1; j < chosen.length; j++) {
//                    if (chosen[j]) {
//                        if (Math.abs(nums[i] - nums[j]) == k) {
//                            return false;
//                        }
//                    }
//                }
//            }
//        }
//        return !allFalse;
//    }

    public int beautifulSubsets_0(int[] nums, int k) {
        int n = nums.length;

        int invalidPairCount = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (Math.abs(nums[j] - nums[i]) == k)
                    invalidPairCount++;
            }
        }
        System.out.println(invalidPairCount);

        for (int i = 3; i < n; i++) {
            int leftNum = n - i + 1;
            invalidPairCount += (leftNum - 1) * (leftNum - 2) / 2;
        }

        return (int) Math.pow(2, n) - 1 - invalidPairCount;
    }


    private int ans = -1;
    private HashMap<Integer, Integer> duplicateRecord = new HashMap<>();

    private void dfs(int[] nums, int i, int k) {
        if (i == nums.length){
            ans++;
            return;
        }
        dfs(nums, i+1, k);
        if(!duplicateRecord.containsKey(nums[i]-k) && !duplicateRecord.containsKey(nums[i]+k)){
            duplicateRecord.put(nums[i], 1);
            dfs(nums, i + 1, k);
            duplicateRecord.remove(nums[i]);
        }
    }

    public int beautifulSubsets(int[] nums, int k) {
        int n = nums.length;
        dfs(nums,0, k);
        return ans;
    }
}
