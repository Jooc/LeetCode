package com.jooc.Common;

import com.jooc.Solution;

import java.util.ArrayList;
import java.util.List;

public class Solution_54 implements Solution {
    @Override
    public void main() {
//        System.out.println(spiralOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}));
//        System.out.println(spiralOrder(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}}));
        System.out.println(spiralOrder(new int[][]{{6,9,7}}));
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        List<Integer> res = new ArrayList<>();

        int[] leftTop = new int[]{0, 0};
        int[] rightBottom = new int[]{m-1, n-1};

        int size = m * n;
        while(res.size() < size){
            for(int j = leftTop[1]; j <= rightBottom[1]; j++) res.add(matrix[leftTop[0]][j]);
            leftTop[0]++;
            for(int i = leftTop[0]; i <= rightBottom[0]; i++) res.add(matrix[i][rightBottom[1]]);
            rightBottom[1]--;
            for(int j = rightBottom[1]; j >= leftTop[1]; j--) res.add(matrix[rightBottom[0]][j]);
            rightBottom[0]--;
            for(int i = rightBottom[0]; i >= leftTop[0]; i--) res.add(matrix[i][leftTop[1]]);
            leftTop[1]++;
        }
        while(res.size() > size){
            res.remove(res.size()-1);
        }

        return res;
    }

}
