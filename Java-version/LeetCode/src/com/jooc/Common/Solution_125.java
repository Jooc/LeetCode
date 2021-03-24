package com.jooc.Common;

import com.jooc.Solution;

public class Solution_125 implements Solution {
    @Override
    public void main() {
        System.out.println(isPalindrome("0P"));
    }

    public boolean isPalindrome(String s) {
        int len = s.length();
        int left = 0, right = len - 1;

        String str = s.toLowerCase();
        while(left < right){
            while(left < right && !isNumOrLetter(str.charAt(left))) left++;
            while(left < right && !isNumOrLetter(str.charAt(right))) right--;

            if(left < right){
                if(str.charAt(left++) != (str.charAt(right--))) return false;
            }
        }
        return true;
    }

    private boolean isNumOrLetter(char c){
        return (c >= '0' && c <= '9') || (c >= 'a' && c <= 'z');
    }
}
