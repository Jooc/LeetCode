package com.jooc.Solutions;

import com.jooc.components.TreeNode;

public class Solution_27 {

    public TreeNode mirrorTree(TreeNode root){
        if(root == null) return null;
        TreeNode temp = root.left;
        root.left = mirrorTree(root.right);
        root.right = mirrorTree(temp);

        return root;
    }

//    public TreeNode mirrorTree(TreeNode root) {
//        if(root == null) return null;
//
//        reverse(root);
//        if(root.left != null) reverse(root.left);
//        if(root.right != null) reverse(root.right);
//
//        return root;
//    }
//
//    public void reverse(TreeNode A){
//        TreeNode temp = A.left;
//        A.left = A.right;
//        A.right = temp;
//    }
}
