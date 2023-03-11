package com.jooc.NewCoder;

import com.jooc.Solution;

public class Solution_99 implements Solution {
    @Override
    public void main() {

    }

    public int[][] rotateMatrix(int[][] mat, int n) {
        // write code here

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = mat[i][j];
                mat[i][j] = mat[i][n - 1 - j];
                mat[i][n - 1 - j] = temp;
            }
        }

        return mat;
    }
}
