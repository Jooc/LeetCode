package com.jooc.NewCoder;

import com.jooc.Solution;

import java.util.Arrays;

public class Solution_22 implements Solution {
    @Override
    public void main() {
        System.out.println(compare("1.0", "1.0.0"));
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 比较版本号
     * @param version1 string字符串
     * @param version2 string字符串
     * @return int整型
     */
    public int compare_0 (String version1, String version2) {
        // write code here
        int[] v1 = Arrays.stream(version1.split("\\.")).mapToInt(Integer::parseInt).toArray();
        int[] v2 = Arrays.stream(version2.split("\\.")).mapToInt(Integer::parseInt).toArray();

        int idx = 0;
        while(idx < v1.length || idx < v2.length){
            int val1 = idx < v1.length ? v1[idx] : 0;
            int val2 = idx < v2.length ? v2[idx] : 0;

            if(val1 < val2)
                return -1;
            else if (val1 > val2) {
                return 1;
            }
            idx++;
        }

        return 0;
    }

    public int compare_1 (String version1, String version2) {
        // write code here
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");

        int idx = 0;
        while (idx < v1.length || idx < v2.length) {
            int val1 = Integer.parseInt(idx < v1.length ? v1[idx] : "0");
            int val2 = Integer.parseInt(idx < v2.length ? v2[idx] : "0");

            if (val1 < val2)
                return -1;
            else if (val1 > val2) {
                return 1;
            }
            idx++;
        }

        return 0;
    }

    public int compare (String version1, String version2) {
        // write code here
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");

        int idx = 0;
        while(idx < v1.length || idx < v2.length){
            String str1 = idx < v1.length ? v1[idx] : "0";
            String str2 = idx < v2.length ? v2[idx] : "0";

            int val1 = 0, val2 = 0;
            for(int i = 0; i < str1.length(); i++)
                val1 = val1 * 10 + (str1.charAt(i) - '0');
            for(int i = 0; i < str2.length(); i++)
                val2 = val2 * 10 + (str2.charAt(i) - '0');

            if(val1 < val2)
                return -1;
            else if (val1 > val2) {
                return 1;
            }
            idx++;
        }

        return 0;
    }
}
