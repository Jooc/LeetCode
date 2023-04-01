package com.jooc.Common;

import com.jooc.Solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution_763 implements Solution {
    @Override
    public void main() {
        System.out.println(partitionLabels("ababcbacadefegdehijhklij"));
        System.out.println(partitionLabels("caedbdedda"));
    }

    public List<Integer> partitionLabels_0(String s) {
        List<Integer> res = new ArrayList<>();

        int n = s.length();
        int[] lastPos = new int[26];

        for (int i = n - 1; i >= 0; i--) {
            if (lastPos[s.charAt(i) - 'a'] == 0)
                lastPos[s.charAt(i) - 'a'] = i;
        }

        System.out.println(Arrays.toString(lastPos));
        int begin = 0, end;
        while (begin < n) {
            end = lastPos[s.charAt(begin) - 'a'];
            int i = begin;
            while (i < end) {
                end = Math.max(lastPos[s.charAt(i++) - 'a'], end);
            }
            res.add(end - begin + 1);
            begin = end + 1;
        }
        return res;
    }

    public List<Integer> partitionLabels(String s) {
        List<Integer> res = new ArrayList<>();

        int n = s.length();
        int[] lastPos = new int[26];

        for(int i = 0; i < n; i++){
            lastPos[s.charAt(i)-'a'] = i;
        }

        System.out.println(Arrays.toString(lastPos));
        int begin = 0, end = 0;
        for(int i = 0; i < n; i++){
            end = Math.max(lastPos[s.charAt(i) - 'a'], end);
            if(i == end){
                res.add(end - begin + 1);
                begin = end + 1;
            }
        }

        return res;
    }
}
