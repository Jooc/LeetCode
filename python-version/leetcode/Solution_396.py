from typing import List


class Solution:
    def main(self):
        print(self.maxRotateFunction([4,3,2,6]))

    # Time Limit
    def maxRotateFunction_0(self, nums: List[int]) -> int:
        n = len(nums)
        nums *= 2
        ans = [sum(k * nums[start+k] for k in range(n)) for start in range(n)]

        return max(ans)

    def maxRotateFunction(self, nums: List[int]) -> int:
        n, sum_num = len(nums), sum(nums)
        f = 0
        for i in range(n):
            f += i * nums[i]
        ans = f
        for i in range(1, n):
            f = f + sum_num - n * nums[n-i]
            ans = max(ans, f)

        return ans