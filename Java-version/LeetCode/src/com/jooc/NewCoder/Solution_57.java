package com.jooc.NewCoder;

import com.jooc.Solution;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_57 implements Solution {
    @Override
    public void main() {
        System.out.println(solve(new char[][]{
                {'1', '1', '0', '0', '0'},
                {'0', '1', '0', '1', '1'},
                {'0', '0', '0', '1', '1'},
                {'0', '0', '0', '0', '0'},
                {'0', '0', '1', '1', '1'}
        }));
    }

    int[][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    boolean[][] visited;

    public int solve_0(char[][] grid) {
        System.out.println(Arrays.deepToString(grid));
        // write code here
        int res = 0;
        int nRows = grid.length, nCols = grid[0].length;
        visited = new boolean[nRows][nCols];

        for (int i = 0; i < nRows; i++) {
            for (int j = 0; j < nCols; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    Queue<int[]> queue = new LinkedList<>();
                    queue.offer(new int[]{i, j});

                    while (!queue.isEmpty()) {
                        int[] tmp = queue.poll();
                        int x = tmp[0], y = tmp[1];
                        for (int[] direction : directions) {
                            int nx = x + direction[0], ny = y + direction[1];
                            if (nx >= 0 && nx < nRows && ny >= 0 && ny < nCols && !visited[nx][ny] && grid[nx][ny] == '1') {
                                queue.offer(new int[]{nx, ny});
                                visited[nx][ny] = true;
                            }
                        }
                    }
                    res++;
                }
            }
        }
        return res;
    }

    private void dfs(char[][] grid, int i, int j) {
        int nRows = grid.length, nCols = grid[0].length;
        grid[i][j] = '0';
        for (int[] direction : directions) {
            int nx = i + direction[0], ny = j + direction[1];
            if (nx >= 0 && nx < nRows && ny >= 0 && ny < nCols && grid[nx][ny] == '1') {
                grid[nx][ny] = '1';
                dfs(grid, nx, ny);
            }
        }
    }

    public int solve(char[][] grid) {
        int res = 0;

        int nRows = grid.length, nCols = grid[0].length;
        for (int i = 0; i < nRows; i++) {
            for (int j = 0; j < nCols; j++) {
                if (grid[i][j] == '1') {
                    res++;
                    dfs(grid, i, j);
                }
            }
        }

        return res;
    }
}
