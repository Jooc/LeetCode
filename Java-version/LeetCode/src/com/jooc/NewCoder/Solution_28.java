package com.jooc.NewCoder;

import com.jooc.Solution;
import com.jooc.components.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Solution_28 implements Solution {
    @Override
    public void main() {
        TreeNode root = TreeNode.generateByLeverOrder("{1,2,3,4,#,#,5}");
        System.out.println(maxDepth(root));
    }

    /**
     *
     * @param root TreeNode类
     * @return int整型
     */
    public int maxDepth_0 (TreeNode root) {
        if (root == null) return 0;
        // write code here
        return Math.max(maxDepth_0(root.left), maxDepth_0(root.right)) + 1;
    }

    public int maxDepth (TreeNode root) {
        if(root == null) return 0;

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);

        int depth = 0;
        while(!queue.isEmpty()){
            int n = queue.size();
            for(int i = 0; i<n;i++){
                TreeNode node = queue.poll();
                assert node != null;
                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
            }
            depth++;
        }
        return depth;
    }
}
