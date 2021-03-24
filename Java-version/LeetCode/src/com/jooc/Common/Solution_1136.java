package com.jooc.Common;

import com.jooc.Solution;

import java.util.*;

public class Solution_1136 implements Solution {
    @Override
    public void main() {
        System.out.println(minimumSemesters(3, new int[][]{{1,3}, {2,3}}));
    }


    // 拓扑排序
    // 根据relations 建立邻接表和入度表
    // 每学期挑选入度为0 的课程输出，并将该课程的所有指向节点对应值入度-1
    public int minimumSemesters(int n, int[][] relations){
        ArrayList<Integer>[] graph = new ArrayList[n+1];
        for(int i = 1; i <= n; i++){
            graph[i] = new ArrayList<>();
        }

        // 构建邻接表 和入度表
        int[] inDegree = new int[n+1];
        for(int[] relation: relations){
            graph[relation[0]].add(relation[1]);
            inDegree[relation[1]]++;
        }

        // 初始化拓扑队列
        LinkedList<Integer> semesterQueue = new LinkedList<>();
        for(int i = 1; i <= n; i++){
            if(inDegree[i] == 0){
                semesterQueue.add(i);
            }
        }

        int finishedLesson = semesterQueue.size();
        int semesterCount = 0;

        while(!semesterQueue.isEmpty()){
            List<Integer> lessons = new ArrayList<>(semesterQueue);
            semesterQueue.clear();
            for(Integer lesson : lessons) {
                for (Integer targetLesson : graph[lesson]) {
                    if (--inDegree[targetLesson] == 0) {
                        semesterQueue.add(targetLesson);
                        finishedLesson++;
                    }
                }
            }
            semesterCount++;
        }

        return finishedLesson == n ? semesterCount : -1;
    }


    // 多源有向图的遍历 —— Pass case 1/39
    public int minimumSemesters_0(int n, int[][] relations) {
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
