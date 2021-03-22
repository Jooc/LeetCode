package com.jooc.GazeOffer;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Solution_50 implements Solution{

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
        HashMap<Character, Boolean> orderedMap = new LinkedHashMap<>();

        for(char c : s.toCharArray()){
            orderedMap.put(c, !orderedMap.containsKey(c));
        }
        for(Map.Entry<Character, Boolean> entry : orderedMap.entrySet()){
            if(entry.getValue()) return entry.getKey();
        }
        return ' ';
    }

}
