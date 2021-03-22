package com.jooc.GazeOffer;

import java.util.ArrayList;
import java.util.List;

public class Solution_1 implements Solution {
    @Override
    public void main() {
        System.out.println(generate(6).toString());


//        System.out.println(canWinNim(1348820612));


//        Integer[][] arr = new Integer[3][3];
//        arr[0][0] = 1; arr[0][1] = 2; arr[0][2] = 3;
//        arr[1][0] = 0; arr[1][1] = 0; arr[1][2] = 4;
//        arr[2][0] = 7; arr[2][1] = 6; arr[2][2] = 5;
//
//        List<List<Integer>> list = new ArrayList<List<Integer>>();
//        for(int i = 0;i < 3;i++){
//            list.add((List<Integer>) Arrays.asList(arr[i]));
//        }
//
//        System.out.println(cutOffTree(list));

    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();

        List<Integer> current = new ArrayList<>();
        current.add(1);
        res.add(current);
        List<Integer> pre = current;

        for (int i = 0; i < numRows - 1; i++) {
            current = new ArrayList<>();
            current.add(1);
            for(int j = 1; j <= i; j++){
                current.add(pre.get(j/2) + pre.get(j/2));
            }
            current.add(1);
            res.add(current);
            pre = current;
        }

        return res;
    }

    public boolean canWinNim(int n) {
//        boolean[] store = new boolean[ n > 4 ? n + 1 : 5];
//        store[1] = true;
//        store[2] = true;
//        store[3] = true;
//        store[4] = false;
//
//        for (int i = 5; i <= n; i++) {
//            store[i] = !(store[i - 1] && store[i - 2] && store[i - 3]);
//        }
//
//        return store[n];

        return !(n % 4 == 0);
    }

    int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    public int cutOffTree(List<List<Integer>> forest) {
        int x = 0, y = 0;
        int step = bfs(forest, x, y, 0);

        if(step != -1) {
            for (int i = 0; i < forest.size(); i++) {
                for (int j = 0; j < forest.get(i).size(); j++) {
                    if (forest.get(i).get(j) > 1) return -1;
                }
            }
            return step - 1;
        }
        return -1;
    }

    int bfs(List<List<Integer>> forest, int x, int y, int step){
//        if(x < 0 || y < 0 || x >= forest.size() || y >= forest.get(0).size()) return ;

        // 砍当前高度
        int currentHeight = forest.get(x).get(y);
        forest.get(x).set(y, 1);
        step++;

        // 选一个最矮的，贪心砍
        int minHeight = Integer.MAX_VALUE;
        int nextX = -1, nextY = -1;
        for(int i = 0; i < 4; i++){
            int newX = directions[i][0] + x;
            int newY = directions[i][1] + y;

            if(newX >= 0 && newX < forest.size() && newY >= 0 && newY < forest.get(0).size()){
                int newHeight = forest.get(newX).get(newY);
                if(newHeight > 1 && newHeight < minHeight){
                    minHeight = forest.get(newX).get(newY);
                    nextX = newX; nextY = newY;
                }
            }
        }

        if(minHeight == Integer.MAX_VALUE) return step;
        else if(minHeight < currentHeight) return -1;

        return bfs(forest, nextX, nextY, step);
    }
}