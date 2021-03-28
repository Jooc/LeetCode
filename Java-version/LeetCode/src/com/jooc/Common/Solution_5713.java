package com.jooc.Common;


import com.jooc.Solution;

import java.util.HashSet;

public class Solution_5713 implements Solution {
    @Override
    public void main() {
        System.out.println(numDifferentIntegers("4w31am0ets6sl5go5ufytjtjpb7b0sxqbee2blg9ss"));
    }

    public int numDifferentIntegers(String word) {
        char[] chars = word.toCharArray();

        int index = 0;
        HashSet<String> set = new HashSet<>();
        while (index < chars.length){
            if(chars[index] <= '9' && chars[index] >= '0'){
                StringBuilder stringBuilder = new StringBuilder();
                while(index < chars.length && chars[index] <= '9' && chars[index] >= '0'){
                    stringBuilder.append(chars[index++]);
                }
                String str = stringBuilder.toString();
                int begin = 0;
                while(begin < str.length() && str.charAt(begin) == '0'){
                    begin++;
                }
                if(begin == str.length() - 1 && str.charAt(begin) == '0'){
                    set.add("0");
                }else {
                    set.add(stringBuilder.toString().substring(begin));
                }
            }
            index++;
        }

        return set.size();
    }
}