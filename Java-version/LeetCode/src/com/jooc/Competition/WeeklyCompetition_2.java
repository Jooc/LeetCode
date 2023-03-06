package com.jooc.Competition;

import com.jooc.Solution;
import com.jooc.components.TreeNode;

import java.util.*;

public class WeeklyCompetition_2 implements Solution {
    @Override
    public void main() {
//        System.out.println(passThePillow(3, 2));
//        System.out.println(findValidSplit(new int[]{4, 7, 8, 15, 3, 5}));
//        System.out.println(findValidSplit(new int[]{4, 7, 15, 8, 3, 5}));
        System.out.println(waysToReachTarget(6, new int[][]{{6, 1}, {3, 2}, {2, 3}}));
    }

    public int passThePillow(int n, int time) {
        int left = time % (n - 1);
        int round = time / (n - 1);

        if (round % 2 != 0) {
            return (n - left);
        } else {
            return left + 1;
        }
    }

    public long kthLargestLevelSum(TreeNode root, int k) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        ArrayList<Long> sums = new ArrayList<>();
        while (!queue.isEmpty()) {
            int layerSize = queue.size();
            long layerSum = 0;
            for (int i = 0; i < layerSize; i++) {
                TreeNode node = queue.poll();
                layerSum += node.val;
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            sums.add(layerSum);
        }
        Collections.sort(sums);

        return sums.size() < k ? -1 : sums.get(sums.size() - k);
    }

    public static long gcd(long m, long n) {
        long result = 0;
        while (n != 0) {
            result = m % n;
            m = n;
            n = result;
        }
        return m;

    }

    public int findValidSplit(int[] nums) {
//        System.out.println(gcd(4, 12600));
//        System.out.println(gcd(28, 1800));


        int n = nums.length;
        int begin = 1;
        for (int i = 0; i < n - 1; i++) {
            boolean flag = false;
            for (int j = n - 1; j > begin; j--) {
                if (gcd(nums[i], nums[j]) != 1) {
                    begin = j;
                    flag = true;
                    break;
                }
            }
            if (i >= begin && !flag) return i;
        }

        return -1;
    }

    public int waysToReachTarget(int target, int[][] types) {
        int n = types.length;
        int[][] dp = new int[n][target + 1];

        HashMap<Integer, Integer> moneyIndex = new HashMap<>();
        ArrayList<Integer> mianes = new ArrayList<>();

        for (int i = 0; i < types.length; i++) {
            mianes.add(types[i][1]);
            moneyIndex.put(types[i][1], i);
        }

        for (int i = 0; i < mianes.size(); i++) {
            dp[i][0] = 1;
        }

        int maxSum = 0;
        for (int i = 0; i < mianes.size(); i++) {
            int curMiane = mianes.get(i);
            maxSum += curMiane * types[moneyIndex.get(curMiane)][0];

            for (int curTarget = 1; curTarget <= target && curTarget < maxSum; curTarget++) {
                for (int curMianeCount = 1; curMianeCount < types[moneyIndex.get(curMiane)][0]; curMianeCount++) {
                    if (curTarget - curMianeCount * curMiane == 0) {
                        dp[i][curTarget] = dp[i][curTarget] + 1;
                    } else if (curTarget - curMianeCount * curMiane > 0) {
                        dp[i][curTarget] = dp[i][curTarget - curMianeCount * curMiane] + 1;
                    }else if(i > 0){
                        dp[i][curTarget] = dp[i-1][curTarget];
                    }
                    if (dp[i][curTarget] >= (1e9 + 7)) dp[i][curTarget] %= (1e9 + 7);
                    if(curTarget - curMianeCount * curMiane <= 0) break;
                }
                System.out.println(Arrays.deepToString(dp));
            }
        }

        return dp[n - 1][target];
    }
}
