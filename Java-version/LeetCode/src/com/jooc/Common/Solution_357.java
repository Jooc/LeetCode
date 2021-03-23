package com.jooc.Common;

public class Solution_357 {
    public int countNumbersWithUniqueDigits_0(int n) {
        int[] count = new int[n+1 < 2 ? 2 : n+1];
        count[0] = 1;
        count[1] = 10;

        for(int i = 2; i <= n && i <= 10; i++){
            count[i] = 9;
            int num = 9;
            for(int j = i - 1; j > 0; j--){
                count[i] *= num--;
            }
            count[i] = count[i] + count[i-1];
        }

        return count[n];
    }

    public int countNumbersWithUniqueDigits(int n){
        if(n == 0) return 1;
        int pre = 1, cur = 10;

        for(int i = 1; i <= n && i <= 10; i++){
            cur = 9;
            int num = 9;
            for(int j = i - 1; j > 0; j--){
                cur *= num--;
            }
            cur = cur + pre;
            pre = cur;
        }

        return cur;
    }
}
