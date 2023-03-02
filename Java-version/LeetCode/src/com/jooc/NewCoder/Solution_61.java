package com.jooc.NewCoder;

import com.jooc.Solution;

public class Solution_61 implements Solution {
    @Override
    public void main() {
        System.out.println(Fibonacci(4));
    }

    public int Fibonacci_0(int n) {
        if(n <= 2) return 1;
        return Fibonacci(n-1) + Fibonacci(n-2);
    }


//    First DP
    public int Fibonacci_1(int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i < n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n-1];
    }

//    Tiny simplified DP
    public int Fibonacci(int n) {
        int a = 1, b = 1, c = 1;
        for(int i = 2; i < n; i++){
            c = a + b;
            a = b;
            b = c;
        }

        return c;
    }
}
