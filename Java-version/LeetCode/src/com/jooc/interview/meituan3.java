package com.jooc.interview;

public class meituan3 {
    public static void main(String[] args) {
        String str = "meili";  // 你的输入字符串
        System.out.println(countBeautifulSubstrings(str));
    }

    public static int countBeautifulSubstrings(String str) {
        int n = str.length();
        int[][] dp = new int[n][4];  // dp[i][j] 表示前 i 个字符，以第 j 个字符（'m', 'e', 'i', 其他）结尾的美丽串数目

        // 初始化
        dp[0][0] = str.charAt(0) == 'm' ? 1 : 0;
        dp[0][1] = str.charAt(0) == 'e' ? 1 : 0;
        dp[0][2] = str.charAt(0) == 'i' ? 1 : 0;
        dp[0][3] = str.charAt(0) != 'm' && str.charAt(0) != 'e' && str.charAt(0) != 'i' ? 1 : 0;

        // 动态规划
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 4; j++) {
                dp[i][j] = dp[i - 1][j];  // 第 i 个字符不保留
            }

            char c = str.charAt(i);
            if (c == 'm') {
                dp[i][0] += 1;  // 自己单独形成一个 'm'
            } else if (c == 'e') {
                dp[i][1] += dp[i - 1][0];  // 加上以 'm' 结尾的所有字符串
            } else if (c == 'i') {
                dp[i][2] += dp[i - 1][1];  // 加上以 'e' 结尾的所有字符串
            } else {
                dp[i][3] += 1;  // 自己单独形成一个 '其他'
                for (int j = 0; j < 3; j++) {
                    dp[i][3] += dp[i - 1][j];  // 加上以 'm', 'e', 'i' 结尾的所有字符串
                }
            }
        }

        return dp[n - 1][2];  // 返回以 'i' 结尾的所有字符串数目
    }
}