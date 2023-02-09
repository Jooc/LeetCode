package com.jooc.NewCoder;

import com.jooc.Solution;
import com.jooc.components.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution_34 implements Solution {
    @Override
    public void main() {
        System.out.println(isValidBST(TreeNode.generateByLeverOrder("{3,2,5}")));
    }

    public boolean isValidBST_0 (TreeNode root) {
        // write code here
        List<Integer> list = new ArrayList<>();
        inorder(root, list);

        if(list.size() <= 1) return true;
        for(int i = 1; i < list.size(); i++){
            if (list.get(i) < list.get(i-1))
                return false;
        }
        return true;
    }

    private void inorder(TreeNode root, List<Integer> list){
        if(root == null)
            return;

        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }


    private int pre = Integer.MIN_VALUE;
    public boolean isValidBST_1(TreeNode root) {
        // write code here
        if (root == null) return true;

        if (!isValidBST_1(root.left)) return false;
        if (root.val < pre) return false;
        pre = root.val;

        return isValidBST_1(root.right);
    }

    public boolean isValidBST (TreeNode root) {
        // write code here
        Stack<TreeNode> stack = new Stack<>();
        int pre = Integer.MIN_VALUE;

        while(root != null || !stack.isEmpty()){
            while(root != null){
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();
            System.out.println(root.val);
            if (root.val < pre) return false;
            pre = root.val;

            root = root.right;
        }

        return true;
    }

}
