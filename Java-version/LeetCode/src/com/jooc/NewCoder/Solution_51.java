package com.jooc.NewCoder;

import com.jooc.Solution;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Solution_51 implements Solution {

    @Override
    public void main() {
        System.out.println(MoreThanHalfNum_Solution(new int[]{1,2,3,2,2,2,5,4,2}));
    }

    public int MoreThanHalfNum_Solution_0(int[] array) {
        int candidate = -1, count = 0;
        for (int num : array) {
            if (count == 0) {
                candidate = num;
                count++;
            } else {
                if (candidate == num) count++;
                else count--;
            }
        }
        return candidate;
    }

    public int MoreThanHalfNum_Solution(int[] array) {
        HashMap<Integer, Integer> count = new HashMap<>();
        for(int num: array){
            if (count.containsKey(num)){
                count.put(num, count.get(num)+1);
            }else{
                count.put(num, 1);
            }
        }
        int maxCount = Integer.MIN_VALUE, maxVal = 0;
        Iterator<Map.Entry<Integer, Integer>>it = count.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry<Integer, Integer> entry = it.next();
            if(entry.getValue() > maxCount){
                maxVal = entry.getKey();
                maxCount = entry.getValue();
            }
        }
        return maxVal;
    }
}
