package com.jooc.Common;

import com.jooc.Solution;
import com.jooc.components.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class Solution_133 implements Solution {
    @Override
    public void main() {

    }

    LinkedList<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> path = new LinkedList<>();

    private void recur(TreeNode root, int target){
        if(root == null) return;

        path.add(root.val);
        target -= root.val;
        if(target == 0 && root.left == null && root.right == null){
            res.add(new LinkedList<>(path));
        }
        recur(root.left, target);
        recur(root.right, target);
        path.removeLast();
    }

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        recur(root, target);
        return res;
    }


}
