package com.jooc;

import java.util.Arrays;

public class Solution_6368 implements Solution {
    @Override
    public void main() {
//        System.out.println(Arrays.toString(divisibilityArray("91221181269244172125025075166510211202115152121212341281327", 21)));
        System.out.println(Arrays.toString(divisibilityArray("1010", 10)));
    }

    public int[] divisibilityArray(String word, int m) {
        long left = 0;
        int[] ans = new int[word.length()];
        for (int i = 0; i < word.length(); i++) {
            left = left * 10 + Character.getNumericValue(word.charAt(i));
//            left = left % m;
            if (left % m == 0) {
                ans[i] = 1;
            }
            left = left % m;
//            if (sum % m == 0){
//                ans[i] = 1;
//                sum = 0;
//            }else{
//                ans[i] = 0;
//            }

        }
        return ans;
    }
}
