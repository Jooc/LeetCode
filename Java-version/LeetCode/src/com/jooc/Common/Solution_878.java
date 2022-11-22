package com.jooc.Common;

import com.jooc.Solution;

public class Solution_878 implements Solution {
    static int MOD = (int) (10e9 + 7);

    public int nthMagicalNumber(int n, int a, int b) {
        long l = Math.min(a, b);
        long r = (long) n * Math.min(a, b);
        int c = lcm(a, b);
        while (l <= r) {
            long mid = (l + r) / 2;
            long cnt = mid / a + mid / b - mid / c;
            if (cnt >= n) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return (int) ((r + 1) % MOD);
    }

    int lcm(int x, int y) {
        return x * y / gcd(x, y);
    }

    public int gcd(int a, int b) {
        return b != 0 ? gcd(b, a % b) : a;
    }

    @Override
    public void main() {

    }
}
