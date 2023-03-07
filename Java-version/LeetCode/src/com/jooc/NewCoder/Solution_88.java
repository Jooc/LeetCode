package com.jooc.NewCoder;

import com.jooc.Solution;

public class Solution_88 implements Solution {
    @Override
    public void main() {

    }

    public boolean judge(String str) {
        // write code here

        int left = 0, right = str.length() - 1;
        while(left < right){
            if(str.charAt(left++) != str.charAt(right--)) return false;
        }

        return true;
    }
}
