package com.jooc.NewCoder;

import com.jooc.Solution;
import com.jooc.components.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution_37 implements Solution {
    @Override
    public void main() {
        System.out.println(lowestCommonAncestor(TreeNode.generateByLeverOrder("{7,1,12,0,4,11,14,#,#,3,5}"), 12, 11));
    }

    private List<Integer> getPath(TreeNode root, int target) {
        List<Integer> path = new ArrayList<>();
        while (root.val != target) {
            path.add(root.val);
            if (target < root.val) {
                root = root.left;
            } else {
                root = root.right;
            }
        }
        path.add(root.val);
        return path;
    }

    public int lowestCommonAncestor_0(TreeNode root, int p, int q) {
        // write code here

        List<Integer> pathP = getPath(root, p);
        List<Integer> pathQ = getPath(root, q);
        System.out.println(pathP);
        System.out.println(pathQ);

        int res = -1;
        for (int i = 0; i < Math.min(pathP.size(), pathQ.size()); i++) {
            int valP = pathP.get(i);
            int valQ = pathQ.get(i);
            if (valP == valQ)
                res = valP;
            else
                break;
        }
        return res;
    }

    public int lowestCommonAncestor(TreeNode root, int p, int q) {
        // write code here
        if (root == null) return -1;
        if ((p <= root.val && q >= root.val) || (p >= root.val && q <= root.val))
            return root.val;
        else if (p <= root.val && q <= root.val) {
            return lowestCommonAncestor(root.left, p, q);
        }else{
            return lowestCommonAncestor(root.right, p, q);
        }
    }


}