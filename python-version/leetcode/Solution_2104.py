import sys
from cmath import inf
from typing import List


class Solution:
    def subArrayRanges_0(self, nums: List[int]) -> int:
        ans = 0
        for i in range(len(nums)):
            minV, maxV = inf, -inf
            for j in range(i, len(nums)):
                minV = min(minV, nums[j])
                maxV = max(maxV, nums[j])
                ans += maxV - minV

        return ans