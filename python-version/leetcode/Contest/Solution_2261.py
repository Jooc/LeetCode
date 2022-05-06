from typing import List


class Solution:
    def main(self):
        print(self.countDistinct([2, 3, 3, 2, 2], 2, 2))

    def countDistinct(self, nums: List[int], k: int, p: int) -> int:
        s, n = set(), len(nums)
        for i in range(n):
            count = int(nums[i] % p == 0)
            for j in range(i, n):
                if i != j and nums[j] % p == 0:
                    count += 1
                if count > k:
                    break
                print(nums[i:j + 1])
                s.add(tuple(nums[i:j + 1]))
        return len(s)
