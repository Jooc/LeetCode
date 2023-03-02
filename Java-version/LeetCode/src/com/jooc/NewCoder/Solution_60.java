package com.jooc.NewCoder;

import com.jooc.Solution;

import java.util.ArrayList;

public class Solution_60 implements Solution {
    @Override
    public void main() {
        System.out.println(generateParenthesis(2).toString());
    }

    private ArrayList<String> res = new ArrayList<>();

    private void recur_0(int leftCount, int rightCount, int n, StringBuilder permBuilder) {
        if (leftCount == n && rightCount == n) {
            res.add(permBuilder.toString());
            return;
        }
        if (leftCount < n) {
            permBuilder.append('(');
            recur_0(leftCount + 1, rightCount, n, permBuilder);
            permBuilder.deleteCharAt(permBuilder.length() - 1);
        }

        if (rightCount < leftCount) {
            permBuilder.append(')');
            recur_0(leftCount, rightCount + 1, n, permBuilder);
            permBuilder.deleteCharAt(permBuilder.length() - 1);
        }
    }


    public ArrayList<String> generateParenthesis_0(int n) {
        // write code here
        StringBuilder permBuilder = new StringBuilder();
        recur_0(0, 0, n, permBuilder);
        return res;
    }

    private void recur(int leftCount, int rightCount, int n, String temp) {
        if (leftCount == n && rightCount == n) {
            res.add(temp);
            return;
        }
        if (leftCount < n)
            recur(leftCount + 1, rightCount, n, temp + "(");
        if (rightCount < leftCount)
            recur(leftCount, rightCount + 1, n, temp + ")");
    }


    public ArrayList<String> generateParenthesis(int n) {
        // write code here
        StringBuilder permBuilder = new StringBuilder();
        recur(0, 0, n, "");
        return res;
    }
}
