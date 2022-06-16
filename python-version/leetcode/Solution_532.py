from typing import List


class Solution:
    def main(self):
        print(self.findPairs([3,1,4,1,5], 2))

    def findPairs_0(self, nums: List[int], k: int) -> int:
        nums.sort()
        left = 0
        ans = set()
        for right in range(len(nums)):
            while left < right:
                if nums[right] - nums[left] == k:
                    ans.add((nums[left], nums[right]))
                    left += 1
                elif nums[right] - nums[left] > k:
                    left += 1
                else:
                    break
        return len(ans)

    def findPairs(self, nums: List[int], k: int) -> int:
        visited, res = set(), set()
        for num in nums:
            if num - k in visited:
                res.add(num-k)
            if num + k in visited:
                res.add(num)
            visited.add(num)
        return len(res)

