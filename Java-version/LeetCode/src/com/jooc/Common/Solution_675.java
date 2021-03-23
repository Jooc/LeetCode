package com.jooc.Common;

import com.jooc.Solution;

import java.util.*;



public class Solution_675 implements Solution {
    @Override
    public void main() {

        List<List<Integer>> target = new ArrayList<>();
        target.add(Arrays.asList(1,2,3));
        target.add(Arrays.asList(0,0,0));
        target.add(Arrays.asList(7,6,5));

        System.out.println(cutOffTree(target));
    }

    public int cutOffTree(List<List<Integer>> forest) {
        int rows = forest.size();
        int cols = forest.get(0).size();

        List<int[]> trees = new ArrayList<>();
        for(int row = 0; row < rows; row++){
            for(int col = 0; col < cols; col++){
                int height = forest.get(row).get(col);
                if(height > 1) trees.add(new int[]{height, row, col});
            }
        }
        Collections.sort(trees, (a, b) -> Integer.compare(a[0], b[0]));

        int res = 0;
        int x = 0, y = 0;

        for(int[] tree: trees){
            int step = distance(forest, x, y, tree[1], tree[2]);
            if(step == -1) return -1;
            res += step;
            x = tree[1]; y = tree[2];
        }

        return res;
    }

    int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public int distance(List<List<Integer>> forest, int x, int y, int targetX, int targetY){
        int rows = forest.size(); int cols = forest.get(0).size();
        boolean[][] visited = new boolean[rows][cols];

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y, 0});
        visited[x][y] = true;

        while(!queue.isEmpty()){
            int[] currentPos = queue.poll();
            if(currentPos[0] == targetX && currentPos[1] == targetY) return currentPos[2];

            for(int[] direction: directions){
                int newX = currentPos[0] + direction[0], newY = currentPos[1] + direction[1];
                if(newX >= 0 && newX < rows && newY >= 0 && newY < cols && !visited[newX][newY] && forest.get(newX).get(newY) > 1){
                    visited[newX][newY] = true;
                    queue.add(new int[]{newX, newY, currentPos[2]+1});
                }
            }
        }

        return -1;
    }



}
