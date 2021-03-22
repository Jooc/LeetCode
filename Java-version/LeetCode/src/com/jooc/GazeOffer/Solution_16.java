package com.jooc.GazeOffer;

public class Solution_16 implements Solution {
    @Override
    public void main() {
        System.out.println(myPow(2.0, 10));
    }

    public double myPow(double x, int n) {
        if (x == 0) return 0;
        double res = 1.0;
        long b = n;

        if (b < 0) {
            x = 1 / x;
            b = -b;
        }

        while (b > 0) {
            if ((b & 1) == 1) res *= x;
            x *= x;
            n >>= 1;
        }

        return res;
    }
}
