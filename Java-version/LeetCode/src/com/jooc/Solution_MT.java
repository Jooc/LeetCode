package com.jooc;

import java.io.InputStream;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;

public class Solution_MT implements Solution {
    @Override
    public void main() {
    }


    public static void main_1(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int A = sc.nextInt();
        int B = sc.nextInt();

        int[][] enemy = new int[N][2];
        for (int i = 0; i < N; i++) {
            enemy[i][0] = sc.nextInt();
            enemy[i][1] = sc.nextInt();
        }
        Arrays.sort(enemy, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0]) return o1[0] - o2[0];
                return o1[1] - o2[1];
            }
        });

        int maxCount = 0;
        for (int i = 0; i < N; i++) {
            int x0 = enemy[i][0];
            int y0 = enemy[i][1];
            int[] countWithDirections = new int[4];
            Arrays.fill(countWithDirections, 1);

            for (int j = 0; j < N; j++) {
                if (i == j) continue;
                int x1 = enemy[j][0];
                int y1 = enemy[j][1];

                int diffX = Math.abs(x1 - x0);
                int diffY = Math.abs(y1 - y0);

                if (diffX <= A && diffY <= B) {
                    if (x1 <= x0 && y1 <= y0)
                        countWithDirections[0]++;
                    else if (x1 >= x0 && y1 <= y0)
                        countWithDirections[1]++;
                    else if (x1 <= x0 && y1 >= y0)
                        countWithDirections[2]++;
                    else
                        countWithDirections[3]++;
                }
            }
            for (int k = 0; k < 4; k++) {
                maxCount = Math.max(maxCount, countWithDirections[k]);
            }
        }
        System.out.println(maxCount);
    }

    public static void main_2(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        int[] colors = new int[N];
        for (int i = 0; i < N; i++) {
            colors[i] = sc.nextInt();
        }

        int left = 0, right = 0;
        int diffCount = 0;
        int maxLen = 0;
        int[] counter = new int[2001];
        while (right < N) {
            if (counter[colors[right]] == 0) {
                diffCount++;
            }
            counter[colors[right]]++;
            while (diffCount > K) {
                counter[colors[left]]--;
                if (counter[colors[left]] == 0) {
                    diffCount--;
                }
                left++;
            }
            maxLen = Math.max(right - left + 1, maxLen);
            right++;
        }

        System.out.println(maxLen);
    }


    private static boolean isP(char[] chars) {
        int n = chars.length;
        int left = 0, right = n - 1;

        while (left < right) {
            if (chars[left++] != chars[right--])
                return false;
        }
        return true;
    }

    private static char[] canAdjust(char[] chars, int leftOp, int low, int high) {
        boolean flag = false;
        while (low <= high) {
            char tempCL = chars[low];
            char tempCH = chars[high];
            if (leftOp >= 2 && chars[low] == chars[high]) {
                if (chars[low] == 'a') {
                    low++;
                    high--;
                    continue;
                }
                chars[low] = 'a';
                chars[high] = 'a';
                if (isP(chars)) break;
                chars[low] = tempCL;
                chars[high] = tempCH;
            } else {
                chars[low] = 'a';
                leftOp--;
                if (isP(chars)) {
                    break;
                } else {
                    if (leftOp >= 1) {
                        char[] newChars = canAdjust(chars, leftOp, low, high);
                        if (newChars != null) {
                            chars = newChars;
                            break;
                        }
                    }
                }

                chars[low] = tempCL;
                chars[high] = 'a';
                if (isP(chars)) {
                    break;
                } else {
                    if (leftOp >= 1) {
                        char[] newChars = canAdjust(chars, leftOp, low, high);
                        if (newChars != null) {
                            chars = newChars;
                            break;
                        }
                    }
                }
                chars[high] = tempCH;
            }
            low++;
            high--;
        }

        return chars;
    }


    public static void main_3(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        int n = str.length();
        char[] chars = str.toCharArray();

        chars = canAdjust(chars, 0, n - 1, 2);

        System.out.println(String.valueOf(chars));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int X = sc.nextInt();
        int Y = sc.nextInt();

        int[][] cost = new int[N][2];
        for (int i = 0; i < N; i++) {
            cost[i][0] = sc.nextInt();
            cost[i][1] = sc.nextInt();
        }

        int[][] dp = new int[X + 1][Y + 1];
        dp[0][0] = 0;

        for (int i = 0; i < N; i++) {
            for (int j = X; j >= cost[i][0]; j--) {
                for (int k = Y; k >= 1; k--) {
                    dp[j][k] = Math.max(dp[j][k], Math.max(dp[j - cost[i][0]][k] + 1, dp[j - cost[i][1]][k - 1] + 1)
                    );
                }
            }
        }

        int cc = 0;
        int maxCount = 0;
        for (int i = 0; i <= X; i++) {
            for (int j = 0; j <= Y; j++) {
                if(dp[i][j] > maxCount){
                    maxCount = dp[i][j];
                    cc = i;
                }
            }
        }
        System.out.println(maxCount + " " + cc);
    }

    int[] power;

    private static void dfs() {

    }

    public static void main_5(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] powerDistance = new int[N];
        for (int i = 0; i < N; i++) {
            powerDistance[i] = sc.nextInt();
        }


    }
}
