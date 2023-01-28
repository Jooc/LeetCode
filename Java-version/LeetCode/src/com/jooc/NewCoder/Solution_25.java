package com.jooc.NewCoder;

import com.jooc.Solution;
import com.jooc.components.TreeNode;
import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Solution_25 implements Solution {
    @Override
    public void main() {
        TreeNode root = TreeNode.generateByLeverOrder("[1,#,2,3]");
        root.PrintInLayerOrder();

        System.out.println(Arrays.toString(postorderTraversal(root)));
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param root TreeNode类
     * @return int整型一维数组
     */
    public int[] postorderTraversal_0 (TreeNode root) {
        // write code here

        List<Integer> list = new ArrayList<>();
        reverse(root, list);

        int[] res = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            res[i] = list.get(i);
        }

        return res;
    }

    private void reverse(TreeNode root, List<Integer> list){
        if (root == null)
            return;

        reverse(root.left, list);
        reverse(root.right, list);
        list.add(root.val);
    }

    public int[] postorderTraversal (TreeNode root) {
        // write code here
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        TreeNode pre = null;

        if (root == null)
            return new int[0];

        while(!stack.isEmpty() || root != null){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            TreeNode node = stack.pop();
            if(node.right == null || pre == node.right){
                list.add(node.val);
                pre = node;
            }else{
                stack.push(node);
                root = node.right;
            }
        }

        int[] res = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            res[i] = list.get(i);
        }
        return res;
    }

}
