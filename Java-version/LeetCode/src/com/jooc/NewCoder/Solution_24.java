package com.jooc.NewCoder;

import com.jooc.Solution;
import com.jooc.components.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Solution_24 implements Solution {
    @Override
    public void main() {
        TreeNode root = TreeNode.generateByLeverOrder("[1,2,#,#,3]");
        root.PrintInLayerOrder();

        System.out.println(Arrays.toString(inorderTraversal(root)));
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param root TreeNode类
     * @return int整型一维数组
     */
    public int[] inorderTraversal_0 (TreeNode root) {
        // write code here
        List<Integer> temp = new ArrayList<>();
        reverse(root, temp);

        int[] res = new int[temp.size()];
        for(int i = 0; i < temp.size(); i++){
            res[i] = temp.get(i);
        }

        return res;
    }

    private void reverse(TreeNode root, List<Integer> temp){
        if (root==null)
            return;

        reverse(root.left, temp);
        temp.add(root.val);
        reverse(root.right, temp);
    }

    public int[] inorderTraversal (TreeNode root) {
        // write code here
        List<Integer> temp = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        if (root == null)
            return new int[0];

        while(!stack.isEmpty() || root != null){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            TreeNode node = stack.pop();
            temp.add(node.val);
            root = node.right;
        }

        int[] res = new int[temp.size()];
        for(int i = 0; i < temp.size(); i++){
            res[i] = temp.get(i);
        }

        return res;
    }

}
