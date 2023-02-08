package com.jooc.NewCoder;

import com.jooc.Solution;
import com.jooc.components.TreeNode;

import java.util.Stack;

public class Solution_33 implements Solution {
    @Override
    public void main() {
        Mirror_0(TreeNode.generateByLeverOrder("{8,6,10,5,7,9,11}")).PrintInLayerOrder();

    }

    public TreeNode Mirror_0(TreeNode pRoot) {
        // write code here
        if (pRoot == null)
            return null;

        TreeNode temp = pRoot.left;
        pRoot.left = Mirror_0(pRoot.right);
        pRoot.right = Mirror_0(temp);

        return pRoot;
    }

    public TreeNode Mirror(TreeNode pRoot){
        if (pRoot == null)
            return null;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(pRoot);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            if(node.left != null)
                stack.push(node.left);
            if(node.right != null)
                stack.push(node.right);

            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;
        }
        return pRoot;
    }
}
