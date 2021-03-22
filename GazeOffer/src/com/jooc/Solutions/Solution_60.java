package com.jooc.Solutions;

import java.util.Arrays;

public class Solution_60 implements Solution {
    @Override
    public void main() {
        System.out.println(Arrays.toString(dicesProbability(2)));
    }

    public double[] dicesProbability(int n) {
        double[] res = new double[6];
        Arrays.fill(res, 1.0/6.0);

        for(int i = 2; i <= n; i++){
            double[] tmp = new double[5*i+1];
            for(int j = 0; j < res.length; j++){
                for(int k = 1; k <= 6; k++){
                    tmp[k+j-1] += res[j]*(1.0/6.0);
                }
            }
            res = tmp;
        }

        return res;
    }

}
