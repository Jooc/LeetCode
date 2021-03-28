package com.jooc.Common;

import com.jooc.Solution;

public class Solution_5715 implements Solution {

    @Override
    public void main() {
        System.out.println(reinitializePermutation(2));
    }

    int[] perm;
    public int reinitializePermutation(int n) {
        int[] initialPerm = new int[n];
        for(int i = 0; i < n; i++){
            initialPerm[i] = i;
        }

        perm = initialPerm;
        calculate();

        int count = 1;
        while(!equals(perm, initialPerm)){
            calculate();
            count++;
        }

        return count;
    }


    public boolean equals(int[] arr, int[] perm){
        for(int i = 0; i < arr.length; i++){
            if(arr[i] != perm[i]){
                return false;
            }
        }
        return true;
    }

    public void calculate(){
        int[] arr = new int[perm.length];
        for(int i = 0;i < perm.length; i++){
            if(i % 2 == 0){
                arr[i] = perm[i/2];
            }else{
                arr[i] = perm[perm.length / 2 + (i - 1) / 2];
            }
        }
        perm = arr;
    }

}
