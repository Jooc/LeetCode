from typing import List


class Solution:
    def main(self):
        print(self.numSubarrayProductLessThanK([10, 5, 2, 6], 100))

    # TL
    def numSubarrayProductLessThanK_0(self, nums: List[int], k: int) -> int:
        right = 0
        ans = 0
        while right < len(nums):
            left = 0
            mul = 1
            for i in range(left, right + 1):
                mul *= nums[i]
            while left <= right and mul >= k:
                mul //= nums[left]
                left += 1
            ans += right - left + 1
            right += 1
        return ans

    def numSubarrayProductLessThanK(self, nums: List[int], k: int) -> int:
        left, right, mul = 0, 0, 1
        ans = 0
        while right < len(nums):
            mul *= nums[right]
            while left <= right and mul >= k:
                mul //= nums[left]
                left += 1
            ans += right - left + 1
            print(ans)
            right += 1
        return ans
