package com.jooc.GazeOffer;

public class Solution_44 implements Solution {
    public void main() {
        System.out.println(findNthDigit(1000));
    }

    public int findNthDigit(int n) {
        long begin = 1;
        long count = 9;

        int digitCount = 1;
        while (n > count) {
            n -= count;
            begin *= 10;
            digitCount++;
            count = digitCount * begin * 9;
        }
        long num = begin + (n-1) / digitCount;
        return Long.toString(num).charAt((n-1)%digitCount) - '0';

//        int targetNum = begin + (n - 1) / digitCount;
//        int nthDigit = (n+digitCount-2) % digitCount;
//
//        for (int i = 0; i < nthDigit; i++) {
//            targetNum /= 10;
//        }
//
//        return targetNum % 10;
    }
}
