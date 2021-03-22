package com.jooc.GazeOffer;

import com.jooc.components.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution_34 {

    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum){
        preOrder(root, sum);
        return res;
    }

    public void preOrder(TreeNode root, int sum){
        if(root == null) return;

        path.add(root.val);
        sum -= root.val;
        if(sum == 0 && root.left == null && root.right == null)
            res.add(new ArrayList<>(path));
        preOrder(root.left, sum);
        preOrder(root.right, sum);

        path.removeLast();
    }

}
