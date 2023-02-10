package com.jooc.NewCoder;

import com.jooc.Main;
import com.jooc.Solution;
import com.jooc.components.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Solution_35 implements Solution {
    @Override
    public void main() {
        System.out.println(isCompleteTree(TreeNode.generateByLeverOrder("{1}")));
    }

    public boolean isCompleteTree (TreeNode root) {
        // write code here
        if (root == null)
            return true;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        boolean metLeaf = false;

        while(!queue.isEmpty()){
            root = queue.poll();
            if(root == null){
                metLeaf = true;
                continue;
            }

            if(metLeaf)
                return false;

            queue.offer(root.left);
            queue.offer(root.right);
        }
        return true;
    }

}
