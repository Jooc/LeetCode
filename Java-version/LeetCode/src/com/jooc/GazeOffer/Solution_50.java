package com.jooc.GazeOffer;

import com.jooc.Solution;
import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Solution_50 implements Solution {

    @Override
    public void main() {
        System.out.println(firstUniqChar("leetcode"));
    }

    public char firstUniqChar_0(String s) {
        HashMap<Character, Boolean> map = new HashMap<>();

        for(char c: s.toCharArray()){
            if(map.containsKey(c)){
                map.put(c, false);
            }else{
                map.put(c, true);
            }
        }

        for(char c: s.toCharArray()){
            if(map.get(c)){
                return c;
            }
        }
        return ' ';
    }

    public char firstUniqChar(String s){
        HashMap<Character, Boolean> map = new LinkedHashMap<>();

        char[] chars = s.toCharArray();
        for(char c: chars){
            map.put(c, !map.containsKey(c));
        }
        for(Map.Entry<Character, Boolean> entry: map.entrySet()){
            if(entry.getValue())
                return entry.getKey();
        }

        return ' ';
    }

    public char firstUniqueChar(String s){
        HashMap<>
    }
}
