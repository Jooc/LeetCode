package com.jooc.components;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {}
    public TreeNode(int x) {
        val = x;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public void PrintInLayerOrder(){
        List<Integer> list = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(this);

        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            list.add(node.val);
            if(node.left != null) queue.add(node.left);
            if(node.right != null) queue.add(node.right);
        }
        System.out.println(list.toString());
    }

    public TreeNode generateByLeverOrder(String data) {
        if(data.equals("[]")) return new TreeNode();

        String[] nums = data.substring(1, data.length()-1).split(",");
        LinkedList<TreeNode> queue = new LinkedList<>();
        TreeNode res = new TreeNode(Integer.valueOf(nums[0]));
        queue.add(res);

        int index = 1;
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();

            if(!nums[index].equals("null")){
                node.left = new TreeNode(Integer.valueOf(nums[index]));
                queue.add(node.left);
            }
            index++;
            if(!nums[index].equals("null")){
                node.right = new TreeNode(Integer.valueOf(nums[index]));
                queue.add(node.right);
            }
            index++;
        }

        return res;
    }

    public static TreeNode instance(){
        TreeNode a = new TreeNode(1);
        a.left = new TreeNode(2);
        a.right = new TreeNode(3);
        a.right.left = new TreeNode(4);
        a.right.right = new TreeNode(5);

        return a;
    }
}