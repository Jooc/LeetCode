package com.jooc.NewCoder;

import com.jooc.Solution;
import com.jooc.components.TreeNode;

import java.util.*;

public class Solution_39 implements Solution {
    @Override
    public void main() {
        Deserialize(Serialize(TreeNode.generateByLeverOrder("{}"))).PrintInLayerOrder();
    }

    String Serialize(TreeNode root) {
        if (root == null) return "";

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        StringBuilder builder = new StringBuilder("{");

        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            if (node != null) {
                builder.append(node.val);
                queue.add(node.left);
                queue.add(node.right);
            }
            else
                builder.append("#");
            builder.append(",");
        }

        builder.deleteCharAt(builder.length()-1);
        builder.append('}');

        return builder.toString();
    }


    TreeNode Deserialize(String str) {
        if (Objects.equals(str, "{}")) return null;

        String[] list = str.substring(1, str.length()-1).split(",");
        TreeNode head = new TreeNode(Integer.parseInt(list[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(head);

        int idx = 1;
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();

            node.left = build(list[idx++]);
            if (node.left != null) queue.offer(node.left);

            node.right = build(list[idx++]);
            if(node.right != null) queue.offer(node.right);
        }
        return head;
    }

    TreeNode build(String val){
        if (!Objects.equals(val, "#")){
            return new TreeNode(Integer.parseInt(val));
        }else{
            return null;
        }
    }
}