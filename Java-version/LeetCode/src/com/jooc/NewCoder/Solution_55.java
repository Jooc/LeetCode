package com.jooc.NewCoder;

import com.jooc.Solution;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Solution_55 implements Solution {
    @Override
    public void main() {
        System.out.println(permute(new int[]{1, 2, 3}));
    }

    private ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    public void recur(int[] num, ArrayList<Integer> temp){
        if (temp.size() == num.length) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int j : num) {
            if (temp.contains(j)) continue;

            temp.add(j);
            recur(num, temp);
            temp.remove(temp.size() - 1);
        }
    }

    public ArrayList<ArrayList<Integer>> permute_0(int[] num) {
        ArrayList<Integer> temp = new ArrayList<>();
        recur(num, temp);
        return res;
    }


    public ArrayList<ArrayList<Integer>> permute(int[] num) {
        ArrayList<Integer> list = new ArrayList<>();
        res.add(list);

        for(int i = 0; i < num.length; i++){
            ArrayList<ArrayList<Integer>> temp = new ArrayList<>();

            for(ArrayList<Integer> t: res){
                for(int j = 0; j < t.size()+1; j++){
                    t.add(j, num[i]);
                    temp.add(new ArrayList<>(t));
                    t.remove(j);
                }
            }
            res = new ArrayList<>(temp);
        }
        return res;
    }
}
