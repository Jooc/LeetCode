package com.jooc.Common;

import com.jooc.Solution;

public class Solution_50 implements Solution {
    @Override
    public void main() {
//        System.out.println(myPow(2d, 10));
        System.out.println(myPow(2.0, -2147483647));
    }

    private double func(double x, long n){
        if (n == 0 || x == 1) return 1;
        if (n == 1) return x;
        if (n < 0) return 1 / func(x, -n);

        if (n % 2 == 0) {
            double tmp = func(x, n / 2);
            return tmp * tmp;
        } else {
            return x * func(x, n - 1);
        }    }

    public double myPow(double x, int n) {
        return func(x, n);
    }
}
