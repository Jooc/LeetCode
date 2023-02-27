package com.jooc.NewCoder;

import com.jooc.Solution;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution_52 implements Solution {
    @Override
    public void main() {

    }

    //    HashSet
    public int[] FindNumsAppearOnce_0(int[] array) {
        // write code here
        Set<Integer> exist = new HashSet<>();
        for (int num : array) {
            if (exist.contains(num)) exist.remove(num);
            else exist.add(num);
        }
        int[] res = new int[2];
        int idx = 0;
        for (Integer num : exist) {
            res[idx++] = num;
        }
        return res;
    }

    //    bit operation
    public int[] FindNumsAppearOnce(int[] array) {
        // write code here
        int xorRes = 0;
        for (int num : array) xorRes ^= num;

        int k = 1;
        while ((xorRes & k) == 0)
            k <<= 1;


        int res1 = 0, res2 = 0;
        for (int num : array) {
            if ((num & k) == 0)
                res1 ^= num;
            else
                res2 ^= num;
        }

        if(res1 < res2)
            return new int[]{res1, res2};
        else
            return new int[]{res2, res1};
    }
}
