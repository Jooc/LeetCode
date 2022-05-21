from typing import List


class Solution:
    def repeatedNTimes(self, nums: List[int]) -> int:
        s = set()
        for num in nums:
            if num in s:
                return num
            s.add(num)
        return nums[-1]