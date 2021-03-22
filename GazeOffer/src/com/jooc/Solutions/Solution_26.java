package com.jooc.Solutions;

import com.jooc.components.TreeNode;
import java.util.ArrayList;
import java.util.List;

public class Solution_26 {

    public boolean isSubStructure(TreeNode A, TreeNode B){
        return((A!= null && B!= null) ||
                (recur(A,B) || isSubStructure(A.left, B) || isSubStructure(A.right, B)));
    }

    public boolean recur(TreeNode A, TreeNode B){
        if(B == null) return true;
        if(A == null || A.val != B.val) return false;
        return recur(A.left, B.left) && recur(A.right, B.right);
    }


//    public boolean isSubStructure(TreeNode A, TreeNode B) {
//        if(A == null || B == null) return false;
//
//        List<Integer> listA = new ArrayList<>();
//        List<Integer> listB = new ArrayList<>();
//        inOrder(listA, A);
//        inOrder(listB, B);
//
//        int sizeB = listB.size();
//        for(int i = 0; i <= listA.size() - sizeB; i++){
//            if(listA.get(i).equals(listB.get(0))){
//                if(listA.subList(i, i + sizeB).equals(listB)){
//                    return true;
//                }
//            }
//        }
//
//        return false;
//    }
//
//    public void inOrder(List<Integer> res, TreeNode root){
//        if(root.left !=null) inOrder(res, root.left);
//        res.add(root.val);
//        if(root.right != null) inOrder(res, root.right);
//    }

}
