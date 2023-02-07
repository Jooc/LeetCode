package com.jooc.NewCoder;

import com.jooc.components.TreeNode;


public class Solution_31 {
    boolean recur(TreeNode left, TreeNode right){
        if (left == null && right == null)
            return true;
        if (left == null || right == null || left.val != right.val)
            return false;
        return recur(left.left, right.right) && recur(left.right, right.left);
    }

    boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot == null) return true;

        return recur(pRoot.left, pRoot.right);
    }
}