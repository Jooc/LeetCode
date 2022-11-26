from typing import List


class Solution:
    def partitionDisjoint(self, nums: List[int]) -> int:
        n = len(nums)

        min_right = [0] * n
        min_right[-1] = nums[-1]
        for i in range(n - 2, 0, -1):
            min_right[i] = min(min_right[i + 1], nums[i])

        max_left = nums[0]
        for i in range(1, n):
            if max_left <= min_right[i]:
                return i
            max_left = max(max_left, nums[i])
