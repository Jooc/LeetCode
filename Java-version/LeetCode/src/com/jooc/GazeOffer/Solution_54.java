package com.jooc.GazeOffer;

import com.jooc.components.TreeNode;

public class Solution_54 implements Solution {
    @Override
    public void main() {
        TreeNode a = new TreeNode(3);
        a.left = new TreeNode(1);
        a.left.right = new TreeNode(2);
        a.right = new TreeNode(4);

        System.out.println(kthLargest(a, 1));
    }

    int res, k;
    public int kthLargest(TreeNode root, int k) {
        res = 0; this.k = k;
        reverseInOrder(root);
        return res;
    }

    private void reverseInOrder(TreeNode root){
        if(root != null) {
            reverseInOrder(root.right);
            if(k == 0) return;
            if(--k == 0) res = root.val;
            reverseInOrder(root.left);
        }
    }
}
