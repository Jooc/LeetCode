package com.jooc.Solutions;

public class Solution_49 implements Solution {

    @Override
    public void main() {
        System.out.println(nthUglyNumber(10));
    }

    public int nthUglyNumber(int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        int a = 0, b = 0, c = 0;

        for(int i = 1; i < n; i++){
            int numA = dp[a] * 2, numB = dp[b] * 3, numC = dp[c] * 5;
            dp[i] = Math.min(numA, Math.min(numB, numC));

            if(dp[i] == numA) a++;
            if(dp[i] == numB) b++;
            if(dp[i] == numC) c++;
        }

        return dp[n-1];
    }
}
