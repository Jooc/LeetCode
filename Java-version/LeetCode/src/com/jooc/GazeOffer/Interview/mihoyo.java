package com.jooc.GazeOffer.Interview;

import java.lang.reflect.Array;
import java.util.*;

public class mihoyo {
    public static void main_1(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        long[] nums = new long[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextLong();
        }

        Arrays.sort(nums);

        long a = nums[n - 1];
        long b = nums[n - 2];

        boolean onlyOneCandidate = a == b;

        int candidates = 2;
        for (int i = n - 3; i >= 0; i--) {
            if (nums[i] == b) {
                candidates++;
            }
        }

        System.out.println(onlyOneCandidate ? candidates * (candidates - 1) : 2 * (candidates - 1));
    }

    public static void main_2_3(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        char[] chars = sc.nextLine().toCharArray();

        int left, right;

        HashSet<ArrayList<Integer>> notGoodSet = new HashSet<>();

        ArrayList<Integer> temp = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            left = i - 1;
            right = i + 1;
            if (left >= 0 && right < n && chars[left] == chars[right]) {
                for (int l = left; l >= 0; l--) {
                    for (int r = right; r < n; r++) {
                        temp.add(l);
                        temp.add(r);
                        notGoodSet.add(new ArrayList<>(temp));
                        temp.clear();
                    }
                }
            }

            left = i;
            right = i + 1;
            if (right < n && chars[left] == chars[right]) {
                for (int l = left; l >= 0; l--) {
                    for (int r = right; r < n; r++) {
                        temp.add(l);
                        temp.add(r);
                        notGoodSet.add(new ArrayList<>(temp));
                        temp.clear();
                    }
                }
            }
        }
        System.out.println(n * (n + 1) / 2 - notGoodSet.size());
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        char[] chars = sc.nextLine().toCharArray();
        int left, right;

        ArrayList<int[]> notGoodSet = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            left = i - 1;
            right = i + 1;
            if (left >= 0 && right < n && chars[left] == chars[right]) {
                notGoodSet.add(new int[]{left, right});
            }
            left = i;
            right = i + 1;
            if (right < n && chars[left] == chars[right]) {
                notGoodSet.add(new int[]{left, right});
            }
        }
        notGoodSet.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0])
                    return o1[0] - o2[0];
                return o1[1] - o2[1];
            }
        });

        int res = 0;
        for (int i = 0; i < n; i++) {
            res++;
            for (int j = i + 1; j < n; j++) {
                for (int[] ints : notGoodSet) {
                    if (i <= ints[0]) {
                        if (j < ints[1]) {
                            res++;
                        }
                    }else{
                        break;
                    }
                }
            }
        }

        System.out.println(res);
    }

    public static void main_2_2(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
//        char[] chars = sc.nextLine().toCharArray();
        String str = sc.nextLine();

        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (isGood(str.substring(i, j)))
                    res++;
            }
        }
        System.out.println(res);
    }

    private static boolean isGood(String str) {
        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j < str.length(); j++) {
                if (str.charAt(i) == str.charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main_3(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int[] union = new int[n];
        for (int i = 0; i < n; i++) {
            union[i] = i;
        }

        int[] count = new int[n];
        Arrays.fill(count, 1);

        HashMap<Integer, ArrayList<Integer>> colorCounter = new HashMap<>();
        colorCounter.put(1, new ArrayList<>());
        for (int i = 0; i < n; i++) {
            colorCounter.get(1).add(i);
        }

        int minColorCount = 1;
        int maxColorCount = 1;
        while (colorCounter.size() != 1 && colorCounter.get(maxColorCount).size() < n) {
            if (colorCounter.get(minColorCount).size() > 1) {

            }
        }


    }
}
