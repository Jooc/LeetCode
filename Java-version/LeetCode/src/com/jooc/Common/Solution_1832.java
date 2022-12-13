package com.jooc.Common;

import com.jooc.Solution;

import java.util.HashMap;

public class Solution_1832 implements Solution {

    @Override
    public void main() {

    }

    public boolean checkIfPangram(String sentence) {
        if (sentence.length() < 26) {
            return false;
        }
        HashMap<Character, Boolean> map = new HashMap<>();
        for (int i = 0; i < 26; i++) {
            map.put((char) ('a' + i), false);
        }
        for (char c : sentence.toCharArray()) {
            map.put(c, true);
        }
        for (int i = 0; i < 26; i++) {
            if (!map.get((char) ('a' + i))) {
                return false;
            }
        }
        return true;
    }

    public boolean checkIfPangram_1(String sentence) {
        if (sentence.length() < 26) {
            return false;
        }
        boolean[] exists = new boolean[26];
        for (int i = 0; i < sentence.length(); i++) {
            char c = sentence.charAt(i);
            exists[c - 'a'] = true;
        }
        for (int i = 0; i < 26; i++) {
            if (!exists[i])
                return false;
        }
        return true;
    }
}
