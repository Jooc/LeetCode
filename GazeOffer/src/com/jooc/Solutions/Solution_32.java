package com.jooc.Solutions;

import com.jooc.components.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution_32 {

    /**
     * 32 -  1⃣
     * @param root
     * @return
     */
//    public int[] levelOrder(TreeNode root) {
//        Queue<TreeNode> queue = new LinkedList<>();
//        ArrayList<Integer> res = new ArrayList<>();
//
//        queue.offer(root);
//        while(!queue.isEmpty()){
//            TreeNode current = queue.poll();
//            res.add(current.val);
//            if(current.left != null) queue.offer(current.left);
//            if(current.right != null) queue.offer(current.right);
//        }
//
//        int[] ans = new int[res.size()];
//        for(int i = 0; i < res.size(); i++){
//            ans[i] = res.get(i);
//        }
//
//        return ans;
//    }

    /**
     * 32 -  2⃣
     * @param root
     * @return
     */
//    public List<List<Integer>> levelOrder(TreeNode root) {
//        Queue<TreeNode> queue = new LinkedList<>();
//        List<List<Integer>> res = new ArrayList<>();
//
//        if(root!=null) queue.offer(root);
//        while(!queue.isEmpty()){
//            int leverSize = queue.size();
//            List<Integer> lever = new ArrayList<>();
//            for(int i = 0; i < leverSize; i++){
//                TreeNode current = queue.poll();
//                lever.add(current.val);
//                if(current.left != null) queue.offer(current.left);
//                if(current.right != null) queue.offer(current.right);
//            }
//            res.add(lever);
//        }
//
//        return res;
//    }

    /**
     * 32 -  3⃣
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();

        if(root!=null) queue.offer(root);
        while(!queue.isEmpty()){
            LinkedList<Integer> lever = new LinkedList<>();
            for(int i = queue.size(); i > 0; i--){
                TreeNode current = queue.poll();
                if(res.size() % 2 == 0){
                    lever.addLast(current.val);
                }else{
                    lever.addFirst(current.val);
                }

                if(current.left != null) queue.offer(current.left);
                if(current.right != null) queue.offer(current.right);
            }
            res.add(lever);
        }

        return res;
    }

}
