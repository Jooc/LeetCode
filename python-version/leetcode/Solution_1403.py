from typing import List


class Solution:
    def minSubsequence(self, nums: List[int]) -> List[int]:
        s = sum(nums)
        nums.sort(reverse=True)

        ans = []
        for i in range(len(nums)):
            ans.append(nums[i])
            if 2 * sum(ans) > s:
                return ans

        return nums