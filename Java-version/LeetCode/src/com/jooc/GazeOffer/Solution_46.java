package com.jooc.GazeOffer;

public class Solution_46 implements Solution {

    @Override
    public void main() {
        System.out.println(translateNum(12258));
    }

    int count = 0;

    public int translateNum_0(int num) {
        recur(num);
        return count;
    }

    private void recur(int currentNum) {
        if (currentNum == 0) {
            count++;
            return;
        }

        if (currentNum % 10 >= 0) {
            recur(currentNum / 10);
        }
        if (currentNum % 100 > 9 && currentNum % 100 < 26) {
            recur(currentNum / 100);
        }
    }

    public int translateNum(int num) {
        String digits = String.valueOf(num);
        int a = 1, b = 1;

        for (int i = 1; i < digits.length(); i++) {
            int val = Integer.valueOf(digits.substring(i-1, i+1));
            int c = val >= 10 && val <= 25 ? a + b : b;
            a = b;
            b = c;
        }

        return b;
    }
}
