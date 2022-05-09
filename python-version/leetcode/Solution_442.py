from typing import List


class Solution:
    def main(self):
        print(self.findDuplicates([4, 3, 2, 7, 8, 2, 3, 1]))

    def findDuplicates(self, nums: List[int]) -> List[int]:
        for i in range(len(nums)):
            while nums[i] != nums[nums[i] - 1]:
                nums[nums[i] - 1], nums[i] = nums[i], nums[nums[i] - 1]
                print(nums)
        print(nums)
        return [num for i, num in enumerate(nums) if num - 1 != i]
