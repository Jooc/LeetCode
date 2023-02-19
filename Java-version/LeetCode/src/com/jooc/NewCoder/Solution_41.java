package com.jooc.NewCoder;

import com.jooc.Solution;
import com.jooc.components.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution_41 implements Solution {
    @Override
    public void main() {

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

    public int[] solve(int[] xianxu, int[] zhongxu) {
        // write code here

        TreeNode root = build(xianxu, zhongxu, 0, xianxu.length - 1, 0, zhongxu.length - 1);

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        List<Integer> tailList = new ArrayList<>();

        while (!queue.isEmpty()) {
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                root = queue.poll();
                if (root.left != null) queue.offer(root.left);
                if (root.right != null) queue.offer(root.right);
            }
            tailList.add(root.val);
        }

        int[] res = new int[tailList.size()];
        for (int i = 0; i < tailList.size(); i++){
            res[i] = tailList.get(i);
        }
        return res;
    }

}