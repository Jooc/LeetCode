from typing import List


class Solution:
    def minStartValue(self, nums: List[int]) -> int:
        min_sum, total_sum = 0, 0
        for num in nums:
            total_sum += num
            min_sum = min(min_sum, total_sum)

        return 0 if min_sum > 0 and total_sum > 0 else 1 - min_sum
