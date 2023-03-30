package com.jooc.GazeOffer.Interview;

import java.util.*;

public class Ctrip {


    public static void main_1(String[] args) {
        Scanner in = new Scanner(System.in);
        int count = 0;
        String str = in.nextLine();

        for (char ch : str.toCharArray()) {
            if (ch == '6' || ch == '9' || ch == '0')
                count += 1;
            else if (ch == '8') {
                count += 2;
            }
        }
        System.out.println(count);

    }

    public static void main_2(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] res = new int[n];
        for(int i = 0; i < k; i++){
            res[2*i] = n + i + 1 -k;
        }

        int pos = 0;
        for(int i = 0; i < n; i++){
            if(res[i] == 0){
                res[i] = ++pos;
            }
        }
        for (int idx = 0; idx < n; idx++) {
            System.out.print(res[idx] + " ");
        }
    }

    private static void markVisited(boolean[] visitedNode, boolean[] visitedEdges, int[] edge, int visitedEdgeCount) {
        int node1 = edge[0];
        visitedNode[node1] = true;
        int node2 = edge[1];
        visitedNode[node2] = true;

        for (int i = 0; i < n-1; i++) {
            if (edges.get(i)[0] == node1 || edges.get(i)[1] == node1 || edges.get(i)[0] == node2 || edges.get(i)[1] == node2) {
                visitedEdges[i] = true;
                visitedEdgeCount++;
            }
        }
    }
    static int n;
    static ArrayList<int[]> edges = new ArrayList<>();
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        String nothing = in.nextLine();

        for (int i = 0; i < n - 1; i++) {
            String line = in.nextLine();
            String[] ints = line.split(" ");
            int[] nums = new int[3];
            for (int j = 0; j < 3; j++) {
                nums[j] = Integer.parseInt(ints[j]);
            }
            edges.add(nums);
        }

        int res = 0;
        for (int i = 0; i < n - 2; i++) {
            int[] beginEdge = edges.get(i);
            int tempVal = beginEdge[2];
            boolean[] visitedNodes = new boolean[n+1];
            boolean[] visitedEdges = new boolean[n];
            int visitedEdgeCount = 0;
            markVisited(visitedNodes, visitedEdges, beginEdge, visitedEdgeCount);

            while (visitedEdgeCount < n - 1) {
                int maxLeftEdge = -1;
                int maxLeftVal = 0;
                for (int j = 0; j < edges.size(); j++) {
                    if (!visitedEdges[j] && edges.get(j)[2] > maxLeftVal) {
                        maxLeftEdge = j;
                        maxLeftVal = edges.get(j)[2];
                    }
                }
                if (maxLeftEdge == -1) {
                    break;
                }
                tempVal += maxLeftVal;
                markVisited(visitedNodes, visitedEdges, edges.get(maxLeftEdge), visitedEdgeCount);
            }
            res = Math.max(res, tempVal);
        }
        System.out.println(res);
    }

    private static int fac(int x){
        int res = 1;
        while(x > 0){
            res *= x--;
        }
        return res;
    }

    public static void main_3(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        double minVal = Float.MAX_EXPONENT;
        int minX = -1;
        int minY = -1;

        for(int x = 1; x < n; x++){
            if(x ==  2) continue;
            for(int y = 1; y < n; y++){
                if(y == 2) continue;
                double val = Math.abs(fac(x)*y-y-n);
                if(val < minVal){
                    minVal = val;
                    minX = x;
                    minY = y;
                }
            }
        }

        System.out.print(minX + " ");
        System.out.print(minY);
    }
}

//            visitedEdges[i] = true;
//            visitedNodes[edges.get(i)[0]] = true;
//            visitedNodes[edges.get(i)[1]] = true;
//            int tempVal = edges.get(i)[2];
//            for(int k = 0; k < n-1; k++){
//                if(!visitedEdges[k] && (edges.get(k)[0]==))
//            }
//            visitedEdgeCount += 1;
//
////            res = Math.max(res, bfs(visitedNodes, visitedEdges));
//            while (visitedEdgeCount < n - 1) {
//
//            }
//
//
//            visitedEdges[i] = false;
//            visitedNodes[edges.get(i)[0]] = false;
//            visitedNodes[edges.get(i)[1]] = false;