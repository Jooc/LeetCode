from typing import List


class Solution:
    def main(self):
        print(self.minPairSum([3, 5, 4, 2, 4, 6]))

    def minPairSum(self, nums: List[int]) -> int:
        nums_len = len(nums)
        nums.sort()
        res = 0
        for i in range(nums_len // 2):
            res = max(res, (nums[i] + nums[nums_len - 1 - i]))
        return res
