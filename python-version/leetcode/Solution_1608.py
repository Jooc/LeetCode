from typing import List


class Solution:
    def specialArray(self, nums: List[int]) -> int:
        nums.sort(reverse=True)
        n = len(nums)

        for i in range(1, n):
            if nums[i - 1] >= i > nums[i]:
                return i
        if nums[-1] >= n:
            return n

        return -1