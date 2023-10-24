package com.jooc.interview;

import java.util.ArrayList;
import java.util.Scanner;

public class meituan1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别

        int n = in.nextInt();
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i = 0; i < n; i++){
            list.add(in.nextInt());
        }

        int sum = 0;
        boolean flag = false;
        for(int i = 0; i < n-1; i++){
            if(list.get(i) == -1 && list.get(i+1) == -1){
                flag = true;
            }
            sum+=list.get(i);
        }
        sum+=list.get(list.size()-1);
        if(sum == n){
            System.out.println("" + (sum-4));
        }else {
            System.out.println("" + (flag ? sum + 4 : sum));
        }
    }
}
