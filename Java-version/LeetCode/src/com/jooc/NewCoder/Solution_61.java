package com.jooc.NewCoder;

import com.jooc.Solution;

public class Solution_61 implements Solution {
    @Override
    public void main() {

    }

    private static final int[][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    private boolean[][] visited;
    private int res = 0;

    private void recur(int[][] matrix, int x, int y, int count) {
        int nRows = matrix.length, nCols = matrix[0].length;

        boolean flag = false;
        for (int[] direction : directions) {
            int nx = x + direction[0], ny = y + direction[1];
            if (0 <= nx && nx < nRows && 0 <= ny && ny < nCols && !visited[nx][ny]) {
                if (matrix[nx][ny] > matrix[x][y]) {
                    flag = true;
                    visited[nx][ny] = true;
                    recur(matrix, nx, ny, count + 1);
                    visited[nx][ny] = false;
                }
            }
        }
        if (!flag) {
            res = Math.max(res, count);
        }
    }

    public int solve(int[][] matrix) {
        // write code here
        int nRows = matrix.length, nCols = matrix[0].length;
        visited = new boolean[nRows][nCols];

        for (int i = 0; i < nRows; i++) {
            for (int j = 0; j < nCols; j++) {
                recur(matrix, i, j, 1);
            }
        }
        return res;
    }
}
