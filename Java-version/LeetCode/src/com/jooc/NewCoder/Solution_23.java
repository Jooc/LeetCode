package com.jooc.NewCoder;

import com.jooc.Solution;
import com.jooc.components.TreeNode;
import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution_23 implements Solution {
    @Override
    public void main() {

    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param root TreeNode类
     * @return int整型一维数组
     */
    public int[] preorderTraversal_0 (TreeNode root) {
        // write code here
        List<Integer> temp = new ArrayList<>();
        reverse(root, temp);

        int[] res = new int[temp.size()];
        for (int i = 0; i < temp.size(); i++){
            res[i] = temp.get(i);
        }
        return res;
    }

    private void reverse(TreeNode root, List<Integer> memory){
        if (root == null) return;
        memory.add(root.val);
        reverse(root.left, memory);
        reverse(root.right, memory);
    }

    public int[] preorderTraversal (TreeNode root) {
        // write code here
        List<Integer> temp = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        if (root == null) return new int[0];
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            temp.add(node.val);
            if(node.right != null)
                stack.push(node.right);
            if (node.left != null)
                stack.push(node.left);
        }

        int[] res = new int[temp.size()];
        for (int i = 0; i < temp.size(); i++){
            res[i] = temp.get(i);
        }
        return res;
    }
}
