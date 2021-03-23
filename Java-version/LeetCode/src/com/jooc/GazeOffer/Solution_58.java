package com.jooc.GazeOffer;

import com.jooc.Solution;

public class Solution_58 implements Solution {
    @Override
    public void main() {
        System.out.println(reverseWords_0("   i have    a dream!    "));
        System.out.println(reverseLeftWords("abcdefg", 2));
    }

    public String reverseWords_0(String s){
        String[] strs = s.trim().split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = strs.length - 1; i >= 0; i--){
            if(strs[i].equals("")) continue;
            stringBuilder.append(strs[i] + " ");
        }
        return stringBuilder.toString().trim();
    }

    public String reverseWords(String s) {
        s = s.trim();
        if(s.length() == 0) return "";

        int i = s.length() - 1, j = i;
        StringBuilder stringBuilder = new StringBuilder();
        while(i >= 0){
            while(i >= 0 && s.charAt(i) != ' ') i--;
            stringBuilder.append(s.substring(i+1, j+1) + " ");
            while(i >= 0 && s.charAt(i) == ' ') i--;
            j = i;
        }

        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        return stringBuilder.toString();
    }

    public String reverseLeftWords_0(String s, int n) {
        char[] chars = s.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();

        for(int i = n; i < s.length(); i++){
            stringBuilder.append(chars[i]);
        }
        for(int i = 0; i < n; i++){
            stringBuilder.append(chars[i]);
        }
        return stringBuilder.toString();
    }

    public String reverseLeftWords(String s, int n){
        return s.substring(n) + s.substring(0, n);
    }
}
