package com.jooc;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_6366 implements Solution {
    @Override
    public void main() {
        System.out.println(minimumTime(new int[][]{{0, 1, 3, 2}, {5, 1, 2, 5}, {4, 3, 8, 6}}));
    }

    private static final int[][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int minimumTime_0(int[][] grid) {
        int nRows = grid.length, nCols = grid[0].length;
        boolean[][] visited = new boolean[nRows][nCols];

        for (int i = 0; i < nRows; i++) {
            for (int j = 0; j < nCols; j++) {
                visited[i][j] = false;
            }
        }

        int row = 0, col = 0;
        int time = 0;

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{row, col});
        while (!queue.isEmpty()) {
            time++;
            for (int i = 0; i < queue.size(); i++) {
                int[] cor = queue.poll();
                row = cor[0];
                col = cor[1];
                visited[row][col] = true;
                if (row == nRows - 1 && col == nCols - 1) return time;

                for (int[] direction : directions) {
                    int nextRow = row + direction[0], nextCol = col + direction[1];
                    if (nextRow >= 0 && nextRow <= nRows - 1 &&
                            nextCol >= 0 && nextCol <= nCols - 1 &&
                            !visited[nextRow][nextCol] &&
                            time >= grid[nextRow][nextCol])
                        queue.offer(new int[]{nextRow, nextCol});
                }
            }
//            time--;
        }
        return -1;
    }

    public int minimumTime(int[][] grid) {
        if (grid[0][1] > 1 && grid[1][0] > 1) return -1;

        int nRows = grid.length, nCols = grid[0].length;
        int[][] visited = new int[nRows][nCols];

        


    }

}

