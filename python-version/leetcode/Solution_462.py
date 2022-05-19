from typing import List


class Solution:
    def main(self):
        print(self.minMoves2([1,2,3]))

    def minMoves2(self, nums: List[int]) -> int:
        nums.sort()
        return sum([abs(num - nums[len(nums)//2]) for num in nums])

    def quick_select(self):
        pass