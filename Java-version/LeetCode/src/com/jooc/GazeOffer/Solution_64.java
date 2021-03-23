package com.jooc.GazeOffer;

import com.jooc.Solution;

public class Solution_64 implements Solution {
    @Override
    public void main() {
        System.out.println(sumNums(10000));
    }

    public int sumNums(int n) {
        boolean x = n > 1 && (n += sumNums(n-1)) > 0;
        return n;
    }
}
