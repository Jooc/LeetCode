package com.jooc.NewCoder;

import com.jooc.Solution;
import com.jooc.components.TreeNode;

public class Solution_40 implements Solution {
    @Override
    public void main() {
        reConstructBinaryTree(new int[]{1, 2, 4, 7, 3, 5, 6, 8}, new int[]{4, 7, 2, 1, 5, 3, 8, 6}).PrintInLayerOrder();
    }

    private TreeNode build(int[] pre, int[] vin, int l1, int r1, int l2, int r2) {
        if (r1 < l1 || r2 < l2)
            return null;
        if (l1 == r1 || l2 == r2)
            return new TreeNode(pre[l1]);

        int root_val = pre[l1];
        int inIndex = 0;
        for (int i = l2; i <= r2; i++) {
            if (vin[i] == root_val)
                inIndex = i;
        }

        TreeNode root = new TreeNode(root_val);
        int lSize = inIndex - l2;
        root.left = build(pre, vin, l1 + 1, lSize + l1, l2, inIndex - 1);
        root.right = build(pre, vin, l1 + lSize + 1, r1, inIndex + 1, r2);

        return root;
    }

    public TreeNode reConstructBinaryTree(int[] pre, int[] vin) {
        int n = pre.length;
        return build(pre, vin, 0, n - 1, 0, n - 1);
    }
}