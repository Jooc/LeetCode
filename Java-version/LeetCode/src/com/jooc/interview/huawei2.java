package com.jooc.interview;
// We have imported the necessary tool classes.
// If you need to import additional packages or classes, please import here.

import java.util.ArrayList;
import java.util.Scanner;

public class huawei2 {
    public static void main(String[] args) {
    // please define the JAVA input here. For example: Scanner s = new Scanner(System.in);
    // please finish the function body here.
    // please define the JAVA output here. For example: System.out.println(s.nextInt());
        Scanner in = new Scanner(System.in);

        String rawStr1 = in.nextLine();
        String[] str1 = rawStr1.substring(1, rawStr1.length() - 1).split(" ");
        String rawStr2 = in.nextLine();
        String[] str2 = rawStr2.substring(1, rawStr2.length() - 1).split(" ");
        String op = in.nextLine();

        int n1 = str1.length;
        int n2 = str2.length;

        int[] nums1 = new int[n1];
        for(int i = 0; i < n1; i++){
            nums1[i] = Integer.parseInt(str1[i]);
        }
        //System.out.println(Arrays.toString(nums1));

        int[] nums2 = new int[n2];
        for(int i = 0; i < n2; i++){
            nums2[i] = Integer.parseInt(str2[i]);
        }
        //System.out.println(Arrays.toString(nums2));

        // System.out.println(op);

        ArrayList<Integer> res = new ArrayList<>();

        if(op.equals("+") || op.equals("-")){
            int minus = op.equals("+") ? 1 : -1;

            //int[] res = new int[Math.max(n1, n2)];
            //int idx = res.length - 1;

            int idx1 = n1 - 1;
            int idx2 = n2 - 1;

            while(idx1 >= 0 && idx2 >= 0){
                //res[idx--] = nums1[idx1--] + minux * nums2[idx2--];
                res.add(nums1[idx1--] + minus * nums2[idx2--]);
            }
            while(idx1 >= 0){
               // res[idx--] = nums1[idx1--];
                res.add(nums1[idx1--]);
            }
            while(idx2 >= 0){
                //res[idx--] = nums1[idx2--];
                res.add(nums1[idx2--]);
            }

            // output
            for(int i = res.size() - 1; i > 0; i--){
                // System.out.print(res.get(i));
                if(res.get(i) == 0){
                    res.remove(i);
                }else{
                    break;
                }
            }

            System.out.print("[");
            for(int i = res.size() - 1; i >= 0; i--){
                System.out.print(res.get(i));
                if(i != 0){
                    System.out.print(" ");
                }
            }
            System.out.print("]");
        }else{
            for(int i = 0; i <= n1 + n2 - 2; i++){
                res.add(0);
            }
            for(int i = n1 - 1; i >= 0; i--){
                for(int j = n2 - 1; j >= 0; j--){
                    res.set(i + j, res.get(i+j) + nums1[i] * nums2[j]);
                    // 进位
                }
            }

            for(int i = 0; i < res.size(); i++){
                // System.out.print(res.get(i));
                if(res.get(i) == 0){
                    res.remove(i);
                }else{
                    break;
                }
            }

            System.out.print("[");
            for(int i = 0; i < res.size(); i++){
                System.out.print(res.get(i));
                if(i != res.size()-1){
                    System.out.print(" ");
                }
            }
            System.out.print("]");
        }
    }
}
