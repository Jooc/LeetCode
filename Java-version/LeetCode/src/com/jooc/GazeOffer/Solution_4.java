package com.jooc.GazeOffer;

import com.jooc.Solution;

public class Solution_4 implements Solution {
    @Override
    public void main() {
        int[][] target = {{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}};
//        int[][] target = {{-5}};

        Solution_SnakeCrawl solution = new Solution_SnakeCrawl();
        System.out.println(solution.searchMatrix(target, 9));
    }
    /**
     * Half BinarySearch
     * Time = O(mlogn)
     * Space = O(1)
     */
    class Solution_HalfBinarySearch {
        public boolean searchMatrix(int[][] matrix, int target) {
            int m = matrix.length, n = matrix[0].length;
            for (int[] row : matrix) {
                if (row[0] > target || row[n - 1] < target) continue;

                int low = 0, high = n - 1;
                while (low <= high) {
                    int mid = (low + high) / 2;
                    if (target == row[mid])
                        return true;
                    else if (target < row[mid]) {
                        high = mid - 1;
                    } else if (target > row[mid]) {
                        low = mid + 1;
                    }
                }
            }
            return false;
        }
    }

    /**
     * Complete BinarySearch
     * Time = O(lg(n!))
     * [assume n == m]
     * [Time/perLoop = lg(n-i)]
     * [S_Time = lg(n) + lg(n-1) + lg(n-2) + ..... + lg(1) = lg(n!)]
     * Space = O(1)
     */
    class Solution_CompleteBinarySearch {
        private boolean binarySearch(int[][] matrix, int target, int start, boolean vertical) {

            int low = start, high = vertical ? matrix.length - 1 : matrix[0].length - 1;

            while (low <= high) {
                int mid = (low + high) / 2;
                if (vertical) {
                    if (matrix[mid][start] == target)
                        return true;
                    if (matrix[mid][start] < target)
                        low = mid + 1;
                    if (matrix[mid][start] > target)
                        high = mid - 1;
                } else {
                    if (matrix[start][mid] == target)
                        return true;
                    if (matrix[start][mid] < target)
                        low = mid + 1;
                    if (matrix[start][mid] > target)
                        high = mid - 1;
                }
            }
            return false;
        }

        public boolean searchMatrix_CompleteBinarySearch(int[][] matrix, int target) {
            int dim = Math.min(matrix.length, matrix[0].length);

            for (int i = 0; i < dim; i++) {
                boolean verticalFound = binarySearch(matrix, target, i, true);
                boolean horizontalFound = binarySearch(matrix, target, i, false);

                if (verticalFound || horizontalFound) return true;
            }

            return false;
        }
    }

    /**
     * crawl from [m-1][0] to [0][n-1](not always end at [0][n-1])
     * Time = O(n + m)
     * Space = O(1)
     */
    class Solution_SnakeCrawl {
        public boolean searchMatrix(int[][] matrix, int target) {
            int m = matrix.length, n = matrix[0].length;
            int row = m - 1, col = 0;

            while (row < m && col < n && row >= 0 && col >= 0) {
                if (matrix[row][col] == target)
                    return true;
                else if (matrix[row][col] < target)
                    col++;
                else if (matrix[row][col] > target)
                    row--;
            }
            return false;
        }
    }
}


