from typing import List


class Solution_53:
    def maxSubArray(self, nums: List[int]) -> int:
        dp = nums[0]
        res = dp
        for i in range(1, len(nums)):
            dp = max(dp + nums[i], nums[i])
            res = max(res, dp)

        return res
