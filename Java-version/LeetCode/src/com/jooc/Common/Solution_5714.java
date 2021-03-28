package com.jooc.Common;

import com.jooc.Solution;

import java.util.HashMap;
import java.util.List;

public class Solution_5714 implements Solution {
    @Override
    public void main() {
//        System.out.println("(name)is(age)yearsold", );
    }

    public String evaluate(String s, List<List<String>> knowledge) {
        HashMap<String, String> map = new HashMap<>();
        for(int i = 0; i < knowledge.size(); i++){
            map.put(knowledge.get(i).get(0), knowledge.get(i).get(1));
        }

        int index = 0;
        StringBuilder res = new StringBuilder();
        char[] chars = s.toCharArray();
        while(index < s.length()){
            if(chars[index] == '('){
                StringBuilder key = new StringBuilder();
                index++;
                while(index < chars.length && chars[index] != ')'){
                    key.append(chars[index++]);
                }
                index++;
                if(map.containsKey(key.toString())) {
                    res.append(map.get(key.toString()));
                }else{
                    res.append('?');
                }
            }else{
                res.append(s.charAt(index++));
            }
        }
        return res.toString();
    }
}
