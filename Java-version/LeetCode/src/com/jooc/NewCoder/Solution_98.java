package com.jooc.NewCoder;

import com.jooc.Solution;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution_98 implements Solution {
    @Override
    public void main() {
        System.out.println(spiralOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}));
    }

    private static final int[][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public ArrayList<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> res = new ArrayList<>();
        int m = matrix.length;
        if (m == 0) return res;
        int n = matrix[0].length;
        if (n == 0) return res;

        boolean[][] visited = new boolean[m][n];
        int x = 0, y = 0;
        int directionIndex = 0;


        res.add(matrix[x][y]);
        visited[x][y] = true;

        while (res.size() < m * n) {
            System.out.println(res);
            int[] direction = directions[directionIndex];
            int nx = x + direction[0], ny = y + direction[1];

            if (nx < 0 || nx > m - 1 || ny < 0 || ny > n - 1 || visited[nx][ny]) {
                directionIndex = (directionIndex + 1) % 4;
            } else {
                x = nx;
                y = ny;
                res.add(matrix[x][y]);
                visited[x][y] = true;
            }
        }
        return res;
    }
}
