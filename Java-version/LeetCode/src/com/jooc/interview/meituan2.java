package com.jooc.interview;

import java.util.Scanner;

public class meituan2 {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        String input = scanner.next(); // 读取输入字符串
        String input = "meei";
        int result = countBeautifulSubstrings(input);
        System.out.println(result);
    }

    public static int countBeautifulSubstrings_0(String s) {
        int count = 0;
        int length = s.length();

        // 遍历字符串 s
        for (int i = 0; i < length; i++) {
            if (s.charAt(i) == 'm') {
                for (int j = i + 1; j < length; j++) {
                    if (s.charAt(j) == 'e') {
                        for (int k = j + 1; k < length; k++) {
                            if (s.charAt(k) == 'i') {
                                // 找到一个 "mei" 子串，增加计数器 count
                                count++;
                                k++;
                            }
                        }
                        j++;
                    }
                }
                i++;
            }
        }

        return count + 1;
    }

    static int calSum(int x) {
        int sum = 0;
        for (; x > 0; x -= 2) {
            sum += x;
        }
        return sum;
    }

    public static int countBeautifulSubstrings(String str) {
        int count = 0;
        int n = str.length();

        // 遍历字符串 s
        for (int i = 0; i < n - 2; i++) {
            if (str.charAt(i) == 'm') {
                if (str.charAt(i + 1) == 'e' || str.charAt(i + 2) == 'e') {
                    for (int j = str.charAt(i + 1) == 'e' ? i + 1 : i + 2; j < n - 1 && j <= i + 2; j++) {
                        if (str.charAt(j + 1) == 'i' || str.charAt(j + 2) == 'i') {
                            int k = str.charAt(j + 1) == 'i' ? j + 1 : j + 2;
                            if (k - i == 2) count += (1 + calSum(n - 3));
                            else {
                                count += Math.max(0, k - i + 1 - 2) + calSum(n - (k - i + 1));
                            }
                            j = k + 1;
                        }
                    }
                }
            }
        }
        return count;
    }
}