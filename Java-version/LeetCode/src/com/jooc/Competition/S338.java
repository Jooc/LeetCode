package com.jooc.Competition;

import com.jooc.Solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class S338 implements Solution {
    @Override
    public void main() {
//        System.out.println(primeSubOperation(new int[]{4, 9, 6, 10}));
        System.out.println(minOperations(new int[]{3, 1, 6, 8}, new int[]{1, 5}));
        System.out.println(minOperations(new int[]{3, 1, 6, 8}, new int[]{5, 1}));
        System.out.println(minOperations(new int[]{2, 0, 6, 8}, new int[]{1, 5}));
        System.out.println(minOperations(new int[]{2, 9, 6, 3}, new int[]{10}));
        System.out.println(minOperations(new int[]{47, 50, 97, 58, 87, 72, 41, 63, 41, 51, 17, 21, 7, 100, 69, 66, 79, 92, 84, 9, 57, 26, 26, 28, 83, 38}, new int[]{50, 84, 76, 41, 64, 82, 20, 22, 64, 7, 38, 92, 39, 28, 22, 3, 41, 46, 47, 50, 88, 51, 9, 49, 38, 67, 26, 65, 89, 27, 71, 25, 77, 72, 65, 41, 84, 68, 51, 26, 84, 24, 79, 41, 96, 83, 92, 9, 93, 84, 35, 70, 74, 79, 37, 38, 26, 26, 41, 26}));
    }

    public int kItemsWithMaximumSum(int numOnes, int numZeros, int numNegOnes, int k) {
        if (numOnes >= k) return k;
        else if (numZeros >= k - numOnes) {
            return numOnes;
        } else {
            return numOnes - (k - numOnes - numZeros);
        }
    }

    private static boolean isPrime(int x) {
        if (x <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(x); i++) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }

    public boolean primeSubOperation(int[] nums) {
        int n = nums.length;
        boolean valid = true;
        for (int i = 1; i < n; i++) {
            if (nums[i] <= nums[i - 1]) {
                valid = false;
                break;
            }
        }
        if (valid) return true;

        for (int j = nums[0] - 1; j >= 2; j--) {
            if (isPrime(j)) {
                nums[0] = nums[0] - j;
                break;
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = nums[i] - 1; j >= 2; j--) {
                if (nums[i] - j <= nums[i - 1]) continue;
                if (isPrime(j)) {
                    nums[i] = nums[i] - j;
                    break;
                }
            }
        }
        System.out.println(Arrays.toString(nums));

        for (int i = 1; i < n; i++) {
            if (nums[i] <= nums[i - 1]) {
                return false;
            }
        }
        return true;
    }

    public List<Long> minOperations(int[] nums, int[] queries) {

        List<Long> res = new ArrayList<>();

        Arrays.sort(nums);

        long temp = 0;
        for (int num : nums) {
            temp += Math.abs(num - queries[0]);
        }
        res.add(temp);

        int preIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > queries[0]) {
                preIndex = i;
                break;
            }
        }

        for (int i = 1; i < queries.length; i++) {
            int left = 0, right = nums.length - 1;
            while (left < right) {
                int mid = (left + right) / 2;
                if (nums[mid] <= queries[i])
                    left = mid + 1;
                else
                    right = mid;
//                System.out.println(left + " " + right);
            }
            System.out.println(preIndex + " " + left);
            temp = Math.max(res.get(i-1) - (long) (nums.length - left - preIndex) * (queries[i] - queries[i - 1]), 0);
            for (int j = preIndex; j < left; j++) {
                temp += (queries[i] - nums[j]) - (nums[j] - queries[i-1]);
            }
            res.add(temp);
            preIndex = left;
        }
        return res;
    }
}
