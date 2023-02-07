package com.jooc.NewCoder;

import com.jooc.Solution;
import com.jooc.components.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Solution_32 implements Solution {
    @Override
    public void main() {
        mergeTrees(TreeNode.generateByLeverOrder("{1,3,2,5}"), TreeNode.generateByLeverOrder("{2,1,3,#,4,#,7}")).PrintInLayerOrder();
    }

    public TreeNode mergeTrees_0(TreeNode t1, TreeNode t2) {
        // write code here
        if (t1 == null) return t2;
        if (t2 == null) return t1;

        TreeNode node = new TreeNode(t1.val + t2.val);
        node.left = mergeTrees_0(t1.left, t2.left);
        node.right = mergeTrees_0(t1.right, t2.right);

        return node;
    }

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null) return t2;
        if (t2 == null) return t1;

        TreeNode head = new TreeNode(t1.val + t2.val);
        Queue<TreeNode> q = new LinkedList<>(), q1 = new LinkedList<>(), q2 = new LinkedList<>();
        q.offer(head);
        q1.offer(t1);
        q2.offer(t2);

        while (!q1.isEmpty() && !q2.isEmpty()) {
            TreeNode node = q.poll();
            TreeNode node1 = q1.poll();
            TreeNode node2 = q2.poll();

            TreeNode left1 = node1.left;
            TreeNode left2 = node2.left;
            TreeNode right1 = node1.right;
            TreeNode right2 = node2.right;

            if (left1 != null || left2 != null) {
                if (left1 != null && left2 != null) {
                    TreeNode left = new TreeNode(left1.val + left2.val);
                    node.left = left;

                    q.offer(left);
                    q1.offer(left1);
                    q1.offer(left2);
                } else if (left1 != null) {
                    node.left = left1;
                }else{
                    node.left = left2;
                }
            }
            if (right1 != null || right2 != null) {
                if (right1 != null && right2 != null) {
                    TreeNode right = new TreeNode(right1.val + right2.val);
                    node.right = right;

                    q.offer(right);
                    q1.offer(right1);
                    q1.offer(right2);
                } else if (right1 != null) {
                    node.right = right1;
                }else{
                    node.right = right2;
                }
            }
        }
        return head;
    }


}
