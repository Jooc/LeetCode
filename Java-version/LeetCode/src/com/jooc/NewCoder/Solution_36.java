package com.jooc.NewCoder;

import com.jooc.Main;
import com.jooc.Solution;
import com.jooc.components.TreeNode;

public class Solution_36 implements Solution {
    @Override
    public void main() {
        System.out.println(IsBalanced_Solution(TreeNode.generateByLeverOrder("{1,2,3,4,5,#,6,#,#,7}")));
    }

    private boolean isBalanced = true;

    private int depth(TreeNode root) {
        if (root == null) return 0;

        int leftDepth = depth(root.left);
        if (leftDepth == -1) return -1;
        int rightDepth = depth(root.right);
        if (rightDepth == -1) return -1;

        if (Math.abs(leftDepth - rightDepth) > 1) {
            isBalanced = false;
            return -1;
        }

        return Math.max(leftDepth, rightDepth) + 1;
    }

    public boolean IsBalanced_Solution(TreeNode root) {
        depth(root);
        return isBalanced;
    }
}