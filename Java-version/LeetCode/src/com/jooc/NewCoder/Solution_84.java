package com.jooc.NewCoder;

import com.jooc.Solution;

public class Solution_84 implements Solution {

    @Override
    public void main() {
    }

    public String longestCommonPrefix(String[] strs) {
        // write code here
        StringBuilder res = new StringBuilder();
        if (strs.length == 0) return res.toString();

        for (int i = 0; i < strs[0].length(); i++) {
            char temp = strs[0].charAt(i);
            for (int j = 0; j < strs.length; j++) {
                if (i >= strs[j].length() || strs[j].charAt(i) != temp)
                    return res.toString();
            }
            res.append(temp);
        }
        return res.toString();
    }

}
