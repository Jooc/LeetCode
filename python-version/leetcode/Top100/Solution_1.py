from typing import List


class Solution:
    def main(self):
        print(self.twoSum([1,2,3], 5))

    def twoSum(self, nums: List[int], target: int) -> List[int]:
        hashtable = dict()
        for (i, num) in enumerate(nums):
            if target - num in hashtable:
                return [i, hashtable[target - num]]
            hashtable[num] = i

        return []