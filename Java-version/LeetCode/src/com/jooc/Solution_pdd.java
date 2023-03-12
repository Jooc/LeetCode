package com.jooc;

import java.util.*;

public class Solution_pdd implements Solution {

    @Override
    public void main() {

    }

    public static void main_0(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        StringBuilder builder = new StringBuilder();

        char[] chs = str.toCharArray();
        for (int i = 0; i < chs.length; i++) {
            int count = 0;
            while (chs[i] <= '9' && chs[i] >= '0') {
                count = count * 10 + chs[i] - '0';
                i++;
            }

            for (int j = 0; j < count; j++) {
                builder.append(chs[i]);
            }
        }

        System.out.println(builder.toString());
    }

    public static void main_1(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int N = sc.nextInt();

        for (int i = 0; i < T; i++) {
            int[] enemys = new int[N];

            int oneCount = 0;
            for (int j = 0; j < N; j++) {
                enemys[j] = sc.nextInt();
                if (enemys[j] == 1) oneCount++;
            }
            System.out.println(N - oneCount + ((oneCount + 1) / 2));
        }
    }


    public static void main_2(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        if (N == 0) {
            System.out.println(0);
            System.out.println(0);
        }

        int sum = 0;

        PriorityQueue<Integer> queueLittle = new PriorityQueue<>((o1, o2) -> o2 - o1);
        PriorityQueue<Integer> queueBig = new PriorityQueue<>((o1, o2) -> o1 - o2);
//
//        for(int k = 0; k < 10; k++){
//            queueLittle.add(k);
//            queueBig.add(k);
//        }
//
//        for(int k = 0; k < 10; k++) {
//            System.out.println(queueLittle.poll());
//        }
//        for(int k = 0; k < 10; k++) {
//            System.out.println(queueBig.poll());
//        }

        int[] avg = new int[N];
        int[] mid = new int[N];
        for (int i = 1; i <= N; i++) {
            int n = sc.nextInt();

            sum += n;
            double val = (double) sum / i;
            int intt = sum / i;
            if (val - intt >= 0.5) {
                avg[i - 1] = intt + 1;
            } else {
                avg[i - 1] = intt;
            }

            queueBig.add(n);
            if (queueBig.size() == 1 && queueLittle.size() == 0) {
                mid[i - 1] = queueBig.peek();
                continue;
            }

            if (queueBig.size() > queueLittle.size() + 1) {
                queueLittle.add(queueBig.poll());
            }
            if (queueBig.size() == queueLittle.size()) {
                double dval = (double) (queueBig.peek() + queueLittle.peek()) / 2;
                int dintt = (queueBig.peek() + queueLittle.peek()) / 2;
                if (dval - dintt >= 0.5) {
                    mid[i - 1] = dintt + 1;
                } else {
                    mid[i - 1] = dintt;
                }
            } else {
                mid[i - 1] = queueBig.peek();
            }
        }

        for (int c = 0; c < N; c++) {
            System.out.print(avg[c]);
            System.out.print(' ');
        }
        System.out.println();

        for (int c = 0; c < N; c++) {
            System.out.print(mid[c]);
            System.out.print(' ');
        }
        System.out.println();
//        System.out.println(Arrays.toString(avg));
//        System.out.println(Arrays.toString(mid));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        String[] people = new String[N];
        sc.nextLine();
        for (int i = 0; i < N; i++) {
            people[i] = sc.nextLine();
        }
        int[][] activities = new int[3][2];
        for (int i = 0; i < 3; i++) {
            String str = sc.nextLine();
            activities[i][0] = Integer.parseInt(str.split(" ")[0]);
            activities[i][1] = Integer.parseInt(str.split(" ")[1]);
        }

        HashMap<Integer, Integer> costs = new HashMap<>();
        for (int i = 0; i < 3; i++) {
            costs.put(i, activities[i][1]);
        }

        // TODO: 可能活动也需要按开销排序
        Arrays.sort(activities, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });


        for (int i = 0; i < N; i++) {
            char[] chh = people[i].toCharArray();
            String[] strs = new String[chh.length];

            for (int j = 0; j < chh.length; j++) {
                strs[j] = String.valueOf(chh[j]);
            }
            Arrays.sort(strs, new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    return costs.get(o1.charAt(0)-'A') - costs.get(o2.charAt(0)-'A');
                }
            });

            StringBuilder bb = new StringBuilder();
            for(String s: strs){
                bb.append(s);
            }
            people[i] = bb.toString();
        }

        Arrays.sort(people, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });

        int totalCost = 0;
        int notSettled = 0;
        for (int i = 0; i < N; i++) {
            boolean settled = false;
            for (char ac : people[i].toCharArray()) {
                if (activities[ac - 'A'][0] != 0) {
                    settled = true;
                    totalCost += activities[ac - 'A'][1];
                    activities[ac - 'A'][0]--;
                    break;
                }
            }
            if (!settled) notSettled++;
        }

        System.out.println(notSettled > 0 ? "NO" : "YES");
        System.out.println(notSettled > 0 ? N - notSettled : totalCost);
    }
}
