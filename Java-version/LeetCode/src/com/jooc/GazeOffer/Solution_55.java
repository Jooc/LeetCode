package com.jooc.GazeOffer;

import com.jooc.Solution;
import com.jooc.components.TreeNode;

import java.util.LinkedList;

public class Solution_55 implements Solution {
    @Override
    public void main() {
        TreeNode a = new TreeNode(1);
        a.left = new TreeNode(2);
        a.right = new TreeNode(3);
        a.left.left = new TreeNode(4);
        a.right.right = new TreeNode(5);

        System.out.println(maxDepth(a));
    }

    public int maxDepth(TreeNode root){
        if(root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    // non - recur
    public int maxDepth_0(TreeNode root) {
        if(root == null) return 0;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int depth = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                TreeNode node = queue.poll();
                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
            }
            depth++;
        }
        return depth;
    }

    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        return (Math.abs(depth(root.left) - depth(root.right)) <= 1) && isBalanced(root.left) && isBalanced(root.right);
    }

    private int depth(TreeNode root){
        if(root == null) return 0;
        return Math.max(depth(root.left),depth(root.right)) + 1;
    }

}
