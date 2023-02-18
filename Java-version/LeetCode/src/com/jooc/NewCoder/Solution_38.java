package com.jooc.NewCoder;

import com.jooc.Solution;
import com.jooc.components.TreeNode;

import java.util.*;

public class Solution_38 implements Solution {
    @Override
    public void main() {
        System.out.println(lowestCommonAncestor(TreeNode.generateByLeverOrder("{3,5,1,6,2,0,8,#,#,7,4}"), 5, 1));
    }

    private boolean flag = false;
    private void getPath(TreeNode root, int target, List<Integer> path) {
        if (flag || root == null) return;

        path.add(root.val);
        if (root.val == target) {
            flag = true;
            return;
        }
        getPath(root.left, target, path);
        getPath(root.right, target, path);

        if (flag)
            return;

        path.remove(path.size() - 1);
    }

    public int lowestCommonAncestor_0(TreeNode root, int o1, int o2) {
        // write code here

        List<Integer> path1 = new ArrayList<>();
        List<Integer> path2 = new ArrayList<>();

        getPath(root, o1, path1);
        flag = false;
        getPath(root, o2, path2);

        int res = 0;
        for (int i = 0; i < Math.min(path1.size(), path2.size()); i++) {
            int val1 = path1.get(i);
            int val2 = path2.get(i);
            if (val1 == val2) {
                res = val1;
            } else
                break;
        }
        return res;
    }


//    Maintain a Hashmap of each nodes' parent node.
    public int lowestCommonAncestor_1(TreeNode root, int o1, int o2) {
        // write code here

//        Cycle-assistant
        Queue<TreeNode> queue = new LinkedList<>();
        HashMap<Integer, Integer> parent = new HashMap<>();
        parent.put(root.val, Integer.MIN_VALUE);
        queue.offer(root);

        while(!(parent.containsKey(o1) && parent.containsKey(o2))){
            TreeNode node = queue.poll();
            assert node != null;

            if(node.left != null){
                parent.put(node.left.val, node.val);
                queue.offer(node.left);
            }

            if(node.right != null){
                parent.put(node.right.val, node.val);
                queue.offer(node.right);
            }
        }

        HashSet<Integer> ancestors = new HashSet<>();
        while(parent.containsKey(o1)){
            ancestors.add(o1);
            o1 = parent.get(o1);
        }

        while(!ancestors.contains(o2))
            o2 = parent.get(o2);

        return o2;
    }

    //    Maintain a Hashmap of each nodes' parent node.
    public int lowestCommonAncestor(TreeNode root, int o1, int o2) {
        return helper(root, o1, o2).val;
    }

    private TreeNode helper(TreeNode root, int o1, int o2){
        if(root == null || root.val == o1 || root.val == o2)
            return root;
        TreeNode left = helper(root.left, o1, o2);
        TreeNode right = helper(root.right, o1, o2);

        if(left == null)
            return right;
        if(right == null)
            return left;

        return root;
    }

}