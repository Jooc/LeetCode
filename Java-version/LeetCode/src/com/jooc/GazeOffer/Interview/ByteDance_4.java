package com.jooc.GazeOffer.Interview;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;


class ByteDance_4_0 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int m = in.nextInt();
        int k = in.nextInt();

        PriorityQueue<Integer> valQueue = new PriorityQueue<>((o1, o2) -> {
            if (Math.abs(o1) == Math.abs(o2)) {
                return o1 < 0 ? -1 : 1;
            } else {
                return Math.abs(o2) - Math.abs(o1);
            }
        });

        for (int i = 0; i < n; i++) {
            valQueue.add(in.nextInt());
        }

        for (int i = 0; i < m; i++) {
            int p = in.nextInt();

            int tempK = k;
            PriorityQueue<Integer> tempQueue = new PriorityQueue<>(valQueue);

            int res = 0;

            for (int j = 0; j < p; j++) {
                int val = tempQueue.poll();
                if (tempK > 0) {
                    res += val * val;
                    tempK--;
                } else {
                    res += Math.max(val, 0);
                }
            }
            System.out.println(res);
        }
    }
}


public class ByteDance_4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int m = in.nextInt();
        int k = in.nextInt();

        PriorityQueue<Integer> valQueue = new PriorityQueue<>((o1, o2) -> {
            if (Math.abs(o1) == Math.abs(o2)) {
                return o1 < 0 ? -1 : 1;
            } else {
                return Math.abs(o2) - Math.abs(o1);
            }
        });

        for (int i = 0; i < n; i++) {
            valQueue.add(in.nextInt());
        }

        int[] Ps = new int[m];
        int maxP = 0;
        for (int i = 0; i < m; i++) {
            Ps[i] = in.nextInt();
            maxP = Math.max(maxP, Ps[i]);
        }

        long[][] dp = new long[n + 1][k + 1];

        for (int i = 1; i <= n && i <= maxP; i++) {
            int val = valQueue.poll();

            dp[i][0] = dp[i-1][0] + Math.max(0, val);
            for (int j = 1; j <= i && j <= k; j++) {
                dp[i][j] = Math.max(dp[i - 1][j] + Math.max(0, val), dp[i - 1][j - 1] + (long) val * val);
            }
        }

        for(int i = 0; i < m; i++){
            long maxVal = 0;
            for(int j = 0; j <= k; j++){
                maxVal = Math.max(maxVal, dp[Ps[i]][j]);
            }
            System.out.println(maxVal);
        }
    }
}
