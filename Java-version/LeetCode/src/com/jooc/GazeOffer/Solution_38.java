package com.jooc.GazeOffer;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class Solution_38 {

    public void main(){

        System.out.println(Arrays.toString(permutation("abc")));
    }


    List<String> res = new LinkedList<>();
    char[] chars;
    public String[] permutation(String s) {
        chars = s.toCharArray();
        dfs(0);
        return res.toArray(new String[res.size()]);
    }

    private void dfs(int index){
        if(index == chars.length - 1){
            res.add(String.valueOf(chars));
            return;
        }

        /**
         * <code>set</code> 被用来剪枝
         * 如果在待交换字符之前已经交换过，说明在这个固定位置将会第二次出现某字符
         * 后续情况均为重复情况
         */
        HashSet<Character> set = new HashSet<>();
        for(int i = index; i < chars.length; i++){
            if(set.contains(chars[i])) continue;
            set.add(chars[i]);
            swap(i, index);
            dfs(index+1);
            swap(i,index);
        }
    }

    private void swap(int x, int y){
        char temp = chars[x];
        chars[x] = chars[y];
        chars[y] = temp;
    }
}
