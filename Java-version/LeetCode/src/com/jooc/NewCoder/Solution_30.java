package com.jooc.NewCoder;

import com.jooc.Solution;
import com.jooc.components.TreeNode;

import java.util.Stack;

public class Solution_30 implements Solution {
    @Override
    public void main() {

    }

    TreeNode dummy_0 = new TreeNode(-1);
    TreeNode cur_0 = dummy_0;
    public TreeNode Convert_0(TreeNode pRootOfTree) {
        if(pRootOfTree==null) return null;
        Convert_0(pRootOfTree.left);

//        TreeNode node = new TreeNode(pRootOfTree.val);
        cur_0.right = pRootOfTree;
        pRootOfTree.left = cur_0;
        cur_0 = cur_0.right;

        Convert_0(pRootOfTree.right);

        if(this.dummy_0.right != null)
            dummy_0.right.left = null;

        return this.dummy_0.right;
    }


    public TreeNode Convert(TreeNode pRootOfTree) {
        if(pRootOfTree==null)
            return null;

        TreeNode dummy = new TreeNode(-1);
        TreeNode cur = dummy;

        Stack<TreeNode> stack = new Stack<>();

        while(pRootOfTree != null || !stack.isEmpty()){
            while(pRootOfTree != null) {
                stack.push(pRootOfTree);
                pRootOfTree = pRootOfTree.left;
            }

            pRootOfTree = stack.pop();
            cur.right = pRootOfTree;
            pRootOfTree.left = cur;
            cur = pRootOfTree;

            pRootOfTree = pRootOfTree.right;
        }

//        TreeNode node = new TreeNode(pRootOfTree.val);

        if(dummy.right != null)
            dummy.right.left = null;

        return dummy.right;
    }


}
