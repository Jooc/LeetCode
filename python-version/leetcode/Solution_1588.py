from typing import List


class Solution:
    def main(self):
        print(self.sumOddLengthSubarrays_1([1, 4, 2, 5, 3]))

    # directly
    def sumOddLengthSubarrays_0(self, arr: List[int]) -> int:
        res = 0
        len_arr = len(arr)
        for i in range(len_arr):
            size = 1
            while i + size <= len_arr:
                res += sum(arr[i:i + size])
                size += 2

        return res

    # Prefix Sum
    def sumOddLengthSubarrays_1(self, arr: List[int]) -> int:
        prefix_sum = [0]
        for num in arr:
            prefix_sum.append(prefix_sum[-1] + num)

        res = 0
        for i in range(len(arr)):
            size = 1
            while i + size <= len(arr):
                res += prefix_sum[i+size] - prefix_sum[i]
                size += 2

        return res
