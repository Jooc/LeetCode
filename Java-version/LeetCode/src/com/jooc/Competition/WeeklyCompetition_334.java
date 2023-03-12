package com.jooc.Competition;

import com.jooc.Solution;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class WeeklyCompetition_334 implements Solution {
    @Override
    public void main() {
        System.out.println(1e5);
        System.out.println(maxNumOfMarkedIndices(new int[]{57, 40, 57, 51, 90, 51, 68, 100, 24, 39, 11, 85, 2, 22, 67, 29, 74, 82, 10, 96, 14, 35, 25, 76, 26, 54, 29, 44, 63, 49, 73, 50, 95, 89, 43, 62, 24, 88, 88, 36, 6, 16, 14, 2, 42, 42, 60, 25, 4, 58, 23, 22, 27, 26, 3, 79, 64, 20, 92}));
        System.out.println(Arrays.toString(divisibilityArray("1010", 10)));

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


        return -1;
    }

    public int maxNumOfMarkedIndices(int[] nums) {
        if (nums.length <= 1) return 0;
        int ans = 0;

        Arrays.sort(nums);
        int left = 0, right = 1;
//        while (right <= nums.length && nums[right] < 2 * nums[left]) {
//            if (right == nums.length - 1) break;
//            right++;
//        }
        right = nums.length / 2;

        while (left < nums.length / 2 && right < nums.length) {
            if (2 * nums[left] <= nums[right]) {
                ans += 2;
                left++;
            }
            right++;
        }
        return ans;
    }

    public int[] divisibilityArray(String word, int m) {
        long left = 0;
        int[] ans = new int[word.length()];
        for (int i = 0; i < word.length(); i++) {
            left = left * 10 + Character.getNumericValue(word.charAt(i));
//            left = left % m;
            if (left % m == 0) {
                ans[i] = 1;
            }
            left = left % m;
//            if (sum % m == 0){
//                ans[i] = 1;
//                sum = 0;
//            }else{
//                ans[i] = 0;
//            }

        }
        return ans;
    }

    public int[] leftRigthDifference(int[] nums) {
        int leftSum = 0, rightSum = Arrays.stream(nums).sum() - nums[0];

        int n = nums.length;
        int[] ans = new int[n];

        for (int i = 0; i < n - 1; i++) {
            ans[i] = Math.abs(leftSum - rightSum);
            leftSum += nums[i];
            rightSum -= nums[i + 1];
        }
        ans[n - 1] = leftSum;
        return ans;
    }
}
