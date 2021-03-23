package com.jooc.GazeOffer;

import com.jooc.Solution;
import com.jooc.components.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution_68 implements Solution {
    @Override
    public void main() {

    }

    public TreeNode lowestCommonAncestor_0(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> listp = new ArrayList<>();
        List<TreeNode> listq = new ArrayList<>();

        getPath(listp, root, p.val);
        getPath(listq, root, q.val);

        TreeNode res = root;
        for(int i = 1, j = 1; i < listp.size() && j < listq.size(); i++, j++){
            if (listp.get(i).equals(listq.get(i))){
                res = listp.get(i);
            }else{
                break;
            }
        }
        return res;
    }

    private void getPath(List<TreeNode> path, TreeNode root, int target){
        path.add(root);

        if(target == root.val) return;
        else if(target < root.val) getPath(path, root.left, target);
        else  getPath(path, root.right, target);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
        while(root != null) {
            if (p.val < root.val && q.val < root.val) {
                root = root.left;
            }
            else if (p.val > root.val && q.val > root.val) {
                root = root.right;
            }
            else break;
        }
        return root;
    }
}

class Solution_68_1 implements Solution{
    @Override
    public void main() {

    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left ,p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if(left == null) return right;
        if(right == null) return left;
        return root;
    }

}