from typing import List

class Solution:
    def arrayNesting(self, nums: List[int]) -> int:
        ans = 0
        vis = [False] * len(nums)
        for i in range(len(nums)):
            count = 0
            while not vis[i]:
                vis[i] = True
                i = nums[i]
                count += 1
            ans = max(ans, count)
        return ans



