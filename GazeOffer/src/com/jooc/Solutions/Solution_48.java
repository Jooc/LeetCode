package com.jooc.Solutions;

import java.util.HashSet;

public class Solution_48 implements Solution {
    @Override
    public void main() {
        System.out.println(lengthOfLongestSubstring("xxzqi"));
    }

    public int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        int len = chars.length;

        HashSet<Character> set = new HashSet<>();
        int left = -1, right = 0;
        int res = 0;

        while(++left < len){
            set.add(chars[left]);
            if(right <= left) right = left + 1;
            while(right < len && !set.contains(chars[right])){
                set.add(chars[right]);
                right++;
            }
            res = Math.max(set.size(), res);
            set.remove(chars[left]);
        }

        return res;
    }
}
