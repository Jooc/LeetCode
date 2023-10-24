package com.jooc.GazeOffer.Interview;

import java.util.*;

public class ByteDance_1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();

        StringBuilder res = new StringBuilder();

        int[] a = new int[m];
        for (int i = 0; i < m; i++) {
            a[i] = in.nextInt();
        }

        for (int i = 0; i < m; i++) {
            double t = (double) n / (m-i);
            if (t == a[i]) {
                res.append('=');
            } else if (a[i] > t) {
                res.append('>');
            } else {
                res.append('<');
            }
            n -= a[i];
        }

        System.out.println(res.toString());
    }
}
