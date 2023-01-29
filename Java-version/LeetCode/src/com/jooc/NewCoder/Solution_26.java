package com.jooc.NewCoder;

import com.jooc.Solution;
import com.jooc.components.TreeNode;

import java.lang.reflect.Array;
import java.util.*;

public class Solution_26 implements Solution {
    @Override
    public void main() {
        TreeNode root = TreeNode.generateByLeverOrder("{3,9,20,#,#,15,7}");
        System.out.println(levelOrder(root));
    }

    public ArrayList<ArrayList<Integer>> levelOrder_0(TreeNode root) {
        // write code here
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        List<TreeNode> list = new ArrayList<>();
        list.add(root);
        while (!list.isEmpty()) {
            ArrayList<Integer> singleLine = new ArrayList<>();
            List<TreeNode> temp = new ArrayList<>();
            for (TreeNode node : list) {
                singleLine.add(node.val);
                if (node.left != null) {
                    temp.add(node.left);
                }
                if (node.right != null) {
                    temp.add(node.right);
                }
            }
            res.add(singleLine);
            list = temp;
        }

        return res;
    }

    public ArrayList<ArrayList<Integer>> levelOrder_1(TreeNode root) {
        // write code here
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            ArrayList<Integer> singleLine = new ArrayList<>();
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                TreeNode node = queue.poll();
                singleLine.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            res.add(singleLine);
        }

        return res;
    }


    ArrayList<ArrayList<Integer>> rRes = new ArrayList<>();

    private void traverse(TreeNode root, int depth) {
        if (root != null) {
            if (rRes.size() < depth) {
                ArrayList<Integer> row = new ArrayList<>();
                rRes.add(row);
                row.add(root.val);
            } else {
                ArrayList<Integer> row = rRes.get(depth - 1);
                row.add(root.val);
            }
        } else {
            return;
        }
        traverse(root.left, depth + 1);
        traverse(root.right, depth + 1);
    }

    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        // write code here
        if (root == null) {
            return rRes;
        }
        traverse(root, 1);
        return rRes;
    }
}
