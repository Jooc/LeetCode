package com.jooc.GazeOffer;

import com.jooc.Solution;

import java.util.LinkedList;

public class Solution_65 implements Solution {
    @Override
    public void main() {
        System.out.println(add_0(-1, 2));
    }

    // cannot add the minus num
    public int add_0(int a, int b) {
        int res = 0;
        boolean flag = false;

        LinkedList<Integer> stack = new LinkedList<>();

        while(a != 0 || b != 0){
            int x = a & 1, y = b & 1;

            if (flag){
                stack.push((~(x ^ y))&1);
                flag = x == 1 || y == 1;
            }else{
                stack.push(x ^ y);
                flag = x == 1 && y == 1;
            }

            a >>>= 1;
            b >>>= 1;
        }
        if(flag) stack.push(1);
        while(!stack.isEmpty()){
            res = (res << 1) + stack.pop();
        }

        return res;
    }

    public int add(int a, int b){
        while(b != 0){
            int carryBits = (a & b) << 1;
            a ^= b;
            b = carryBits;

        }

        return a;
    }

}
