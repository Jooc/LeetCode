package com.jooc.NewCoder;

import com.jooc.Solution;

public class Solution_18 implements Solution {
    @Override
    public void main() {
        System.out.println(Find(7, new int[][]{{1,2,8,9}, {2,4,9,12}, {4,7,10,13}, {6,8,11,15}}));
    }

    public boolean Find(int target, int [][] array) {
        int nRows = array.length;
        if (nRows == 0)
            return false;
        int nCols = array[0].length;
        if (nCols == 0)
            return false;

        int i = nRows-1, j = 0;
        while(i >= 0 && j < nCols){
            if (target == array[i][j])
                return true;
            else if (target < array[i][j])
                i--;
            else
                j++;
        }
        return false;
    }
}
