package com.jooc.GazeOffer;

public class Solution_15 implements Solution {
    @Override
    public void main() {
        System.out.println(hammingWeight(11));
    }

    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int res = 0;
        int mask = 1;
        for (int i = 0; i < 32; i++) {
            if ((n & mask) != 0) {
                res++;
            }
            mask <<= 1;
        }
        return res;
    }

    public int hanmingWeight(int n) {
        int res = 0;
        while (n != 0) {
            res++;
            n = n & (n - 1);
        }
        return res;
    }

}
