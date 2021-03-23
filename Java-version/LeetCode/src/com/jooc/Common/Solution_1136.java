package com.jooc.Common;

import com.jooc.Solution;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;

public class Solution_1136 implements Solution {
    @Override
    public void main() {

    }

    // 多源有向图的遍历
    public int minimumSemesters(int n, int[][] relations) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 1; i <= n; i++) {
            set.add(i);
        }
        for (int[] relation : relations) {
            set.remove(relation[1]);
        }
        if (set.isEmpty()) return -1;

        boolean[] learned = new boolean[n];
        LinkedList<Integer> newReachable = new LinkedList<>(set);

        HashSet<int[]> remainedRelation = new HashSet<>();
        Collections.addAll(remainedRelation, relations);

        int termCount = 0;
        while (!newReachable.isEmpty()) {
            ArrayList<Integer> singleTerm = new ArrayList<>(newReachable);
            newReachable.clear();

            termCount++;
            for (int learning : singleTerm) {
                learned[learning - 1] = true;
                for (int[] re : remainedRelation) {
                    if (re[0] == learning && !learned[re[1] - 1]) {
                        remainedRelation.remove(re);
                        newReachable.add(re[1]);
                    }
                }
            }
        }

        for (boolean isLearned : learned) {
            if (!isLearned) return -1;
        }

        return termCount;
    }
}
