package com.jooc.Competition;

import com.jooc.Solution;

import java.util.*;

public class Biweekly99 implements Solution {
    @Override
    public void main() {
//        System.out.println(splitNum(4325));
//        System.out.println(coloredCells(2));
//        System.out.println(countWays(new int[][]{{1, 3}, {10, 20}, {2, 5}, {4, 8}}));
//        System.out.println(countWays(new int[][]{{57,92},{139,210},{306,345},{411,442},{533,589},{672,676},{801,831},{937,940},{996,1052},{1113,1156},{1214,1258},{1440,1441},{1507,1529},{1613,1659},{1773,1814},{1826,1859},{2002,2019},{2117,2173},{2223,2296},{2335,2348},{2429,2532},{2640,2644},{2669,2676},{2786,2885},{2923,2942},{3035,3102},{3177,3249},{3310,3339},{3450,3454},{3587,3620},{3725,3744},{3847,3858},{3901,3993},{4100,4112},{4206,4217},{4250,4289},{4374,4446},{4510,4591},{4675,4706},{4732,4768},{4905,4906},{5005,5073},{5133,5142},{5245,5309},{5352,5377},{5460,5517},{5569,5602},{5740,5791},{5823,5888},{6036,6042},{6096,6114},{6217,6262},{6374,6394},{6420,6511},{6564,6587},{6742,6743},{6797,6877},{6909,6985},{7042,7117},{7141,7144},{7276,7323},{7400,7456},{7505,7557},{7690,7720},{7787,7800},{7870,7880},{8013,8031},{8114,8224},{8272,8328},{8418,8435},{8493,8537},{8600,8704},{8766,8812},{8839,8853},{9032,9036},{9108,9189},{9222,9291},{9344,9361},{9448,9502},{9615,9673},{9690,9800},{9837,9868},{85,96},{145,202},{254,304},{372,411},{534,551},{629,692},{727,787},{861,944},{1041,1084},{1133,1174},{1260,1307},{1339,1358},{1478,1548},{1580,1618},{1694,1814},{1848,1891},{1936,1990},{2058,2130}}));
        System.out.println(rootCount(new int[][]{{0, 1}, {1, 2}, {1, 3}, {4,2}}, new int[][]{{1, 3}, {0, 1}, {1, 0}, {2, 4}}, 3));
    }

    public int splitNum(int num) {
        int n = 0;
        int temp = num;
        ArrayList<Integer> list = new ArrayList<>();

        while (temp != 0) {
            n++;
            list.add(temp % 10);
            temp /= 10;
        }
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });

        System.out.println(list.toString());

        int index = 0;
        int num1 = 0, num2 = 0;
        while (index < n) {
            num1 = num1 * 10 + list.get(index++);
            if (index >= n) break;
            num2 = num2 * 10 + list.get(index++);
        }
        return num1 + num2;
    }

    public long coloredCells(int n) {
        return (2L * n - 1) * (2L * n - 1) - ((long) (n - 1) * n) * 2;
    }

    public int countWays(int[][] ranges) {
        Arrays.sort(ranges, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0]) return o1[0] - o2[0];
                return o1[1] - o2[1];
            }
        });
        System.out.println(Arrays.deepToString(ranges));


        int[] union = new int[ranges.length];
        for (int i = 0; i < union.length; i++) {
            union[i] = i;
        }
//        System.out.println(Arrays.toString(union));

        for (int i = 0; i < ranges.length; i++) {
            for (int j = i + 1; j < ranges.length; j++) {
                if (ranges[i][1] >= ranges[j][0]) {
                    union[j] = union[i];
                } else {
                    break;
                }
            }
        }

        long res = 1;
        HashSet<Integer> counter = new HashSet<>();
        for (int j : union) {
            counter.add(j);
        }
        for (int i = 0; i < counter.size(); i++) {
            res = (long) ((res * 2) % (1e9 + 7));
        }
//        System.out.println(Arrays.toString(union));
//        System.out.println(counter.size());

        return (int) res;
    }


    private int res = 0;

    int count = 0;

    private void func(int[][] edges, ArrayList<int[]> guesses) {
        for (int[] g : guesses) {
            System.out.println(Arrays.toString(g));
        }
        count++;
        System.out.println();
    }

    private void recur(int[][] edges, int[][] guesses, ArrayList<int[]> tempGuesses, int k, HashSet<Integer> chosenIndex) {
        if (tempGuesses.size() == k) {
            func(edges, tempGuesses);
            return;
        }
        for (int i = 0; i < edges.length; i++) {
            if (chosenIndex.contains(i)) continue;
            chosenIndex.add(i);
            tempGuesses.add(guesses[i]);
            recur(edges, guesses, tempGuesses, k, chosenIndex);
            chosenIndex.remove(i);
            tempGuesses.remove(tempGuesses.size() - 1);
        }
    }

    public int rootCount_0(int[][] edges, int[][] guesses, int k) {
        ArrayList<int[]> tempGuesses = new ArrayList<>();
        HashSet<Integer> chosenIndex = new HashSet<>();
        for (int trueK = k; trueK <= guesses.length; trueK++) {
            recur(edges, guesses, tempGuesses, trueK, chosenIndex);
        }

        System.out.println(count);
        return 0;
    }

    private int validGuesses(int[][] edges, int[][] guesses, int root, ArrayList<Integer> nodes, int k) {
        HashSet<Integer> parents = new HashSet<>();
        HashSet<Integer> sons = new HashSet<>(nodes);

        parents.add(root);
        sons.remove(root);
        while (sons.size() != 0) {
            for (int[] edge : edges) {
                if (parents.contains(edge[0]) || parents.contains(edge[1])) {
                    if (sons.contains(edge[0]) && parents.contains(edge[1])) {
                        int temp = edge[1];
                        edge[1] = edge[0];
                        edge[0] = temp;
                    }
                    sons.remove(edge[1]);
                    parents.add(edge[1]);
                }
            }
        }
        int count = 0;
        for (int[] guess : guesses) {
            for(int [] edge : edges){
                if(edge[0] == guess[0] && edge[1]==guess[1]) count++;
            }
        }
        return count >= k ? 1 : 0;
    }

    public int rootCount(int[][] edges, int[][] guesses, int k) {
        ArrayList<Integer> nodes = new ArrayList<>();
        for (int[] edge : edges) {
            if (!nodes.contains(edge[0])) nodes.add(edge[0]);
            if (!nodes.contains(edge[1])) nodes.add(edge[1]);
        }
        nodes.sort(Integer::compareTo);

        int res = 0;
        for (int root : nodes) {
            res += validGuesses(edges, guesses, root, nodes, k);
        }

        return res;
    }

}
