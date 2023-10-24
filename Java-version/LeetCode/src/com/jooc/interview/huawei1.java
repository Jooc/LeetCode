package com.jooc.interview;
// We have imported the necessary tool classes.
// If you need to import additional packages or classes, please import here.

import java.util.Scanner;
import java.util.Stack;

public class huawei1 {
    public static void main(String[] args) {
    // please define the JAVA input here. For example: Scanner s = new Scanner(System.in);
    // please finish the function body here.
    // please define the JAVA output here. For example: System.out.println(s.nextInt());
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] nums = new int[n];

        if(n == 0) {
            System.out.println(0);
            return;
        }

        for(int i = 0; i < n; i++){
            nums[i] = in.nextInt();
        }

        Stack<Integer> stack = new Stack<>();

        int res = 0;
        for(int num: nums){
            while(!stack.isEmpty() && stack.peek() > num){
                stack.pop();
            }
            if(!stack.isEmpty()){
                res += stack.peek();
            }
            stack.push(num);
        }

        // System.out.println(Arrays.toString(nums));
        System.out.println(res);

    }
}
