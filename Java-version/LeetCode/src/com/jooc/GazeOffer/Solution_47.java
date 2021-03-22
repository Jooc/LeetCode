package com.jooc.GazeOffer;

public class Solution_47 implements Solution {

    @Override
    public void main() {
        System.out.println(maxValue(new int[][]{{0}}));
    }

    public int maxValue_0(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int dp[][] = new int[rows+1][cols+1];
        dp[1][1] = grid[0][0];

        for(int i = 1; i <= rows; i++){
            for(int j = 1; j <= cols; j++){
                dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]) + grid[i-1][j-1];
            }
        }

        return dp[rows][cols];
    }

    public int maxValue(int[][] grid){
        int rows = grid.length;
        int cols = grid[0].length;

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(i == 0 && j == 0) continue;
                if(i == 0) grid[i][j] = grid[i][j-1] + grid[i][j];
                else if(j == 0) grid[i][j] = grid[i-1][j] + grid[i][j];
                else grid[i][j] = Math.max(grid[i-1][j], grid[i][j-1]) + grid[i][j];
            }
        }
        return grid[rows-1][cols-1];
    }
}
