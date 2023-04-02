package com.jooc.Competition;

import com.jooc.Solution;

import java.util.*;

public class S339 implements Solution {
    @Override
    public void main() {
//        System.out.println(findTheLongestBalancedSubstring("01000111"));
//        System.out.println(findMatrix(new int[]{1, 3, 4, 1, 2, 3, 1}));
//        System.out.println(miceAndCheese(new int[]{1, 4, 4, 6, 4}, new int[]{6, 5, 3, 6, 1}, 1));
        System.out.println(miceAndCheese(new int[]{3, 1, 1, 3}, new int[]{3, 2, 3, 1}, 3));
//        System.out.println(miceAndCheese(new int[]{1, 1, 3, 4}, new int[]{4, 4, 1, 1}, 2));
        System.out.println(miceAndCheese(new int[]{1, 3}, new int[]{5, 4}, 1));
//        System.out.println(miceAndCheese(new int[]{1, 1}, new int[]{1, 1}, 2));
//        System.out.println(miceAndCheese(new int[]{1}, new int[]{4}, 1));
    }

    public int findTheLongestBalancedSubstring(String s) {
        int n = s.length();
        int left = 0, right = 0;
        int zeroCount = 0, oneCount = 0;
        int maxLength = 0;
        while (right < n) {
            if (s.charAt(right) == '0') {
                zeroCount++;
            } else {
                oneCount++;
                if (right == n - 1 || s.charAt(right + 1) == '0') {
                    maxLength = Math.max(maxLength, Math.min(zeroCount, oneCount) * 2);
                    zeroCount = 0;
                    oneCount = 0;
                }
            }
            right++;
        }
        return maxLength;
    }

    public List<List<Integer>> findMatrix(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        HashMap<Integer, Integer> counter = new HashMap<>();
        for (int num : nums) {
            if (!counter.containsKey(num)) {
                counter.put(num, 1);
                if (res.size() == 0) {
                    res.add(new ArrayList<>());
                }
                res.get(0).add(num);
            } else {
//                System.out.println(num + " " + counter.get(num));
                while (res.size() <= counter.get(num)) {
                    res.add(new ArrayList<>());
                }
                res.get(counter.get(num)).add(num);
                counter.put(num, counter.get(num) + 1);
            }
        }
        return res;
    }

    public int miceAndCheese(int[] reward1, int[] reward2, int k) {
        int n = reward2.length;
        int[] diff = new int[n];
        int res = 0;

        for (int i = 0; i < n; i++) {
            res += reward1[i];
            diff[i] = reward1[i] - reward2[i];
        }

        Arrays.sort(diff);

        for(int i = 0; i < n-k; i++){
            res -= diff[i];
        }

        return res;
    }
}
