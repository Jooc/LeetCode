package com.jooc.GazeOffer;

import com.jooc.Solution;

import java.util.HashMap;
import java.util.Map;

public class Solution_20 implements Solution {
    @Override
    public void main() {

    }

    public boolean isNumber(String s) {
        Map[] stateTransition = {
                new HashMap<Character, Integer>() {{put(' ', 0); put('s', 1); put('d', 2); put('.', 4); }}, // 0
                new HashMap<Character, Integer>() {{put('d', 2); put('.', 4); }}, // 1
                new HashMap<Character, Integer>() {{put('d', 2); put('.', 3); put('e', 5); put(' ', 8); }}, // 2
                new HashMap<Character, Integer>() {{put('d', 3); put('e', 5); put(' ', 8); }}, // 3
                new HashMap<Character, Integer>() {{put('d', 3); }}, // 4
                new HashMap<Character, Integer>() {{put('s', 6); put('d', 7); }}, // 5
                new HashMap<Character, Integer>() {{put('d', 7); }}, // 6
                new HashMap<Character, Integer>() {{put('d', 7); put(' ', 8); }}, // 7
                new HashMap<Character, Integer>() {{put(' ', 8); }}, // 8
        };

        int state = 0;
        char input;
        for(char c: s.toCharArray()){
            if (isDigital(c)) input = 'd';
            else if(c == '+' || c == '-') input = 's';
            else if(c == 'e' || c == 'E') input = 'e';
            else if(c == '.' || c == ' ') input = c;
            else input = '?';

            if(!stateTransition[state].containsKey(input)) return false;
            state = (int)stateTransition[state].get(input);
        }

        return state == 2 || state == 3 || state == 7 || state == 8;
    }

    private boolean isDigital(char ch){
        return ch >= '0' && ch <= '9';
    }
}
