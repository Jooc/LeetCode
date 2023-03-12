package com.jooc.Competition;

import com.jooc.Solution;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;

public class WeeklyCOmpetiton_336 implements Solution {
    @Override
    public void main() {
//        System.out.println(maxScore(new int[]{2, -1, 0, 1, -3, 3, -3}));
//        System.out.println(maxScore(new int[]{-2, -3, 0}));
//        System.out.println(beautifulSubarrays(new int[]{4, 3, 1, 2, 4}));
//        System.out.println(beautifulSubarrays(new int[]{0}));
//        System.out.println(beautifulSubarrays(new int[]{0, 0}));
//        System.out.println(beautifulSubarrays(new int[]{1, 10, 4}));
//        System.out.println(findMinimumTime(new int[][]{{2, 3, 1}, {4, 5, 1}, {1, 5, 2}}));
        System.out.println(findMinimumTime(new int[][]{{2, 13, 2}, {6, 18, 5}, {2, 13, 3}}));
    }

    public int vowelStrings(String[] words, int left, int right) {
        HashSet<Character> match = new HashSet<>();
        for (char ch : new char[]{'a', 'e', 'i', 'o', 'u'}) {
            match.add(ch);
        }
        int res = 0;
        for (int i = left; i <= right; i++) {
            if (match.contains(words[i].charAt(0)) && match.contains(words[i].charAt(words[i].length() - 1))) {
                res++;
            }
        }
        return res;
    }

    public int maxScore(int[] nums) {
        int sum = 0;
        for (int num : nums) sum += num;

        int n = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (sum <= 0) {
                sum -= nums[i];
            } else {
                return n - i;
            }
        }
        return 0;
    }

    public long beautifulSubarrays(int[] nums) {
        int n = nums.length;
        int[] xorPrefix = new int[n + 1];
        xorPrefix[0] = 0;
        for (int i = 1; i <= n; i++) {
            xorPrefix[i] = xorPrefix[i - 1] ^ nums[i - 1];
        }
        System.out.println(Arrays.toString(xorPrefix));

//      Count the equal pair in the xorPrefix
        long ans = 0;
        var cnt = new HashMap<Integer, Integer>();
        for (int x : xorPrefix) {
            ans += cnt.getOrDefault(x, 0);
            cnt.merge(x, 1, Integer::sum);
        }

        return ans;
    }


    public int findMinimumTime_0(int[][] tasks) {
        HashSet<Integer> ableTimeSpot = new HashSet<>();
        int res = 0;
        for (int[] task : tasks) {
            int k = task[2];
            if (k > res) res = k;
            for (int i = task[0]; i < task[1] + 1; i++) {
                if (ableTimeSpot.contains(i)) {
                    k--;
                    if (k == 0) break;
                } else {
                    ableTimeSpot.add(i);
                }
            }
            res += k;
        }
        return res;
    }

    public int findMinimumTime(int[][] tasks) {
        Arrays.sort(tasks, Comparator.comparingInt(o -> o[1]));
        boolean[] used = new boolean[2001];
        int ans = 0;
        for (var task : tasks) {
            int start = task[0], end = task[1], duration = task[2];

            for (int time = start; time <= end && duration > 0; time++) {
                if (used[time]) duration--;
            }
            ans += duration;
            while (duration > 0 && end >= start) {
                if (!used[end]) {
                    used[end] = true;
                    duration--;
                }
                end--;
            }

//            System.out.println(Arrays.toString(used));
        }
        return ans;
    }

}
