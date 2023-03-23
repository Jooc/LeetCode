package com.jooc.Common;

import com.jooc.Solution;

import java.util.Arrays;

public class Solution_121 implements Solution {
    @Override
    public void main() {

    }

    public int maxProfit_0(int[] prices) {
        int n = prices.length;
        int leastPricePre = prices[0];
        int maxPro = 0;

        for (int i = 1; i < n; i++) {
            maxPro = Math.max(maxPro, prices[i] - leastPricePre);

            if (prices[i] < leastPricePre) {
                leastPricePre = prices[i];
            }
        }
        return maxPro;
    }
}
