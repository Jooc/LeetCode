package com.jooc.NewCoder;

import com.jooc.Solution;

import java.util.*;
import java.util.stream.Collectors;

public class Solution_56 implements Solution {
    @Override
    public void main() {
        System.out.println(permuteUnique(new int[]{1, 1, 2}));
    }

    private HashSet<ArrayList<Integer>> res_0 = new HashSet<>();

    private void recur_0(int[] num, ArrayList<Integer> indexTemp) {
        if (indexTemp.size() == num.length) {
            res_0.add(indexTemp.stream().map(x -> num[x]).collect(Collectors.toCollection(ArrayList::new)));
            return;
        }
        for (int i = 0; i < num.length; i++) {
            if (indexTemp.contains(i)) continue;
            indexTemp.add(i);
            recur_0(num, indexTemp);
            indexTemp.remove(indexTemp.size() - 1);
        }
    }

    public ArrayList<ArrayList<Integer>> permuteUnique_0(int[] num) {
        Arrays.sort(num);
        ArrayList<Integer> temp = new ArrayList<>();
        recur_0(num, temp);

        return new ArrayList<>(res_0).stream().sorted(new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                for (int i = 0; i < o1.size(); i++) {
                    if (!o1.get(i).equals(o2.get(i)))
                        return o1.get(i).compareTo(o2.get(i));
                }
                return 0;
            }
        }).collect(Collectors.toCollection(ArrayList::new));
    }

    private ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    boolean[] mark;

    private void recur(int[] num, LinkedList<Integer> track) {
        if (track.size() == num.length) {
            res.add(new ArrayList<Integer>(track));
            return;
        }
        for (int i = 0; i < num.length; i++) {
            if (mark[i] || i > 0 && num[i] == num[i - 1] && !mark[i-1]) continue;
            track.add(num[i]);
            mark[i] = true;
            recur(num, track);
            track.removeLast();
            mark[i] = false;
        }
    }

    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        Arrays.sort(num);
        mark = new boolean[num.length];
        LinkedList<Integer> track = new LinkedList<>();

        recur(num, track);
        return res;
    }
}
