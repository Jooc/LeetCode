package com.jooc.Common;

import com.jooc.Solution;

import java.util.ArrayList;
import java.util.List;

public class Solution_902 implements Solution {
    @Override
    public void main() {

    }

    int[] nums;

    private int dp(int x) {
        List<Integer> list = new ArrayList<>();
        while (x != 0) {
            list.add(x % 10);
            x /= 10;
        }
        int n = list.size(), m = nums.length, ans = 0;
        for (int i = n - 1; i >= 0; i--) {
            int cur = list.get(i);
            int l = 0, r = m - 1;
            while (l < r) {
                int mid = (l + r + 1) >> 1;
                if (nums[mid] <= cur) l = mid;
                else r = mid - 1;
            }
            if (nums[r] > cur) {
                break;
            } else if (nums[r] == cur) {
                ans += r * (int) Math.pow(m, i);
                if(i == 0) ans++;
            } else if (nums[r] < cur) {
                ans += (r + 1) * (int) Math.pow(m, i);
                break;
            }
        }
        for (int i = 1, last = 1; i < n; i++) {
            int cur = last * m;
            ans += cur;
            last = cur;
        }
        return ans;
    }

    public int atMostNGivenDigitSet(String[] digits, int n) {

        int m = digits.length;
        nums = new int[m];

        for (int i = 0; i < m; i++) {
            nums[i] = Integer.parseInt(digits[i]);
        }
        return dp(n);
    }
}
