package com.jooc.GazeOffer;

import com.jooc.components.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;

public class Solution_36 {

    public void main(){
        TreeNode a = new TreeNode(4);
        a.left = new TreeNode(2);
        a.right = new TreeNode(5);
        a.left.left = new TreeNode(1);
        a.left.right = new TreeNode(3);

        treeToDoublyList(a);
    }

    public TreeNode treeToDoublyList_0(TreeNode root) {
        if(root == null) return null;

        ArrayList<Integer> inOrder = inOrder_0(root);

        TreeNode head = new TreeNode(inOrder.get(0));
        TreeNode current = head;

        for(int i = 1; i < inOrder.size(); i++){
            TreeNode temp = new TreeNode(inOrder.get(i));
            current.right = temp;
            temp.left = current;
            current = current.right;
        }
        head.left = current;
        current.right = head;

        return head;
    }

    public ArrayList<Integer> inOrder_0(TreeNode root){
        ArrayList<Integer> res = new ArrayList<>();

        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode current = root;
        while(!stack.isEmpty() || current != null){
            if(current != null){
                stack.push(current);
                current = current.left;
            }else{
                current = stack.pop();
                res.add(current.val);
                current = current.right;
            }
        }
        return res;
    }

    TreeNode pre, head;
    public TreeNode treeToDoublyList(TreeNode root) {
        if(root == null) return null;
        dfs(root);
        head.left = pre;
        pre.right = head;

        return head;
    }

    public void dfs(TreeNode current){
        if(current == null) return ;
        dfs(current.left);
        if(pre != null) {
            pre.right = current;
        }else{
            head = current;
        }
        current.left = pre;
        pre = current;
        dfs(current.right);
    }
}
