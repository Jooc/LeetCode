package com.jooc.Common;

import com.jooc.Solution;


public class Solution_59 implements Solution {
    @Override
    public void main() {

    }

    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int num = 1;

        int[] leftTop = new int[]{0, 0};
        int[] rightBottom = new int[]{n - 1, n - 1};

        while (num <= n * n) {
            for (int j = leftTop[1]; j <= rightBottom[1]; j++) res[leftTop[0]][j] = num++;
            leftTop[0]++;
            for (int i = leftTop[0]; i <= rightBottom[0]; i++) res[i][rightBottom[1]] = num++;
            rightBottom[1]--;
            for (int j = rightBottom[1]; j >= leftTop[1]; j--) res[rightBottom[0]][j] = num++;
            rightBottom[0]--;
            for (int i = rightBottom[0]; i >= leftTop[0]; i--) res[i][leftTop[1]] = num++;
            leftTop[1]++;
        }
        return res;
    }
}
