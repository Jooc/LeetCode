package com.jooc.Solutions;

import java.util.ArrayList;
import java.util.List;

class Solution_29 {

    int[][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int[] spiralOrder(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return new int[]{};
        }
        int rowSize = matrix.length, colSize = matrix[0].length;
        int directionIndex = 0;
        int sum = rowSize * colSize;
        boolean[][] visited = new boolean[rowSize][colSize];

        int[] res = new int[sum];
        int row = 0, col = 0;
        for(int i = 0; i < sum; i++){
            res[i] = matrix[row][col];
            visited[row][col] = true;

            int nextRow = row + directions[directionIndex][0], nextCol = col + directions[directionIndex][1];
            if(nextRow < 0 || nextRow >= rowSize || nextCol < 0 || nextCol >= colSize || visited[nextRow][nextCol]){
                directionIndex = (directionIndex + 1) % 4;
            }
            row = row + directions[directionIndex][0];
            col = col + directions[directionIndex][1];
        }

        return res;
    }
}
