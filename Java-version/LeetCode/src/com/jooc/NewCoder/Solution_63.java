package com.jooc.NewCoder;

import com.jooc.Solution;

public class Solution_63 implements Solution {
    @Override
    public void main() {

    }

    public int jumpFloor_0(int target) {
        if(target <= 2) return target;
        return jumpFloor(target - 1) + jumpFloor(target - 2);
    }

    public int jumpFloor(int target) {
        if(target <= 2) return target;
        int a = 1, b = 2, c = 2;
        for(int i = 3; i <= target; i++){
            c = a+b;
            a = b;
            b = c;
        }
        return c;
    }
}
