package com.jooc.NewCoder;

import com.jooc.Solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution_96 implements Solution {
    @Override
    public void main() {
        //        int[] a = new int[]{2147483646, 2147483647, 2, 1, 3, -5, -10, -2147483648};
//        System.out.println(2147483646 + 2147483647);
//        System.out.println(2147483646 - (-2147483648));
//        Arrays.sort(a);
//        System.out.println(Arrays.toString(a));

//        int[][] a = new int[][]{{}}
//        int[][] b = new int[][]{{2147483646, 2147483647}, {-2147483648, -2147483647}, {2147483646, 2147483647}, {-2147483648, -2147483647}, {2147483646, 2147483647}, {-2147483648, -2147483647}, {2147483646, 2147483647}, {-2147483648, -2147483647}, {2147483646, 2147483647}, {-2147483648, -2147483647}};


//        int[][] b = new int[][]{{2147483646, 2147483647}, {-2147483648, -2147483647}};
//        long[][] c = new long[b.length][b[0].length];
//
//        Integer aa = 2147483646;
//        Integer bb = -2147483648;
//
//        System.out.println(aa - bb);
//        System.out.println(aa.compareTo(bb));

//        for (int i = 0; i < b.length; i++) {
//            for (int j = 0; j < b[0].length; j++) {
//                c[i][j] = b[i][j];
//            }
//        }
//
//        System.out.println(b[0][0] - b[1][0]);
//        System.out.println(c[0][0] - c[1][0]);
//
//        Arrays.sort(b, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0]);
//        Arrays.sort(c, (o1, o2) -> (int) (o1[0] == o2[0] ? (o1[1] - o2[1]) % 2147483647 : (o1[0] - o2[0]) % 2147483647));
//        System.out.println(Arrays.deepToString(b));
//        System.out.println(Arrays.deepToString(c));

        System.out.println(minmumNumberOfHost(10, new int[][]{{2147483646, 2147483647}, {-2147483648, -2147483647}, {2147483646, 2147483647}, {-2147483648, -2147483647}, {2147483646, 2147483647}, {-2147483648, -2147483647}, {2147483646, 2147483647}, {-2147483648, -2147483647}, {2147483646, 2147483647}, {-2147483648, -2147483647}}));
        System.out.println(minmumNumberOfHost(2, new int[][]{{1, 2}, {2, 3}}));
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 计算成功举办活动需要多少名主持人
     *
     * @param n        int整型 有n个活动
     * @param startEnd int整型二维数组 startEnd[i][0]用于表示第i个活动的开始时间，startEnd[i][1]表示第i个活动的结束时间
     * @return int整型
     */
    public int minmumNumberOfHost(int n, int[][] startEnd) {
        // write code here

        ArrayList<ArrayList<Integer>> newStartEnd = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(startEnd[i][0]);
            temp.add(startEnd[i][1]);
            newStartEnd.add(temp);
        }

        newStartEnd.sort((o1, o2) -> o1.get(0).equals(o2.get(0)) ? o1.get(0).compareTo(o2.get(0)) : o1.get(1).compareTo(o2.get(1)));

        System.out.println(newStartEnd);
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.offer(Integer.MIN_VALUE);
        for (ArrayList<Integer> session : newStartEnd) {
            if (queue.peek() <= session.get(0))
                queue.poll();
            queue.offer(session.get(1));
        }

        return queue.size();
    }
}
