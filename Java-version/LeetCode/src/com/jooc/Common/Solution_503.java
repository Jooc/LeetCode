package com.jooc.Common;

import com.jooc.Solution;

import java.util.*;

public class Solution_503 implements Solution {
    @Override
    public void main() {
        System.out.println(Arrays.toString(nextGreaterElements(new int[]{1, 2, 1})));
    }

    public int[] nextGreaterElements_0(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];

        Arrays.fill(res, -1);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (nums[(i + j) % n] > nums[i]) {
                    res[i] = nums[(i + j) % n];
                    break;
                }
            }
        }
        return res;
    }

    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res, -1);

        LinkedList<Integer> stack = new LinkedList<>();

        for(int i = 0; i < 2*n; i++){
            while(!stack.isEmpty() && nums[i%n] > nums[stack.peekLast()]){
                res[stack.pollLast()] = nums[i%n];
            }
            stack.addLast(i%n);
        }
        return res;
    }

//    public int[] nextGreaterElements(int[] nums) {
//        int n = nums.length;
//        int[] ans = new int[n];
//        Arrays.fill(ans, -1);
//        Deque<Integer> d = new ArrayDeque<>();
//
//        for (int i = 0; i < n * 2; i++) {
//            while (!d.isEmpty() && nums[i % n] > nums[d.peekLast()]) {
//                int u = d.pollLast();
//                ans[u] = nums[i % n];
//            }
//            d.addLast(i % n);
//        }
//        return ans;
//    }

}
