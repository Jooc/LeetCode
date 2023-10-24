package com.jooc.interview;

import java.util.Scanner;

public class hua2_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 读取M和N
//        String[] mn = scanner.nextLine().split(" ");
//        int M = Integer.parseInt(mn[0]);
//        int N = Integer.parseInt(mn[1]);
//
//        // 读取X
//        int X = Integer.parseInt(scanner.nextLine());

        int M = 2;
        int N = 10;

        int X = 6;

        String str = "1 9 1 9 8 2";

        // 读取每分钟的请求数
//        String[] requestsPerMinuteStr = scanner.nextLine().split(" ");
        String[] requestsPerMinuteStr = str.split(" ");
        int[] requestsPerMinute = new int[requestsPerMinuteStr.length];
        for (int i = 0; i < requestsPerMinute.length; i++) {
            requestsPerMinute[i] = Integer.parseInt(requestsPerMinuteStr[i]);
        }

        int totalRequests = 0;
        int excessRequests = 0;

        // 初始化滑动窗口
        for (int i = 0; i < M - 1; i++) {
            totalRequests += requestsPerMinute[i];
        }

        int tailIdx = M - 1;

        // 移动滑动窗口，更新总请求数和 excessRequests
        while (tailIdx < X) {
            totalRequests += requestsPerMinute[tailIdx];
            if (tailIdx - M >= 0) {
                totalRequests -= requestsPerMinute[tailIdx - M];
            }

            int i = tailIdx;
            while (totalRequests > N) {
                if (i <= tailIdx - M) {
                    System.out.println("-1");
                    return;
                }
                while (totalRequests > N) {
                    if (requestsPerMinute[i] == 0) {
                        i--;
                        break;
                    }
                    requestsPerMinute[i]--;
                    totalRequests--;
                    excessRequests++;
                }
            }
            tailIdx++;
        }

        System.out.println(excessRequests);
    }
}
