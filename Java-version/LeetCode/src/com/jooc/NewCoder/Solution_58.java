package com.jooc.NewCoder;

import com.jooc.Solution;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution_58 implements Solution {
    @Override
    public void main() {
        System.out.println(Permutation("aba"));
    }

    private boolean[] vis;
    private ArrayList<String> res = new ArrayList<>();

    private void recur(char[] arr, int idx, StringBuilder builder){
        if(builder.length() == arr.length){
            res.add(builder.toString());
            return;
        }
        for(int i = 0; i < arr.length; i++){
            if(vis[i] || (i > 0 && arr[i] == arr[i-1]) && !vis[i-1]) continue;
            builder.append(arr[i]);
            vis[i] = true;
            recur(arr, idx+1, builder);
            builder.deleteCharAt(builder.length()-1);
            vis[i] = false;
        }
    }

    public ArrayList<String> Permutation(String str) {
        char[] charArr = str.toCharArray();
        Arrays.sort(charArr);
        StringBuilder builder = new StringBuilder();
        vis = new boolean[str.length()];

        recur(charArr, 0, builder);
        return res;
    }
}
