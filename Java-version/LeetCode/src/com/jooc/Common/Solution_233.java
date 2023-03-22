package com.jooc.Common;

import com.jooc.Solution;

import java.util.Arrays;

public class Solution_233 implements Solution {
    @Override
    public void main() {
        System.out.println(countDigitOne(12345));
    }

    public int countDigitOne(int n) {
        String s = String.valueOf(n);
        int m = s.length();

        int[] ps = new int[m], ss = new int[m];
        for (int i = 0; i < m; i++) {
            ps[i] = i == 0 ? 0 : Integer.parseInt(s.substring(0, i));
            ss[i] = i == m - 1 ? 0 : Integer.parseInt(s.substring(i + 1, m));
        }

//        System.out.println(Arrays.toString(ps));
//        System.out.println(Arrays.toString(ss));

        int ans = 0;
        for(int i = 0; i < m; i++){
            int x = s.charAt(i) - '0';
            int len = m - i - 1;

            int prefix = ps[i], suffix = ss[i];

            int total = 0;
            total += prefix * Math.pow(10, len);
            if(x == 0){
            } else if (x == 1) {
                total += suffix + 1;
            }else{
                total += Math.pow(10, len);
            }
            ans += total;
        }
        return ans;
    }
}
