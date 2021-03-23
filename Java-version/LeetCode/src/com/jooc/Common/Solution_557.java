package com.jooc.Common;

public class Solution_557 {
    public String reverseWords(String s) {
        String[] strs = s.split(" ");
        StringBuilder res = new StringBuilder();
        for (String str : strs) {
            StringBuilder stringBuilder = new StringBuilder();
            char[] chars = str.toCharArray();
            for (int i = chars.length - 1; i >= 0; i--) {
                stringBuilder.append(chars[i]);
            }
            res.append(stringBuilder.toString());
            res.append(" ");
        }
        res.deleteCharAt(res.length() - 1);
        return res.toString();
    }
}
