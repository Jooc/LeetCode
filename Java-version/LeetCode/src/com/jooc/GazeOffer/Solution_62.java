package com.jooc.GazeOffer;

import com.jooc.Solution;

public class Solution_62 implements Solution {
    @Override
    public void main() {
        System.out.println(lastRemaining(5,3));
    }

    public int lastRemaining(int n, int m) {
        int dp = 0;

        for(int i = 2; i <= n; i++){
            dp = (dp + m) % i;
        }

        return dp;
    }
}
