package com.jooc.NewCoder;

import com.jooc.Solution;
import com.jooc.components.TreeNode;

import java.util.*;

public class Solution_27 implements Solution {
    @Override
    public void main() {

    }

    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(pRoot);
        int level = 1;

        while(!queue.isEmpty()){
            int n = queue.size();
            ArrayList<Integer> temp = new ArrayList<>();
            for(int i = 0; i < n; i++) {
                TreeNode node = queue.poll();
                temp.add(node.val);
                if(node.left != null)
                    queue.offer(node.left);
                if(node.right != null)
                    queue.offer(node.right);
            }
            if(level++ % 2 != 0){
                Collections.reverse(temp);
                res.add(temp);
            } else
                res.add(temp);
        }
        return res;
    }
}
