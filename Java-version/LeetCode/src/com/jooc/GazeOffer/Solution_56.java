package com.jooc.GazeOffer;

import com.jooc.Solution;

import java.util.HashSet;
import java.util.Iterator;

public class Solution_56 implements Solution {
    @Override
    public void main() {
        System.out.println(singleNumber(new int[]{2, 2, 5, 2}));
    }

    /**
     * time = O(n)
     * space = O(n)
     */
    public int[] singleNumbers_0(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) set.remove(num);
            else set.add(num);
        }

        int[] res = new int[set.size()];
        int i = 0;
        for (Iterator it = set.iterator(); it.hasNext(); ) {
            res[i++] = (int) it.next();
        }
        return res;
    }

    public int[] singleNumbers(int[] nums) {
        int boolXor = 0;
        for (int num : nums) {
            boolXor ^= num;
        }

        int kth = 0;
        while ((boolXor & 1) == 0) {
            boolXor >>= 1;
            kth++;
        }

        int[] res = new int[2];
        res[0] = 0;
        res[1] = 0;
        for (int i = 0; i < nums.length; i++) {
            if (((nums[i] >> kth) & 1) == 1) {
                res[0] ^= nums[i];
            } else {
                res[1] ^= nums[i];
            }
        }

        return res;
    }

    public int singleNumber_0(int[] nums) {
        int[] counts = new int[32];

        for (int num : nums) {
            int i = 0;
            while (num != 0) {
                counts[31 - i] += num & 1;
                i++;
                num >>= 1;
            }
        }

        int res = 0;
        for (int count : counts) {
            res <<= 1;
            res |= (count % 3);
        }

        return res;
    }

    public int singleNumber(int[] nums){
        int ones = 0, twos =0;
        for(int num : nums){
            ones = ones ^ num & ~twos;
            twos = twos ^ num & ~ones;
        }
        return ones;
    }

}
