package com.jooc.interview;

public class meituan4 {
    public static void main(String[] args) {
        String input = "meili";  // 示例输入
        int n = input.length();
        int[] dp = new int[n + 1];  // dp[i] 表示前 i 个字符中，有多少种删除方案可以得到一个美丽串

        dp[0] = 0;  // 空串是美丽串的一种特例

        for (int i = 1; i <= n; ++i) {
            dp[i] = dp[i - 1];  // 不删除当前字符
            // 检查是否可以构成 "mei" 子串
            for (int j = i - 1; j >= 1 && j >= i - 4; --j) {
                if (input.charAt(i - 1) == 'i' &&
                    input.charAt(j - 1) == 'e' &&
                    i - j >= 2) {
                    for (int k = j - 1; k >= 1 && k >= j - 3; --k) {
                        if (input.charAt(k - 1) == 'm') {
                            dp[i] += dp[k - 1];
                        }
                    }
                }
            }
        }

        System.out.println(dp[n]);  // 输出最终结果
    }
}