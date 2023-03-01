package com.jooc.NewCoder;

import com.jooc.Solution;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Solution_59 implements Solution {
    @Override
    public void main() {
        System.out.println(Nqueen(4));
    }

    /**
     * @param n int整型 the n
     * @return int整型
     */

    private final Set<Integer> usedCols = new HashSet<>();
    private final Set<Integer> usedPDiagonals = new HashSet<>();
    private final Set<Integer> usedNDiagonals = new HashSet<>();

    private final Set<int[]> usedPos = new HashSet<>();

    private int res = 0;

    private void recur_0(int row, int n) {
        if (row == n) {
            res++;
            return;
        }
        for (int col = 0; col < n; col++) {
            if (usedCols.contains(col) || usedPDiagonals.contains(row - col) || usedNDiagonals.contains(row + col))
                continue;

            int[] pos = new int[]{row, col};
            usedPos.add(pos);
            usedCols.add(col);
            usedPDiagonals.add(row - col);
            usedNDiagonals.add(row + col);
            recur_0(row + 1, n);
            usedPos.remove(pos);
            usedCols.remove(col);
            usedPDiagonals.remove(row - col);
            usedNDiagonals.remove(row + col);
        }
    }


    public int Nqueen_0(int n) {
        // write code here

        recur_0(0, n);

        return res;
    }


    private int ans = 0;

    private void recur(int row, int invalidCol, int invalidPD, int invalidND, int n) {
        if (row == n) {
            ans++;
            return;
        }
        int validCol = ~(invalidCol | invalidPD | invalidND) & ((1 << n) - 1);
        while (validCol > 0) {
            //            找到最低位的1
            int cur = validCol & (-validCol);
            recur(row + 1, invalidCol | cur, (invalidPD | cur) >> 1, (invalidND | cur) << 1, n);
            //            去除最低位的1
            validCol &= validCol - 1;
        }
    }


    public int Nqueen(int n) {
        // write code here
        recur(0, 0, 0, 0, n);
        return ans;
    }
}
