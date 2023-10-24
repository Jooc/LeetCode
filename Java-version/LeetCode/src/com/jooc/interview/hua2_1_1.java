package com.jooc.interview;

import java.util.Scanner;

public class hua2_1_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 读取M和N
        String[] mn = scanner.nextLine().split(" ");
        int M = Integer.parseInt(mn[0]);
        int N = Integer.parseInt(mn[1]);

        // 读取X
        int X = Integer.parseInt(scanner.nextLine());

        // 读取每分钟的请求数
        String[] requestsPerMinuteStr = scanner.nextLine().split(" ");

        int[] requestsPerMinute = new int[requestsPerMinuteStr.length];
        for (int i = 0; i < requestsPerMinute.length; i++) {
            requestsPerMinute[i] = Integer.parseInt(requestsPerMinuteStr[i]);
        }

        int totalRequests = 0;
        int excessRequests = 0;

        // 初始化滑动窗口
        for (int i = 0; i < M; i++) {
            totalRequests += requestsPerMinute[i];
        }

        if (totalRequests > N) {
            excessRequests = totalRequests - N;
            totalRequests -= excessRequests;
            requestsPerMinute[M-1] -= excessRequests;
        }

        // 移动滑动窗口，更新总请求数和 excessRequests
        for (int i = M; i < requestsPerMinute.length; i++) {
            totalRequests += requestsPerMinute[i];
            totalRequests -= requestsPerMinute[i - M];

            if (totalRequests > N) {
                int additionalExcess = totalRequests - N;
                excessRequests += additionalExcess;
                totalRequests -= additionalExcess;
                requestsPerMinute[i] -= additionalExcess;
            }
        }

        System.out.println(excessRequests);
    }
}
