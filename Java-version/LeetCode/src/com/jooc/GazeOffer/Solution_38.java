package com.jooc.GazeOffer;

import com.jooc.Solution;

import java.util.*;

public class Solution_38 {

    public void main() {

        System.out.println(Arrays.toString(permutation("abc")));
    }


    List<String> res = new LinkedList<>();
    char[] chars;

    public String[] permutation(String s) {
        chars = s.toCharArray();
        dfs(0);
        return res.toArray(new String[res.size()]);
    }

    private void dfs(int index) {
        if (index == chars.length - 1) {
            res.add(String.valueOf(chars));
            return;
        }

        /**
         * <code>set</code> 被用来剪枝
         * 如果在待交换字符之前已经交换过，说明在这个固定位置将会第二次出现某字符
         * 后续情况均为重复情况
         */
        HashSet<Character> set = new HashSet<>();
        for (int i = index; i < chars.length; i++) {
            if (set.contains(chars[i])) continue;
            set.add(chars[i]);
            swap(i, index);
            dfs(index + 1);
            swap(i, index);
        }
    }

    private void swap(int x, int y) {
        char temp = chars[x];
        chars[x] = chars[y];
        chars[y] = temp;
    }
}

class Solution_38_new_0 {
    Set<String> res = new HashSet<String>();
    boolean[] alreadyIn;
    int maxLen;

    private void recur(String s, StringBuilder builder) {
        if (builder.length() == maxLen) {
            res.add(builder.toString());
        }
        for (int i = 0; i < maxLen; i++) {
            if (alreadyIn[i]) continue;

            builder.append(s.charAt(i));
            alreadyIn[i] = true;
            recur(s, builder);
            builder.deleteCharAt(builder.length() - 1);
            alreadyIn[i] = false;
        }
    }

    public String[] permutation(String s) {
        maxLen = s.length();
        alreadyIn = new boolean[maxLen];

        StringBuilder builder = new StringBuilder();
        recur(s, builder);

        int n = res.size();
        String[] ans = new String[n];
        int index = 0;
        for (String ss : res) {
            ans[index++] = ss;
        }
        return ans;
    }
}

// 排序去重
class Solution_38_new implements Solution {
    @Override
    public void main() {

    }

    List<String> res;
    boolean[] vis;

    private void backtrack(char[] arr, int i, int n, StringBuilder perm){
        if(i == n){
            res.add(perm.toString());
            return;
        }

        for(int j = 0; j < n; j++){
            if(vis[j] || (j > 0 && arr[j-1] == arr[j] && !vis[j-1]))
                continue;

            vis[j] = true;
            perm.append(arr[j]);
            backtrack(arr, i+1, n, perm);
            perm.deleteCharAt(perm.length()-1);
            vis[j] = false;
        }
    }

    public String[] permutation(String s) {
        int n = s.length();
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        StringBuilder perm = new StringBuilder();

        res = new ArrayList<String>();
        vis = new boolean[n];

        backtrack(arr, 0, n, perm);

        int size = res.size();
        String[] resArr = new String[size];
        for(int i = 0; i < size; i++){
            resArr[i] = res.get(i);
        }
        return resArr;
    }


}