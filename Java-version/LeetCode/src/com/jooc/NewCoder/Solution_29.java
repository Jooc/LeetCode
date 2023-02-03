package com.jooc.NewCoder;

import com.jooc.Solution;
import com.jooc.components.TreeNode;

import java.util.Stack;

public class Solution_29 implements Solution {
    @Override
    public void main() {
        TreeNode root = TreeNode.generateByLeverOrder("{5,4,8,1,11,#,9,#,#,2,7}");
        System.out.println(hasPathSum(root, 22));
    }

    public boolean hasPathSum_0 (TreeNode root, int sum) {
        // write code here
        if(root == null)
            return false;

        if (root.left == null && root.right == null && root.val == sum)
            return true;

        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }

    public boolean hasPathSum (TreeNode root, int sum) {
        if (root == null)
            return false;

        // write code here
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        stack1.push(root);
        stack2.push(0);

        while(!stack1.isEmpty()){
            TreeNode node = stack1.pop();
            int val = stack2.pop() + node.val;

            if(node.left == null && node.right == null && val == sum) return true;

            if(node.left != null) {
                stack1.push(node.left);
                stack2.push(val);
            }
            if(node.right != null){
                stack1.push(node.right);
                stack2.push(val);
            }
        }
        return false;
    }


}
