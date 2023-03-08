package com.jooc.NewCoder;

import com.jooc.Solution;

public class Solution_91 implements Solution {
    @Override
    public void main() {

    }

    /**
     * 反转字符串
     *
     * @param str string字符串
     * @return string字符串
     */
    public String solve(String str) {
        // write code here
        StringBuilder builder = new StringBuilder(str);
        return builder.reverse().toString();
    }

}
