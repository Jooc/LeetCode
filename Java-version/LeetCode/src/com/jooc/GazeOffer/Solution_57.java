package com.jooc.GazeOffer;

import com.jooc.Solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution_57 implements Solution {
    @Override
    public void main() {
        int[][] res = findContinuousSequence(9);
        for (int i = 0; i < res.length; i++) {
            System.out.println(Arrays.toString(res[i]));
        }
    }

    public int[] twoSum(int[] nums, int target) {
        int before = 0, behind = nums.length - 1;

        while (before < behind) {
            if (nums[before] + nums[behind] == target) {
                return new int[]{nums[before], nums[behind]};
            } else if (nums[before] + nums[behind] > target) {
                behind--;
            } else {
                before++;
            }
        }

        return new int[0];
    }

    public int[][] findContinuousSequence_0(int target) {
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        int rightBorder = target / 2 + 1;

        for (; rightBorder >= 2; rightBorder--) {
            int sum = rightBorder;
            for (int leftBorder = rightBorder - 1; leftBorder >= 1; leftBorder--) {
                sum += leftBorder;
                if (sum == target) {
                    ArrayList<Integer> list = new ArrayList<>();
                    for (int i = leftBorder; i <= rightBorder; i++) {
                        list.add(i);
                    }
                    lists.add(list);
                    continue;
                }
                if (sum > target) {
                    break;
                }
            }
        }

        int[][] res = new int[lists.size()][];
        for (int i = lists.size() - 1; i >= 0; i--) {
            int len = lists.get(i).size();
            int[] l = new int[len];
            for (int j = 0; j < len; j++) {
                l[j] = lists.get(i).get(j);
            }
            res[lists.size() - 1 - i] = l;
        }

        return res;
    }

    public int[][] findContinuousSequence(int target) {
        int left = 1, right = 2;
        int sum = 3;

        List<int[]> res = new ArrayList<>();
        while (left < right) {
            if (sum == target) {
                int[] s_res = new int[right - left + 1];
                for (int i = 0; i <= right - left; i++) {
                    s_res[i] = left + i;
                }
                res.add(s_res);
            }
            if (sum > target) {
                sum -= left;
                left++;
            } else {
                right++;
                sum += right;
            }
        }

        return res.toArray(new int[0][]);
    }
}
