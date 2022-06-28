from typing import  List

class Solution:
    def main(self):
        self.wiggleSort([1,5,1,1,6,4])

    def wiggleSort(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        temp = sorted(nums)
        for i in range(len(nums)):
            if i % 2:
                nums[i] = temp[-i//2]
            else:
                nums[i] = temp[i//2]

        print(nums)


