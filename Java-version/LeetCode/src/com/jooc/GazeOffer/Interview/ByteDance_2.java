package com.jooc.GazeOffer.Interview;

import java.util.Arrays;
import java.util.Scanner;

public class ByteDance_2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        char[] chars = in.nextLine().toCharArray();

        int[] count = new int[10];
        int bitSum = 0;
        for (int i = 0; i < chars.length; i++) {
            bitSum += chars[i] - '0';
            count[chars[i] - '0']++;
        }

        while (bitSum % 3 != 0 && bitSum>0) {
            int left = bitSum % 3;

            if (left == 2) {
                for (int i : new int[]{2, 5, 8}) {
                    if (count[i] > 0) {
                        count[i]--;
                        bitSum -= i;
                        break;
                    }
                }
                if (bitSum % 3 != 0) {
                    for (int i : new int[]{1, 4, 7}) {
                        if (count[i] > 0) {
                            count[i]--;
                            bitSum -= i;
                            break;
                        }
                    }
                }
            } else {
                for (int i : new int[]{1, 4, 7}) {
                    if (count[i] > 0) {
                        count[i]--;
                        bitSum -= i;
                        break;
                    }
                }
            }
        }
        if(bitSum==0){
            System.out.println(-1);
        }

//        System.out.println(bitSum);
//        System.out.println(Arrays.toString(count));

        StringBuilder res = new StringBuilder();
        for (int i : new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 0}) {
            while(count[i] > 0){
                res.append(i);
                count[i]--;
            }
        }
        System.out.println(res);
    }
}
