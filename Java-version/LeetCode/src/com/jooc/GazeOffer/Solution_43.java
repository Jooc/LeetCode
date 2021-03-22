package com.jooc.GazeOffer;

public class Solution_43 implements Solution {

    public void main(){
        System.out.println(countDigitOne(12));
    }

    // Time Limited
    public int countDigitOne_0(int n) {

        int count = 0;
        for(int i = 1; i <= n; i++){
            int num = i;
            while(num != 0){
                if(num % 10 == 1){
                    count++;
                }
                num /= 10;
            }
        }

        return count;
    }

    public int countDigitOne(int n){
        int count = 0;

        int high = n / 10;
        int cur = n % 10;
        int low = 0;

        int digit = 1;

        while(high != 0 || cur != 0){
            if(cur == 0){
                count += high * digit;
            }
            else if(cur == 1){
                count += high * digit + low + 1;
            }
            else{
                count += (high+1) * digit;
            }

            low = low + cur * digit;
            cur = high % 10;
            high /= 10;
            digit *= 10;
        }

        return count;
    }

}
